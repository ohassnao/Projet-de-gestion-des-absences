package javaswingdev.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseConnection;
import javaswingdev.card.ModelCard;
import database.*;


import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javaswingdev.card.ModelCard;
public class Form_Modules extends javax.swing.JPanel {

    public Form_Modules(String nom_ens) throws SQLException {
        initComponents();
        init(nom_ens);
        //lb.setText("Welcome Everyone!");
    }
    
    public void init(String nom_ens) throws SQLException {
    	
        table.fixTable(jScrollPane1);
        DatabaseConnection connection = DatabaseConnection.getInstance();
        Connection conn = connection.getConnection();

        // Create a statement to execute the query
        java.sql.Statement stmt = conn.createStatement();
        System.out.println("Welcome");

        // Execute the query and get the result set
		/*
		 * int id_ens = rs.getInt("id_ens"); PreparedStatement pstmt = conn.
		 * prepareStatement("SELECT nom_ens FROM enseignants WHERE id_enseignant = ? LIMIT 1"
		 * ); pstmt.setInt(1, id_ens); ResultSet rs1 = pstmt.executeQuery(); String
		 * ens_name = ""; if (rs1.next()) { ens_name = rs1.getString("nom_ens"); }
		 */
        

	    PreparedStatement pstmt1 = conn.prepareStatement("SELECT id_enseignant FROM enseignants WHERE nom_ens = ? LIMIT 1");
	    pstmt1.setString(1, nom_ens);
	    ResultSet rs2 = pstmt1.executeQuery();
	    int ensID = 0;
	    if (rs2.next()) {
	        ensID = rs2.getInt("id_enseignant");
	    }
	    	
	    PreparedStatement stmtModules = conn.prepareStatement("SELECT * FROM module WHERE id_ens = ?");
	    stmtModules.setInt(1, ensID);
	    ResultSet resModules = stmtModules.executeQuery();
	    
	    
    	// Loop through the result set and add rows to the table
    	while (resModules.next()) {
    	    String intitulé = resModules.getString("intitulé");
    	    String desc = resModules.getString("description");
    	    String abv = resModules.getString("abreveation");
    	    PreparedStatement dstmt = conn.prepareStatement("SELECT COUNT(*) FROM posseder JOIN module ON posseder.id_module=module.id_module WHERE module.intitulé=?");	
    	    dstmt.setString(1, intitulé);
    	    ResultSet res_count = dstmt.executeQuery();
    	    int countEtdPerModule = 0;
    	    if(res_count.next()) {
    	    	countEtdPerModule = res_count.getInt(1);
    	    }

    	    table.addRow(new Object[]{intitulé, desc, abv, nom_ens, countEtdPerModule});
    	}

        //  Count Modules
    	ResultSet rs1 = stmt.executeQuery("SELECT COUNT(*) FROM module");

    	int module_counts = 0;
    	if (rs1.next()) {
    	    module_counts = rs1.getInt(1);
    	}
    	
        //  Count Enseignants
    	ResultSet rs3 = stmt.executeQuery("SELECT COUNT(*) FROM enseignants");

    	int ens_counts = 0;
    	if (rs3.next()) {
    	    ens_counts = rs3.getInt(1);
    	}
    	
    	
        card1.setData(new ModelCard(null, null, null, Integer.toString(module_counts), "Modules at ENSAKH"));
        card2.setData(new ModelCard(null, null, null, "ENSA KHOURIBGA", "LISTE DES MODULE - ETUDIANTS"));
        card3.setData(new ModelCard(null, null, null, Integer.toString(ens_counts), "Professors at ENSAKH"));
        
    	// Close the result set, statement, and connection
    	rs1.close();
    	conn.close();
    	
    }


    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        card3.setIcon(javaswingdev.GoogleMaterialDesignIcon.ACCOUNT_BALANCE);

        roundPanel1.setBackground(new java.awt.Color(255, 255, 255));
        roundPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        roundPanel1.setRound(10);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Intitulé", "Description", "Abréveation", "Enseignant Chargé", "Nombre d'Etudiants"
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
