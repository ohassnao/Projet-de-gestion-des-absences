package javaswingdev.form;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseConnection;
import javaswingdev.card.ModelCard;
import database.*;

import java.util.*;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javaswingdev.card.ModelCard;
public class Generate_Module_Infos extends javax.swing.JPanel {

    public Generate_Module_Infos(String nom_ens, int indice) throws SQLException {
        initComponents();
        init(indice, nom_ens);
        //lb.setText("Welcome Everyone!");
    }

    public void init(int indice, String nom_ens) throws SQLException {
    	
        table.fixTable(jScrollPane1);
        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection conn = connection.getConnection();
        
        // create a new ArrayList to hold the values
        ArrayList<String> intituleList = new ArrayList<>();

        try {
            PreparedStatement rs = conn.prepareStatement("SELECT intitulé FROM module JOIN enseignants ON enseignants.id_enseignant = module.id_ens WHERE enseignants.nom_ens = ?");
            rs.setString(1, nom_ens);
            ResultSet res = rs.executeQuery();
            while(res.next()) {
            	intituleList.add(res.getString("intitulé"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        

        // Create a statement to execute the query
        java.sql.Statement stmt = conn.createStatement();
        //System.out.println("Welcome");
        
        PreparedStatement rs = conn.prepareStatement("SELECT etudiants.id_etd, etudiants.nom, etudiants.prenom, etudiants.date_Naissance FROM etudiants JOIN posseder ON posseder.id_etd = etudiants.id_etd JOIN module ON posseder.id_module = module.id_module WHERE module.intitulé=?");
        rs.setString(1, intituleList.get(indice));
        ResultSet res_Query = rs.executeQuery();

        while (res_Query.next()) {
            int id_etd = res_Query.getInt("etudiants.id_etd");
            String nom = res_Query.getString("etudiants.nom");
            String prenom = res_Query.getString("etudiants.prenom");
            String dateNaissance = res_Query.getString("etudiants.date_Naissance");
            PreparedStatement nbrAbsence = conn.prepareStatement("SELECT COUNT(*) FROM absence WHERE absence.id_etd=? and absence.id_module=?");
            nbrAbsence.setInt(1, id_etd);
            nbrAbsence.setInt(2, 4);
            System.out.println(indice+1);
            ResultSet nbrAbs = nbrAbsence.executeQuery();
            int nbrAbsences = 0;
            while(nbrAbs.next()) {nbrAbsences=nbrAbs.getInt(1);}
            System.out.println(intituleList.get(indice));
            
            PreparedStatement id_modules = conn.prepareStatement("SELECT id_module FROM module WHERE intitulé = ?");
            id_modules.setString(1, intituleList.get(indice));
            ResultSet rs00 = id_modules.executeQuery();
            int IDm = 0;
            while(rs00.next()) {
            	IDm = rs00.getInt("id_module");
            }

            
            PreparedStatement nbrJustify = conn.prepareStatement("SELECT COUNT(*) FROM absence WHERE type_absence='Justifié' and absence.id_etd=? and absence.id_module=?");
            nbrJustify.setInt(1, id_etd);
            nbrJustify.setInt(2, IDm);
            ResultSet nbrJust = nbrJustify.executeQuery();
            int nbrJustifications = 0;
            while(nbrJust.next()) {nbrJustifications=nbrJust.getInt(1);}
            
            PreparedStatement query = conn.prepareStatement("SELECT note FROM posseder WHERE id_etd = ? and id_module = ?");
            query.setInt(1, id_etd);
            query.setInt(2, IDm);
            ResultSet note_gen = query.executeQuery();
            int notes = 0;
            while(note_gen.next()) {notes = note_gen.getInt(1);}
            
            table.addRow(new Object[]{nom, prenom, dateNaissance, nbrAbsences, nbrJustifications, notes});
        }


        //  init card data
    	ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) FROM module");
    	
  

    	int module_counts = 0; 
    	if (rs1.next()) {
    	    module_counts = rs1.getInt(1);
    	}
    	
    	
        card1.setData(new ModelCard(null, null, null, Integer.toString(module_counts), "Modules at ENSAKH"));
        card2.setData(new ModelCard(null, null, null, "ENSA KHOURIBGA", "Dashboard Professeur"));
        card3.setData(new ModelCard(null, null, null, "2", "Admins at ENSAKH"));
    	// Close the result set, statement, and connection
    	rs1.close();
    	conn.close();
    	
    }


    @SuppressWarnings("unchecked")
    private void initComponents() {
        card1 = new javaswingdev.card.Card();
        card2 = new javaswingdev.card.Card();
        card3 = new javaswingdev.card.Card();
        roundPanel1 = new javaswingdev.swing.RoundPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javaswingdev.swing.table.Table();

        setOpaque(false);

        card2.setColor1(new java.awt.Color(95, 211, 226));
        card2.setColor2(new java.awt.Color(26, 166, 170));
        card2.setIcon(javaswingdev.GoogleMaterialDesignIcon.PIE_CHART);

        card3.setColor1(new java.awt.Color(95, 243, 140));
        card3.setColor2(new java.awt.Color(3, 157, 27));
        card3.setIcon(javaswingdev.GoogleMaterialDesignIcon.RING_VOLUME);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nom", "Prenom", "Date Naissance", "Absence Count", "Nombre Justification", "note"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout roundPanel1Layout = new javax.swing.GroupLayout(roundPanel1);
        roundPanel1.setLayout(roundPanel1Layout);
        roundPanel1Layout.setHorizontalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        roundPanel1Layout.setVerticalGroup(
            roundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(card1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(card2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(30, 30, 30)
                        .addComponent(card3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(card3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(card1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(roundPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(30, 30, 30))
        );

    }// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javaswingdev.card.Card card1;
	private javaswingdev.card.Card card2;
	private javaswingdev.card.Card card3;
	private javax.swing.JScrollPane jScrollPane1;
	private javaswingdev.swing.RoundPanel roundPanel1;
	private javaswingdev.swing.table.Table table;
    // End of variables declaration//GEN-END:variables
}
