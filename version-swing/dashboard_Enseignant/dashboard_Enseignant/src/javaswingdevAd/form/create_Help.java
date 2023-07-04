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
import database.*;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class create_Help extends JFrame {

private JPanel contentPane;
private JTextField cne;
private JTextField appogé;
private JTextField nom;
private JTextField prénom;
private JTextField ville;
private JTextField num;
private JTextField date;
private JTextField email;
private JTextField sexe;
private JTextField idclasse;
DefaultTableModel model;
private JTable table;
private JScrollPane scrollpane;
/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
create_Help frame = new create_Help();
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the frame.
*/
public create_Help() {
	setTitle("Espace Etudiant");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setBounds(100, 100, 992, 659);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

setContentPane(contentPane);
contentPane.setLayout(null);

JPanel panel = new JPanel();
panel.setBackground(new Color(160, 217, 231));
panel.setBounds(0, 0, 302, 628);
contentPane.add(panel);
panel.setLayout(null);

JPanel panel_1 = new JPanel();
panel_1.setBounds(300, 0, 678, 283);
contentPane.add(panel_1);
panel_1.setLayout(null);


scrollpane = new JScrollPane();
scrollpane.setBounds(0, 0, 678, 283);
panel_1.add(scrollpane);

table = new JTable();
table.addMouseListener(new MouseAdapter() {
	@Override
	public void mouseClicked(MouseEvent e) {
		int i=table.getSelectedRow();
		cne.setText(model.getValueAt(i, 0).toString());
		appogé.setText(model.getValueAt(i, 1).toString());
		nom.setText(model.getValueAt(i, 2).toString());
		prénom.setText(model.getValueAt(i, 3).toString());
		ville.setText(model.getValueAt(i, 4).toString());
		date.setText(model.getValueAt(i, 5).toString());
		sexe.setText(model.getValueAt(i, 6).toString());
		email.setText(model.getValueAt(i, 7).toString());
		idclasse.setText(model.getValueAt(i, 8).toString());
		num.setText(model.getValueAt(i, 9).toString());
		
	}
});
table.setSurrendersFocusOnKeystroke(true);
table.setBackground(new Color(240, 230, 140));
model=new DefaultTableModel();

Object[] column= {"Cne","Appogé","Nom","Prénom","Ville","Date de naissance","Sexe","Email","Id_classe","Num_inscription"};
final Object[] row=new Object[10];
model.setColumnIdentifiers(column);
table.setModel(model);
scrollpane.setViewportView(table);


JLabel lblNewLabel = new JLabel("");
lblNewLabel.setBounds(97, 77, 133, 132);
panel.add(lblNewLabel);

JLabel lblNewLabel_1 = new JLabel("Welcome To ");
lblNewLabel_1.setFont(new Font("Calisto MT", Font.BOLD, 27));
lblNewLabel_1.setBounds(66, 220, 175, 50);
panel.add(lblNewLabel_1);

JLabel lblNewLabel_2 = new JLabel("Student's Space !");
lblNewLabel_2.setFont(new Font("Calisto MT", Font.BOLD, 27));
lblNewLabel_2.setBounds(57, 285, 235, 32);
panel.add(lblNewLabel_2);
// DECONNECTION

JButton btndeconnection = new JButton("Deconnection");
/*
 * btndeconnection.addActionListener(new ActionListener() { public void
 * actionPerformed(ActionEvent e) { create_Help.super.dispose(); logginadmin
 * login=new logginadmin(); login.setVisible(true);
 * 
 * } });
 */
btndeconnection.setFont(new Font("Calisto MT", Font.BOLD, 18));
btndeconnection.setFocusPainted(false);
btndeconnection.setBounds(77, 550, 153, 32);
panel.add(btndeconnection);

JPanel panel_2 = new JPanel();
panel_2.setBounds(300, 281, 678, 347);
contentPane.add(panel_2);
panel_2.setLayout(null);

JLabel lblNewLabel_3 = new JLabel("Cne :");
lblNewLabel_3.setFont(new Font("Calisto MT", Font.BOLD, 18));
lblNewLabel_3.setBounds(32, 31, 44, 22);
panel_2.add(lblNewLabel_3);

cne = new JTextField();
cne.setBounds(114, 31, 150, 20);
panel_2.add(cne);
cne.setColumns(10);

JLabel lblNewLabel_3_1 = new JLabel("Appogé :");
lblNewLabel_3_1.setFont(new Font("Calisto MT", Font.BOLD, 18));
lblNewLabel_3_1.setBounds(32, 80, 81, 22);
panel_2.add(lblNewLabel_3_1);

appogé = new JTextField();
appogé.setColumns(10);
appogé.setBounds(114, 80, 150, 20);
panel_2.add(appogé);

JLabel lblNewLabel_3_2 = new JLabel("Nom :");
lblNewLabel_3_2.setFont(new Font("Calisto MT", Font.BOLD, 18));
lblNewLabel_3_2.setBounds(32, 127, 66, 22);
panel_2.add(lblNewLabel_3_2);

nom = new JTextField();
nom.setColumns(10);
nom.setBounds(114, 127, 150, 20);
panel_2.add(nom);

JLabel lblNewLabel_3_2_1 = new JLabel("Prénom :");
lblNewLabel_3_2_1.setFont(new Font("Calisto MT", Font.BOLD, 18));
lblNewLabel_3_2_1.setBounds(32, 170, 81, 22);
panel_2.add(lblNewLabel_3_2_1);

prénom = new JTextField();
prénom.setColumns(10);
prénom.setBounds(114, 170, 150, 20);
panel_2.add(prénom);

JLabel lblNewLabel_3_2_1_1 = new JLabel("Ville :");
lblNewLabel_3_2_1_1.setFont(new Font("Calisto MT", Font.BOLD, 18));
lblNewLabel_3_2_1_1.setBounds(32, 211, 81, 22);
panel_2.add(lblNewLabel_3_2_1_1);

ville = new JTextField();
ville.setColumns(10);
ville.setBounds(114, 211, 150, 20);
panel_2.add(ville);

JLabel lblNewLabel_3_2_1_1_1 = new JLabel("Date de naissance :");
lblNewLabel_3_2_1_1_1.setFont(new Font("Calisto MT", Font.BOLD, 18));
lblNewLabel_3_2_1_1_1.setBounds(339, 21, 163, 42);
panel_2.add(lblNewLabel_3_2_1_1_1);

num = new JTextField();
num.setColumns(10);
num.setBounds(500, 211, 150, 20);
panel_2.add(num);

date = new JTextField();
date.setColumns(10);
date.setBounds(500, 31, 150, 20);
panel_2.add(date);

JLabel lblNewLabel_3_2_1_1_2_1 = new JLabel("Sexe :");
lblNewLabel_3_2_1_1_2_1.setFont(new Font("Calisto MT", Font.BOLD, 18));
lblNewLabel_3_2_1_1_2_1.setBounds(339, 80, 81, 22);
panel_2.add(lblNewLabel_3_2_1_1_2_1);

email = new JTextField();
email.setColumns(10);
email.setBounds(500, 127, 150, 20);
panel_2.add(email);

JLabel lblNewLabel_3_2_1_1_2_1_1 = new JLabel("Email :");
lblNewLabel_3_2_1_1_2_1_1.setFont(new Font("Calisto MT", Font.BOLD, 18));
lblNewLabel_3_2_1_1_2_1_1.setBounds(339, 127, 81, 22);
panel_2.add(lblNewLabel_3_2_1_1_2_1_1);

sexe = new JTextField();
sexe.setColumns(10);
sexe.setBounds(500, 83, 150, 20);
panel_2.add(sexe);

idclasse = new JTextField();
idclasse.setColumns(10);
idclasse.setBounds(500, 170, 150, 20);
panel_2.add(idclasse);

JLabel lblNewLabel_3_2_1_1_2_1_2 = new JLabel("Id_classe :");
lblNewLabel_3_2_1_1_2_1_2.setFont(new Font("Calisto MT", Font.BOLD, 18));
lblNewLabel_3_2_1_1_2_1_2.setBounds(339, 165, 109, 32);
panel_2.add(lblNewLabel_3_2_1_1_2_1_2);

JLabel lblNewLabel_3_2_1_1_2_1_2_1 = new JLabel("Num_inscription :\r\n");
lblNewLabel_3_2_1_1_2_1_2_1.setFont(new Font("Calisto MT", Font.BOLD, 18));
lblNewLabel_3_2_1_1_2_1_2_1.setBounds(339, 208, 151, 32);
panel_2.add(lblNewLabel_3_2_1_1_2_1_2_1);

//AJOUTER

JButton btnNewButton = new JButton("Ajouter");
btnNewButton.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		if (cne.getText().equals("") || appogé.getText().equals("") || nom.getText().equals("") || prénom.getText().equals("") || ville.getText().equals("")
				|| date.getText().equals("") || email.getText().equals("") || sexe.getText().equals("") || num.getText().equals("") || idclasse.getText().equals("")) {
			JOptionPane.showMessageDialog(null,"Veuillez Remplir Tout Les Champs");
		}
		else {
		/*row[0]=cne.getText();
		row[1]=appogé.getText();
		row[2]=nom.getText();
		row[3]=prénom.getText();
		row[4]=ville.getText();
		row[5]=date.getText();
		row[6]=sexe.getText();
		row[7]=email.getText();
		row[8]=idclasse.getText();
		row[9]=num.getText();
		model.addRow(row);
		
		cne.setText("");
		appogé.setText("");
		nom.setText("");
		prénom.setText("");
		ville.setText("");
		date.setText("");
		sexe.setText("");
		email.setText("");
		idclasse.setText("");
		num.setText("");
		JOptionPane.showMessageDialog(null,"Enregistré Avec Succès");*/
			
			try {
				DatabaseConnection connection = DatabaseConnection.getInstance();
 		        Connection conn = connection.getConnection();
				Statement stat=conn.createStatement();
				String sql="INSERT INTO etudiants(id_etd,nom,prenom,date_Naissance,mail,id_ins) VALUES (6,'Marouane','Marouane','2002-07-08','hjhfjfhjhfkj',6)";
				stat.executeUpdate(sql);
				System.out.println("Connected");
				stat.close();
				conn.close();}
			 catch (SQLException ex) {
				JOptionPane.showMessageDialog(null,"Connection Failed");
				System.out.println(ex);
			 }
		}}
});
btnNewButton.setFocusPainted(false);
btnNewButton.setFont(new Font("Calisto MT", Font.BOLD, 18));
btnNewButton.setBounds(65, 274, 127, 32);
panel_2.add(btnNewButton);

