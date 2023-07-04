package javaswingdevAd.menu;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.DatabaseConnection;

import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSplitPane;

public class CreateEns extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNewLabel_1_1_6;
	private JTextField textField_7;
	private JLabel lblAddCompte;
	private JLabel lblNewLabel_3;
	private JTextField textField_8;
	private JLabel lblNewLabel_2;
	private JTextField textField_9;
	private JButton insertButton;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateEns frame = new CreateEns();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CreateEns() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 661);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Enseignant");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Nemesis Grant", Font.PLAIN, 31));
		lblNewLabel.setBounds(432, 10, 345, 61);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		lblNewLabel_1.setBounds(432, 81, 169, 37);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Oswald", Font.PLAIN, 17));
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(611, 81, 285, 37);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenom");
		lblNewLabel_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(432, 138, 169, 37);
		contentPane.add(lblNewLabel_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Oswald", Font.PLAIN, 17));
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(611, 138, 285, 37);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Date Naissance");
		lblNewLabel_1_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		lblNewLabel_1_1_1.setBounds(432, 195, 169, 37);
		contentPane.add(lblNewLabel_1_1_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Oswald", Font.PLAIN, 17));
		textField_2.setColumns(10);
		textField_2.setBackground(Color.WHITE);
		textField_2.setBounds(611, 195, 285, 37);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Email");
		lblNewLabel_1_1_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_2.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		lblNewLabel_1_1_2.setBounds(432, 254, 169, 37);
		contentPane.add(lblNewLabel_1_1_2);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Oswald", Font.PLAIN, 17));
		textField_3.setColumns(10);
		textField_3.setBackground(Color.WHITE);
		textField_3.setBounds(611, 254, 285, 37);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("Fonction");
		lblNewLabel_1_1_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_3.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		lblNewLabel_1_1_3.setBounds(432, 315, 169, 37);
		contentPane.add(lblNewLabel_1_1_3);
		
		textField_4 = new JTextField();
		textField_4.setFont(new Font("Oswald", Font.PLAIN, 17));
		textField_4.setColumns(10);
		textField_4.setBackground(Color.WHITE);
		textField_4.setBounds(611, 315, 285, 37);
		contentPane.add(textField_4);
		
		JLabel lblNewLabel_1_1_4 = new JLabel("Etat");
		lblNewLabel_1_1_4.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_4.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		lblNewLabel_1_1_4.setBounds(432, 377, 169, 37);
		contentPane.add(lblNewLabel_1_1_4);
		
		textField_5 = new JTextField();
		textField_5.setFont(new Font("Oswald", Font.PLAIN, 17));
		textField_5.setColumns(10);
		textField_5.setBackground(Color.WHITE);
		textField_5.setBounds(611, 377, 285, 37);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_1_1_5 = new JLabel("Statut");
		lblNewLabel_1_1_5.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_5.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		lblNewLabel_1_1_5.setBounds(432, 435, 169, 37);
		contentPane.add(lblNewLabel_1_1_5);
		
		textField_6 = new JTextField();
		textField_6.setFont(new Font("Oswald", Font.PLAIN, 17));
		textField_6.setColumns(10);
		textField_6.setBackground(Color.WHITE);
		textField_6.setBounds(611, 435, 285, 37);
		contentPane.add(textField_6);
		
		lblNewLabel_1_1_6 = new JLabel("Grade");
		lblNewLabel_1_1_6.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_6.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		lblNewLabel_1_1_6.setBounds(432, 499, 169, 37);
		contentPane.add(lblNewLabel_1_1_6);
		
		textField_7 = new JTextField();
		textField_7.setFont(new Font("Oswald", Font.PLAIN, 17));
		textField_7.setColumns(10);
		textField_7.setBackground(Color.WHITE);
		textField_7.setBounds(611, 499, 285, 37);
		contentPane.add(textField_7);
		
		lblAddCompte = new JLabel("Add Compte");
		lblAddCompte.setForeground(Color.BLACK);
		lblAddCompte.setFont(new Font("Nemesis Grant", Font.PLAIN, 31));
		lblAddCompte.setBounds(40, 206, 211, 61);
		contentPane.add(lblAddCompte);
		
		lblNewLabel_3 = new JLabel("Login");
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		lblNewLabel_3.setBounds(40, 277, 69, 37);
		contentPane.add(lblNewLabel_3);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Oswald", Font.PLAIN, 17));
		textField_8.setColumns(10);
		textField_8.setBackground(Color.WHITE);
		textField_8.setBounds(119, 277, 230, 37);
		contentPane.add(textField_8);
		
		lblNewLabel_2 = new JLabel("Pwd");
		lblNewLabel_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_2.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		lblNewLabel_2.setBounds(40, 334, 69, 37);
		contentPane.add(lblNewLabel_2);
		
		textField_9 = new JTextField();
		textField_9.setFont(new Font("Oswald", Font.PLAIN, 17));
		textField_9.setColumns(10);
		textField_9.setBackground(Color.WHITE);
		textField_9.setBounds(119, 334, 230, 37);
		contentPane.add(textField_9);
		
		// Insert Button
		JButton insertButton = new JButton("Insert");
		insertButton.setBounds(119, 394, 230, 37);
		contentPane.add(insertButton);
		
		// Add an Event Listener for the button
		insertButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	// Get the login and password from the text fields
		        String login = textField_8.getText();
		        String password = textField_9.getText();

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
		            statement.setString(2, login);
		            statement.setString(3, password);
		            statement.executeUpdate();
		            statement.close();
		            
		            // Insert the new enseignant into the enseignants table with the retrieved id_compte
		            PreparedStatement ensStat = conn.prepareStatement("INSERT INTO enseignants (id_enseignant, nom_ens, prenom_ens, date_Naissance, mail_ens, fonction, etat, statut, grade, id_compte) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		            ensStat.setInt(1, lastId1+1);
		            ensStat.setString(2, textField.getText());
		            ensStat.setString(3, textField_1.getText());
		            ensStat.setString(4, textField_2.getText());
		            ensStat.setString(5, textField_3.getText());
		            ensStat.setString(6, textField_4.getText());
		            ensStat.setString(7, textField_5.getText());
		            ensStat.setString(8, textField_6.getText());
		            ensStat.setString(9, textField_7.getText());
		            ensStat.setInt(10, lastId + 1);
		            ensStat.executeUpdate();
		            ensStat.close();

		            // Close the connection
		            conn.close();

		            // Display a message to confirm the insertion
		            JOptionPane.showMessageDialog(contentPane, "Enseignant inserted successfully!");
		        } catch (SQLException ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(contentPane, "Error: " + ex.getMessage());
		        }
		    }     
		});
	}
}
