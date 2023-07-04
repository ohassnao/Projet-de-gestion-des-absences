	package javaswingdev.form;
	
	import java.awt.Component;
import java.awt.Dimension;
	import java.awt.GridBagConstraints;
	import java.awt.GridBagLayout;
	import java.awt.GridLayout;
	import java.awt.Insets;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.ArrayList;
	import java.util.List;

	import javax.swing.Box;
	import javax.swing.BoxLayout;
	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	
	import database.DatabaseConnection;
	import javaswingdev.GoogleMaterialDesignIcon;
	import javaswingdev.menu.ModelMenuItem;
	
	public class Check_Absence extends javax.swing.JPanel {
		

	    public Check_Absence(String nom_ens, int index) {
	        initComponents();
	        lb.setText("Check Absence");
	        addButtonPanel(nom_ens, index);
	    }
	    
	    public void addButtonPanel(String nom_ens, int index) {

	        JPanel buttonPanel = new JPanel(new GridLayout(0, 2, 10, 10));
	        JLabel nomEtdLabel = new JLabel("Nom de l'Etudiant:");
	        JTextField nomEtdField = new JTextField();
	        JLabel justificationLabel = new JLabel("Justification? (non/oui)");
	        JTextField justificationField = new JTextField();
	        JLabel dateAbsenceLabel = new JLabel("Date d'Absence:");
	        JTextField dateAbsenceField = new JTextField();
	        JButton insertButton = new JButton("INSERT");

	        buttonPanel.add(nomEtdLabel);
	        buttonPanel.add(nomEtdField);
	        buttonPanel.add(justificationLabel);
	        buttonPanel.add(justificationField);
	        buttonPanel.add(dateAbsenceLabel);
	        buttonPanel.add(dateAbsenceField);
	        buttonPanel.add(Box.createHorizontalGlue());
	        buttonPanel.add(insertButton);
	        List<String> ModuleList = new ArrayList<>();
	        
            try {
    	        DatabaseConnection connection = DatabaseConnection.getInstance();
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
	                ModuleList.add(rs.getString("intitulé"));
	            }

	        } catch (SQLException ex) {
	        }
	        
	        
	        insertButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                try {
	        	        	String justificatif;
		        	        DatabaseConnection connection = DatabaseConnection.getInstance();
	        	            Connection conn = connection.getConnection();
	        	            
	        	            if(justificationField.getText() == "oui") {
	        	            	justificatif = "Justifié";
	        	            }
	        	            else {
	        	            	justificatif = "Non Justifié";
	        	            }
	        	            
	        	            
	        	            PreparedStatement stmt2 = conn.prepareStatement("SELECT id_etd FROM etudiants WHERE nom = ?");
	        	            stmt2.setString(1, nomEtdField.getText());
	        	            ResultSet res = stmt2.executeQuery();
	        	            int EtdId=0;
	        	            while(res.next()){EtdId = res.getInt("id_etd");}
	        	            
	        	            PreparedStatement query_Id_Module = conn.prepareStatement("SELECT id_module FROM module WHERE intitulé=?");
	        	            query_Id_Module.setString(1, ModuleList.get(index-4));
	        	            ResultSet res_Query = query_Id_Module.executeQuery();
	        	            int ModuleId = 0;
	        	            while(res_Query.next()) {ModuleId = res_Query.getInt("id_module");}
	        	            
	        	            // Find the maximum ID from the absence table
	        	            Statement stmtMaxId = conn.createStatement();
	        	            ResultSet rsMaxId = stmtMaxId.executeQuery("SELECT MAX(id_absence) FROM absence");
	        	            int maxId = 0;
	        	            if (rsMaxId.next()) {
	        	                maxId = rsMaxId.getInt(1);
	        	            }
		        	           
		                    // Insert the record into the "absence" table
		                    PreparedStatement stmt3 = conn.prepareStatement("INSERT INTO absence (id_absence, date, type_absence, id_etd, id_module) VALUES (?, ?, ?, ?, ?)");
		                    stmt3.setInt(1, maxId + 1);
		                    stmt3.setString(2, dateAbsenceField.getText());
		                    stmt3.setString(3, justificatif);
		                    stmt3.setInt(4, EtdId);
		                    stmt3.setInt(5, ModuleId);
		                    stmt3.executeUpdate();
	
		                    // Display a success message
		                    JOptionPane.showMessageDialog(null, "Record inserted successfully.");

	                } catch (SQLException ex) {
	                    // Display an error message if there's a problem with the database
	                    JOptionPane.showMessageDialog(null, "Error inserting record: " + ex.getMessage());
	                }
	            }
	        });



	        // Set panel properties
	        buttonPanel.setOpaque(false);
	        buttonPanel.setAlignmentX(CENTER_ALIGNMENT);
	        
	        // Add label at the bottom of the panel
	        JLabel footerLabel = new JLabel("This is the Absence of "+ ModuleList.get(index-4));
	        footerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
	        buttonPanel.add(footerLabel);

	        // Add panel to the main panel
	        setLayout(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.gridx = 0;
	        gbc.gridy = 1;
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.insets = new Insets(10, 10, 10, 10);
	        gbc.anchor = GridBagConstraints.CENTER;
	        add(buttonPanel, gbc);
	    }
	    
	    
	    @SuppressWarnings("unchecked")
	    private void initComponents() {
	
	        lb = new javax.swing.JLabel();
	
	        setOpaque(false);
	
	        lb.setFont(new java.awt.Font("sansserif", 1, 48)); // NOI18N
	        lb.setForeground(new java.awt.Color(125, 125, 125));
	        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
	        lb.setText("Form");
	
	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	    }
	    private javax.swing.JLabel lb;
	    
	}
