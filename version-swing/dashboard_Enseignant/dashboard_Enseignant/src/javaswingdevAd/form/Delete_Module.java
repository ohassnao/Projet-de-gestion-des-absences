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
	
	public class Delete_Module extends javax.swing.JPanel {
	
	    public Delete_Module() {
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
	     // Create TextFields
	        JTextField nomField = new JTextField("Nom de Module");
	        JTextField prenomField = new JTextField("Enseignant Chargé");

	        JButton deleteButton = new JButton("DELETE");
	        deleteButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                try {
	                    // Create a connection to the database
	                    DatabaseConnection connection = DatabaseConnection.getInstance();
	                    Connection conn = connection.getConnection();

	                    // Find the id of the professor from its id
	                    PreparedStatement stmt_q = conn.prepareStatement("SELECT id_enseignant FROM enseignant WHERE nom_ens = ?");
	                    stmt_q.setString(1, prenomField.getText());
	                    ResultSet resEns = stmt_q.executeQuery();
	                    int id_ENS = 99999;
	                    while(resEns.next()) {
	                    	id_ENS = resEns.getInt(1);
	                    }
	                    
	                    // Delete the etudiant from the database
	                    String deleteStatement = "DELETE FROM module WHERE intitulé=? AND id_ens=?";
	                    PreparedStatement deleteStmt = conn.prepareStatement(deleteStatement);
	                    deleteStmt.setString(1, nomField.getText());
	                    deleteStmt.setInt(2, id_ENS);
	                    int numRowsDeleted = deleteStmt.executeUpdate();
	                    if (numRowsDeleted > 0) {
	                        JOptionPane.showMessageDialog(buttonPanel, "Module deleted successfully!");
	                    } else {
	                        JOptionPane.showMessageDialog(buttonPanel, "Error deleting Module");
	                    }

	                    conn.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                    JOptionPane.showMessageDialog(buttonPanel, "Error: " + ex.getMessage());
	                }
	            }
	        });

	        buttonPanel.add(nomField);
	        buttonPanel.add(prenomField);
	        buttonPanel.add(deleteButton);
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
