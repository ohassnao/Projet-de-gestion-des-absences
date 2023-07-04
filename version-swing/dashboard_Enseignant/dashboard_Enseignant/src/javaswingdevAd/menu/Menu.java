package javaswingdevAd.menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.GoogleMaterialDesignIcon;
import javaswingdev.swing.scroll.ScrollBar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class Menu extends JPanel {

    private int index = -1;
    private final List<EventMenuSelected> events = new ArrayList<>();
    public JButton addButton;

    public Menu() {
        init();
    }

    private void init() {
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        JScrollPane scroll = createScroll();
        panelMenu = createPanelMenu();
        scroll.setViewportView(panelMenu);
        scroll.getViewport().setOpaque(false);
        scroll.setViewportBorder(null);
        add(scroll);
        String user="ADMIN";
        addTitle("Welcome, "+user+"!");
        addTitle("MAIN");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DASHBOARD, "Dashboard"));
        addTitle("WEB APPS");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.MAIL_OUTLINE, "Email", "Inbox", "Compose"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.MESSAGE, "Modules"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.PERM_CONTACT_CALENDAR, "Etudiants"));
        addTitle("COMPONENT");
        // addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.WHATSHOT, "Chefs Departements", "Computer Science", "CyberSecurity", "Electrical Engineering", "Big Data"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DIRECTIONS_BIKE, "School Events", "OpenSource", "ElectroDays", "CyberDays", "Journées Renouvlables"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DVR, "Resources", "USMS", "Partenaires", "Associations"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.PIE_CHART_OUTLINED, "Attendance tracking", "API", "Cycle Ingénierie", "Master", "Phd"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.VIEW_LIST, "Faculty Infos", "Basic Tables", "Data Table"));
        //addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.INSERT_EMOTICON, "Icons", "Feather Icons", "Flag Icons", "Mdi Icons"));
        addTitle("PAGES");
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.INBOX, "Special Pages", "Faq", "Timeline"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.LOCK_OUTLINE, "Authentication", "Logout", "Login"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.ERROR_OUTLINE, "Redirection", "WebVersion", "AppVersion"));
        addMenuItem(new ModelMenuItem(GoogleMaterialDesignIcon.DVR, "CRUD", "Create", "Update", "Delete"));
        
        //addBoldTitle("UPDATE");addBoldTitle("CREATE");addBoldTitle("DELETE");
        
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
}
