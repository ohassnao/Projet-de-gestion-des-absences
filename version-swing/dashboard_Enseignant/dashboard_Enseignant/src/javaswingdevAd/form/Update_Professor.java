	package javaswingdevAd.form;
	
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
	
	public class Update_Professor extends javax.swing.JPanel {
	
	    public Update_Professor() {
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
	
	     // Assuming you have the necessary imports

	     // ...

	     JTextField nomEns = new JTextField("Professor Name");
	     JTextField login = new JTextField("New Login");
	     JTextField password = new JTextField("New Password");
	     JButton updateButton = new JButton("UPDATE");

	     updateButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	             try {
	                 // Create a connection to the database
	                 DatabaseConnection connection = DatabaseConnection.getInstance();
	                 Connection conn = connection.getConnection();

	                 // Get the enseignant's ID and compte ID
	                 String enseignantQuery = "SELECT id_enseignant, id_compte FROM enseignants WHERE nom_ens = ?";
	                 PreparedStatement enseignantStmt = conn.prepareStatement(enseignantQuery);
	                 enseignantStmt.setString(1, nomEns.getText());
	                 ResultSet enseignantResult = enseignantStmt.executeQuery();

	                 int enseignantId = 0;
	                 int compteId = 0;
	                 
	                 if (enseignantResult.next()) {
	                     enseignantId = enseignantResult.getInt("id_enseignant");
	                     compteId = enseignantResult.getInt("id_compte");
	                 }

	                 enseignantResult.close();
	                 enseignantStmt.close();

	                 if (enseignantId == 0) {
	                     JOptionPane.showMessageDialog(buttonPanel, "Error: no matching professor found");
	                     return;
	                 }

	                 // Update the login and password in the compte table
	                 String compteUpdate = "UPDATE Compte SET login = ?, pwd = ? WHERE id_compte = ?";
	                 PreparedStatement compteStmt = conn.prepareStatement(compteUpdate);
	                 compteStmt.setString(1, login.getText());
	                 compteStmt.setString(2, password.getText());
	                 compteStmt.setInt(3, compteId);
	                 int numRowsUpdated = compteStmt.executeUpdate();

	                 if (numRowsUpdated > 0) {
	                     JOptionPane.showMessageDialog(buttonPanel, "Login and password updated successfully!");
	                 } else {
	                     JOptionPane.showMessageDialog(buttonPanel, "Error updating login and password");
	                 }

	                 compteStmt.close();
	                 conn.close();
	             } catch (SQLException ex) {
	                 ex.printStackTrace();
	                 JOptionPane.showMessageDialog(buttonPanel, "Error: " + ex.getMessage());
	             }
	         }
	     });

	        buttonPanel.add(nomEns);
	        buttonPanel.add(login);
	        buttonPanel.add(password);
	        buttonPanel.add(updateButton);	
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
