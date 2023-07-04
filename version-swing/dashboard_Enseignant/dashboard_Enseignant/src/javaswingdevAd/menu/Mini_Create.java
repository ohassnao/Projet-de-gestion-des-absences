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

public class Mini_Create extends JFrame {

	private JPanel contentPane;
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

	public Mini_Create() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 661);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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

	}
}