//SUPPRIMER

JButton btnSupprimer = new JButton("Supprimer");
btnSupprimer.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		int i=table.getSelectedRow();
		if (i>=0) {
		model.removeRow(i);
		JOptionPane.showMessageDialog(null,"Supprimé Avec Succès");
		}
		else {
		JOptionPane.showMessageDialog(null,"Veuillez Selectionner Un Etudiant");
		}
	}
});
btnSupprimer.setFocusPainted(false);
btnSupprimer.setFont(new Font("Calisto MT", Font.BOLD, 18));
btnSupprimer.setBounds(202, 274, 127, 32);
panel_2.add(btnSupprimer);

//EFFACER

JButton btnEffacer = new JButton("Effacer");
btnEffacer.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		cne.setText("");
		appogé.setText("");
		nom.setText("");
		prénom.setText("");
		ville.setText("");
		date.setText("");
		sexe.setText("");
		email.setText("");
		idclasse.setText("");
		num.setText("");
		
	}
});
btnEffacer.setFocusPainted(false);
btnEffacer.setFont(new Font("Calisto MT", Font.BOLD, 18));
btnEffacer.setBounds(339, 274, 134, 32);
panel_2.add(btnEffacer);

//MODIFIER

JButton btnmodifier = new JButton("Modifier");
btnmodifier.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		int i =table.getSelectedRow();
		if (i>0) {
		model.setValueAt(cne.getText(), i, 0);
		model.setValueAt(appogé.getText(), i, 1);
		model.setValueAt(nom.getText(), i, 2);
		model.setValueAt(prénom.getText(), i, 3);
		model.setValueAt(ville.getText(), i, 4);
		model.setValueAt(date.getText(), i, 5);
		model.setValueAt(sexe.getText(), i, 6);
		model.setValueAt(email.getText(), i, 7);
		model.setValueAt(idclasse.getText(), i, 8);
		model.setValueAt(num.getText(), i, 9);
		JOptionPane.showMessageDialog(null,"Modifié Avec Succès");
		}
		else {
			JOptionPane.showMessageDialog(null,"Veuillez Selectionner Un Etudiant");
		}
	}
});


btnmodifier.setFont(new Font("Calisto MT", Font.BOLD, 18));
btnmodifier.setFocusPainted(false);
btnmodifier.setBounds(483, 274, 134, 32);
panel_2.add(btnmodifier);


}
}