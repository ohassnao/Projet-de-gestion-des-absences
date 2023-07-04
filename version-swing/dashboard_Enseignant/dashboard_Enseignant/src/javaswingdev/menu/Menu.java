package javaswingdev.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.swing.scroll.ScrollBar;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import database.DatabaseConnection;
import net.miginfocom.swing.MigLayout;
import database.DatabaseConnection;
public class Menu extends JPanel {

    private int index = -1;
    private final List<EventMenuSelected> events = new ArrayList<>();
    public JButton addButton;

    public Menu(String nom_ens) {
        init(nom_ens);
    }
    
    private void init(String nom_ens) {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        JScrollPane scroll = createScroll();
        panelMenu = createPanelMenu();
        scroll.setViewportView(panelMenu);
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        add(scroll);
        String user = nom_ens;
        addTitle("Welcome, "+user.toUpperCase()+"!");
        addTitle("MAIN");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DASHBOARD, "Dashboard"));
        addTitle("WEB APPS");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.MAIL_OUTLINE, "Email", "Inbox", "Compose"));
        //addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.MESSAGE, "Modules", "Computer Science"));

        ModelMenuItem menuItem = new ModelMenuItem(GoogleMaterialDesignIcon.MESSAGE, "Liste Etudiants");
        List<ModelMenuItem> subMenuItems = new ArrayList<>();
        DatabaseConnection connection = DatabaseConnection.getInstance();
        try {
            Connection conn = connection.getConnection();
            
    	    PreparedStatement pstmt1 = conn.prepareStatement("SELECT id_enseignant FROM enseignants WHERE nom_ens = ? LIMIT 1");
    	    pstmt1.setString(1, nom_ens);
    	    ResultSet rs2 = pstmt1.executeQuery();
    	    int ensID = 0;
    	    if (rs2.next()) {
    	        ensID = rs2.getInt("id_enseignant");
    	    }
            
            // THIS NEEDS TO BE MODIFIED ACCORIDING TO THE PROFESSOR LOGED IN THE PAGE!!!
            PreparedStatement stmt1 = conn.prepareStatement("SELECT intitulé FROM module WHERE id_ens=?");
            stmt1.setInt(1, ensID);
            ResultSet rs = stmt1.executeQuery();

            while (rs.next()) {
                String subItemTitle = rs.getString("intitulé");
                ModelMenuItem subMenuItem = new ModelMenuItem(GoogleMaterialDesignIcon.MESSAGE, subItemTitle);
                subMenuItems.add(subMenuItem);
            }

            String[] subMenuTitles = subMenuItems.stream().map(ModelMenuItem::getMenuName).toArray(String[]::new);
            menuItem.setSubMenu(subMenuTitles);
        } catch (SQLException e) {
            // handle the exception
            e.printStackTrace();
        }
        
         addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.PERM_CONTACT_CALENDAR, "Calendar"));
         addTitle("MODULE INFOS");
         addMenuItem(menuItem);
         
         addTitle("ABSENCE");
         // This is a nice CODE :) I used the already generated array in this area as well!
         for(int i = 0; i < subMenuItems.size(); i++) {
             ModelMenuItem menuModule = new ModelMenuItem(GoogleMaterialDesignIcon.MESSAGE, subMenuItems.get(i).getMenuName());
             String[] subMenuTitles = {"Check Absence", "Ajout Notes"};
             menuModule.setSubMenu(subMenuTitles);
             addMenuItem(menuModule);
         }
  
        addTitle("PAGES");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.INBOX, "Special Pages", "Faq", "Timeline"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.LOCK_OUTLINE, "Authentication", "Logout", "Login"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.ERROR_OUTLINE, "Redirection", "WebVersion", "AppVersion"));
        
    }	

    private JScrollPane createScroll() {
        JScrollPane scroll = new JScrollPane();
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVerticalScrollBar(new ScrollBar());
        return scroll;
    }

    private JPanel createPanelMenu() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        menuLayout = new MigLayout("wrap,fillx,inset 0,gapy 0", "[fill]");
        panel.setLayout(menuLayout);

        return panel;
    }

    private JPanel createMenuItem(ModelMenuItem item) {
        MenuItem menuItem = new MenuItem(item, ++index, menuLayout);
        menuItem.addEvent(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, int indexSubMenu) {
                if (!menuItem.isHasSubMenu() || indexSubMenu != 0) {
                    clearSelected();
                    setSelectedIndex(index, indexSubMenu);
                }
            }
        });
        return menuItem;
    }

    private void runEvent(int index, int indexSubMenu) {
        for (EventMenuSelected event : events) {
            event.menuSelected(index, indexSubMenu);
        }
    }

    //  Public Method
    public void addMenuItem(ModelMenuItem menu) {
        panelMenu.add(createMenuItem(menu), "h 35!");
    }

    public void addTitle(String title) {
        JLabel label = new JLabel(title);
        label.setBorder(new EmptyBorder(15, 20, 5, 5));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setForeground(new Color(170, 170, 170));
        panelMenu.add(label);
    }

    public void addBoldTitle(String title) {
        JLabel label = new JLabel(title);
        label.setBorder(new EmptyBorder(15, 20, 5, 5));
        label.setFont(label.getFont().deriveFont(Font.BOLD));
        label.setForeground(new Color(0, 0, 0));
        panelMenu.add(label);
        // Add an ActionListener to the label
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (title.equalsIgnoreCase("UPDATE") || title.equalsIgnoreCase("CREATE") || title.equalsIgnoreCase("DELETE")) {
                    System.out.println("Welcome!");
                }
            }
        });
    }
    
    
    public void addSpace(int size) {
        panelMenu.add(new JLabel(), "h " + size + "!");
    }

    public void setSelectedIndex(int index, int indexSubMenu) {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                if (item.getIndex() == index) {
                    item.setSelectedIndex(indexSubMenu);
                    runEvent(index, indexSubMenu);
                    break;
                }
            }
        }
    }

    public void clearSelected() {
        for (Component com : panelMenu.getComponents()) {
            if (com instanceof MenuItem) {
                MenuItem item = (MenuItem) com;
                item.clearSelected();
            }
        }
    }

    public void addEvent(EventMenuSelected event) {
        events.add(event);
    }

    private MigLayout menuLayout;
    private JPanel panelMenu;

	public int getMenuItemCount() {
		// TODO Auto-generated method stub
		return 0;
	}
}
