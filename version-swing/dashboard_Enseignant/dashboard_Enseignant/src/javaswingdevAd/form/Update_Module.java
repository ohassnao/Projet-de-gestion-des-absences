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
	
	public class Update_Module extends javax.swing.JPanel {
	
	    public Update_Module() {
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
	        JTextField Intitule = new JTextField("Intitulé");
	        JTextField Ens_Intitule = new JTextField("Enseignant Chargé");
	        JButton insertButton = new JButton("UPDATE");
	        insertButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    // Create a connection to the database
	                    DatabaseConnection connection = DatabaseConnection.getInstance();
	                    Connection conn = connection.getConnection();
	                    
	                    // Get the name from the id of enseignant
	                    String query1 = "SELECT id_enseignant FROM enseignants WHERE nom_ens = ?";
	                    PreparedStatement stmt1 = conn.prepareStatement(query1);
	                    stmt1.setString(1, Ens_Intitule.getText());
	                    ResultSet rs = stmt1.executeQuery();
	                    int ensId = 0;
	                    if (rs.next()) {
	                        ensId = rs.getInt("id_enseignant");
	                    }

	                    // Close the ResultSet and the Statement
	                    rs.close();
	                    stmt1.close();
	                    if (ensId == 0) {
	                        JOptionPane.showMessageDialog(buttonPanel, "Error: no matching professor found");
	                        return;
	                    }

	                    // Update the module with the new professor in charge
	                    String updateStatement = "UPDATE module SET id_ens=? WHERE intitulé=?";
	                    PreparedStatement updateStmt = conn.prepareStatement(updateStatement);
	                    updateStmt.setString(2, Intitule.getText());
	                    updateStmt.setInt(1, ensId);
	                    int numRowsUpdated = updateStmt.executeUpdate();
	                    if (numRowsUpdated > 0) {
	                        JOptionPane.showMessageDialog(buttonPanel, "Module updated successfully!");
	                    } else {
	                        JOptionPane.showMessageDialog(buttonPanel, "Error updating module");
	                    }

	                    // Close the PreparedStatement and the connection
	                    updateStmt.close();
	                    conn.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(buttonPanel, "Error: " + ex.getMessage());
	                }
	            }
	        });     
	
	        buttonPanel.add(Intitule);
	        buttonPanel.add(Ens_Intitule);
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
