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
	
	import javax.swing.Box;
	import javax.swing.BoxLayout;
	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JPanel;
	import javax.swing.JTextField;
	
	import database.DatabaseConnection;
	
	public class Form_Create_Ens extends javax.swing.JPanel {
	
	    public Form_Create_Ens() {
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
	        JTextField login = new JTextField("New Login");
	        JTextField password = new JTextField("New Password");
	        JTextField nom = new JTextField("Nom");
	        JTextField prenom = new JTextField("Prenom");
	        JTextField DateNaissance = new JTextField("Date Naissance");
	        JTextField Email = new JTextField("Email");
	        JTextField Fonction = new JTextField("Fonction");
	        JTextField Etat = new JTextField("Etat");
	        JTextField Statut = new JTextField("Statut");
	        JTextField Grade = new JTextField("Grade");
	        JButton insertButton = new JButton("INSERT");
	        // Add an Event Listener for the button
	     	insertButton.addActionListener(new ActionListener() {
	     		    public void actionPerformed(ActionEvent e) {
	     		    	
	     		    	// Get the login and password from the text fields
	     		        String login1 = login.getText();
	     		        String password1 = password.getText();
	
	     		        try {
	     		            // Create a connection to the database
	     		            DatabaseConnection connection = DatabaseConnection.getInstance();
	     		            Connection conn = connection.getConnection();
	     		            
	     		            // Get the last inserted id_compte
	     		            String query = "SELECT id_compte FROM compte ORDER BY id_compte DESC LIMIT 1";
	     		            Statement getLastIdStmt = conn.createStatement();
	     		            ResultSet resultSet = getLastIdStmt.executeQuery(query);
	     		            int lastId = 0;
	     		            if (resultSet.next()) {
	     		            	lastId = resultSet.getInt("id_compte");
	     		            }
	     		            
	     		            // Close the ResultSet and the Statement
	     		            resultSet.close();
	     		            getLastIdStmt.close();
	     		            
	     		            // Get the last inserted id_enseignant
	     		            String query1 = "SELECT id_enseignant FROM enseignants ORDER BY id_enseignant DESC LIMIT 1";
	     		            Statement getLastIdStmt1 = conn.createStatement();
	     		            ResultSet resultSet1 = getLastIdStmt1.executeQuery(query1);
	     		            int lastId1 = 0;
	     		            if (resultSet1.next()) {
	     		            	lastId1 = resultSet1.getInt("id_enseignant");
	     		            }
	     		            
	     		            // Close the ResultSet and the Statement
	     		            resultSet1.close();
	     		            getLastIdStmt1.close();
	     		            
	     		            // Insert the new record into the compte table
	     		            PreparedStatement statement = conn.prepareStatement("INSERT INTO compte (id_compte, login, pwd) VALUES (?, ?, ?)");
	     		            statement.setInt(1, lastId + 1);
	     		            statement.setString(2, login1);
	     		            statement.setString(3, password1);
	     		            statement.executeUpdate();
	     		            statement.close();
	     		            
	     		            // Insert the new enseignant into the enseignants table with the retrieved id_compte
	     		            PreparedStatement ensStat = conn.prepareStatement("INSERT INTO enseignants (id_enseignant, nom_ens, prenom_ens, date_Naissance, mail_ens, fonction, etat, statut, grade, id_compte) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	     		            ensStat.setInt(1, lastId1+1);
	     		            ensStat.setString(2, nom.getText());
	     		            ensStat.setString(3, prenom.getText());
	     		            ensStat.setString(4, DateNaissance.getText());
	     		            ensStat.setString(5, Email.getText());
	     		            ensStat.setString(6, Fonction.getText());
	     		            ensStat.setString(7, Etat.getText());
	     		            ensStat.setString(8, Statut.getText());
	     		            ensStat.setString(9, Grade.getText());
	     		            ensStat.setInt(10, lastId + 1);
	     		            ensStat.executeUpdate();
	     		            ensStat.close();
	
	     		            // Close the connection
	     		            conn.close();
	
	     		            // Display a message to confirm the insertion
	     		            JOptionPane.showMessageDialog(buttonPanel, "Enseignant inserted successfully!");
	     		        } catch (SQLException ex) {
	     		            ex.printStackTrace();
	     		            JOptionPane.showMessageDialog(buttonPanel, "Error: " + ex.getMessage());
	     		        }
	     		    }     
	     		});
	
	        // Add buttons to the panel
	        buttonPanel.add(login);
	        buttonPanel.add(password);
	        buttonPanel.add(nom);
	        buttonPanel.add(prenom);
	        buttonPanel.add(DateNaissance);
	        buttonPanel.add(Email);
	        buttonPanel.add(Fonction);
	        buttonPanel.add(Etat);
	        buttonPanel.add(Statut);
	        buttonPanel.add(Grade);
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
