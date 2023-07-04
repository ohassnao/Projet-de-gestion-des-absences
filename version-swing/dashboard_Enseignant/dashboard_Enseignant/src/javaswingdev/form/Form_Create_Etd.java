	package javaswingdev.form;
	
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
	
	public class Form_Create_Etd extends javax.swing.JPanel {
	
	    public Form_Create_Etd() {
	        initComponents();
	        lb.setText("Veuillez insérer les informations");
	        addButtonPanel();
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
	    
	    
	    
	    // Add buttons panel to the main panel
	    private void addButtonPanel() {

	
	        JPanel buttonPanel = new JPanel(new GridLayout(0, 4, 10, 10));
	        buttonPanel.add(Box.createHorizontalGlue());
	
	        // Create TextFields
	        JTextField nom = new JTextField("Nom");
	        JTextField DateNaissance = new JTextField("Date Absence");
	        JTextField module_1 = new JTextField("");
	        JTextField module_2 = new JTextField("Module 2");
	        JTextField module_3 = new JTextField("Module 3");
	        JButton insertButton = new JButton("INSERT");
	        // Add an Event Listener for the button
	     	insertButton.addActionListener(new ActionListener() {
	     		    public void actionPerformed(ActionEvent e) {
	
	     		        try {
	     		            // Create a connection to the database
	     		            DatabaseConnection connection = DatabaseConnection.getInstance();
	     		            Connection conn = connection.getConnection();


	     		            // Get the last inserted id_compte
	     		            String query = "SELECT id_etd FROM etudiants ORDER BY id_etd DESC LIMIT 1";
	     		            Statement getLastIdStmt = conn.createStatement();
	     		            ResultSet resultSet = getLastIdStmt.executeQuery(query);
	     		            int lastIdETD = 0;
	     		            if (resultSet.next()) {
	     		            	lastIdETD = resultSet.getInt("id_etd");
	     		            }
	     		            
	     		            // Close the ResultSet and the Statement
	     		            resultSet.close();
	     		            getLastIdStmt.close();
	     		           
	     		            
	     		            // Get the last inserted id_enseignant
	     		            String query1 = "SELECT id_ins FROM etudiants ORDER BY id_ins DESC LIMIT 1";
	     		            Statement getLastIdStmt1 = conn.createStatement();
	     		            ResultSet resultSet1 = getLastIdStmt1.executeQuery(query1);
	     		            int lastId1 = 0;
	     		            if (resultSet1.next()) {
	     		            	lastId1 = resultSet1.getInt("id_ins");
	     		            }
	     		            
	     		            // Close the ResultSet and the Statement
	     		            resultSet1.close();
	     		            getLastIdStmt1.close();
	     		            
	     		            // Insert the new enseignant into the enseignants table with the retrieved id_compte
	     		            PreparedStatement ensStat = conn.prepareStatement("INSERT INTO etudiants (id_etd, nom, prenom, date_Naissance, mail, id_ins) VALUES (?, ?, ?, ?, ?, ?)");
	     		            ensStat.setInt(1, lastIdETD+1);
	     		            ensStat.setString(2, nom.getText());
	     		            ensStat.setString(4, DateNaissance.getText());

	     		            ensStat.setInt(6, lastId1+1);
	     		            ensStat.executeUpdate();
	     		            ensStat.close();
	     		            
	     		            
	     		            // Insert Modules into posseder table
	     		            PreparedStatement queryX = conn.prepareStatement("INSERT INTO posseder(id_etd, id_module, note) VALUES(?, ?, ?)");
	     		            queryX.setInt(1, lastIdETD+1);
	     		            queryX.setInt(2, Integer.parseInt(module_1.getText()));
	     		            queryX.setInt(3, 0);
	     		            queryX.executeUpdate();
	     		            queryX.close();
	     		            PreparedStatement queryX1 = conn.prepareStatement("INSERT INTO posseder(id_etd, id_module, note) VALUES(?, ?, ?)");
	     		            queryX1.setInt(1, lastIdETD+1);
	     		            queryX1.setInt(2, Integer.parseInt(module_2.getText()));
	     		            queryX1.setInt(3, 0);
	     		            queryX1.executeUpdate();
	     		            queryX1.close();
	     		            PreparedStatement queryX2 = conn.prepareStatement("INSERT INTO posseder(id_etd, id_module, note) VALUES(?, ?, ?)");
	     		            queryX2.setInt(1, lastIdETD+1);
	     		            queryX2.setInt(2, Integer.parseInt(module_3.getText()));
	     		            queryX2.setInt(3, 0);
	     		            queryX2.executeUpdate();
	     		            queryX2.close();
	     		            
	     		            // Close the connection
	     		            conn.close();
	
	     		            // Display a message to confirm the insertion
	     		            JOptionPane.showMessageDialog(buttonPanel, "Etudiant inserted successfully!");
	     		        } catch (SQLException ex) {
	     		            ex.printStackTrace();
	     		            JOptionPane.showMessageDialog(buttonPanel, "Error: " + ex.getMessage());
	     		        }
	     		    }     
	     		});
	
	        buttonPanel.add(nom);
	        buttonPanel.add(DateNaissance);
	        buttonPanel.add(module_1);
	        buttonPanel.add(module_2);
	        buttonPanel.add(module_3);
	        buttonPanel.add(insertButton);
	
	        // Set panel properties
	        buttonPanel.setOpaque(false);
	        buttonPanel.setAlignmentX(CENTER_ALIGNMENT);
	
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
	
	
	    private javax.swing.JLabel lb;
	    
	}
