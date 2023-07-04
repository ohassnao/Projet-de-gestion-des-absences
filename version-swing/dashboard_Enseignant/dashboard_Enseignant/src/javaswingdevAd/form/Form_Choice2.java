package javaswingdevAd.form;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Form_Choice2 extends javax.swing.JPanel {

    public Form_Choice2() {
        initComponents();
        lb.setText("Supression de la base de donnée");
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
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(Box.createHorizontalGlue());
        
        // Create buttons
        JButton btnEtudiants = new JButton("Etudiants");
        JButton btnModules = new JButton("Modules");
        JButton btnEnseignants = new JButton("Enseignants");
        
        // Add buttons to the panel
        buttonPanel.add(btnEtudiants);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(btnModules);
        buttonPanel.add(Box.createRigidArea(new Dimension(10, 0)));
        buttonPanel.add(btnEnseignants);
        buttonPanel.add(Box.createHorizontalGlue());
        

        
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
        
        // Add action listener to the "Enseignants" button
        btnEnseignants.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove the current panel from its parent container
                Container parent = getParent();
                parent.remove(Form_Choice2.this);
                parent.revalidate();
                parent.repaint();
                
                // Create and add the new panel to the parent container
                JPanel formCreateEns = new Delete_Enseignant();
                parent.add(formCreateEns);
                parent.revalidate();
                parent.repaint();
            }
        });
        
        // Add action listener to the "Etudiants" button
        btnEtudiants.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove the current panel from its parent container
                Container parent = getParent();
                parent.remove(Form_Choice2.this);
                parent.revalidate();
                parent.repaint();
                
                // Create and add the new panel to the parent container
                JPanel formUpdateEtd = new Delete_Etudiant();
                parent.add(formUpdateEtd);
                parent.revalidate();
                parent.repaint();
            }
        });
        
        // Add action listener to the "Modules" button
        btnModules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove the current panel from its parent container
                Container parent = getParent();
                parent.remove(Form_Choice2.this);
                parent.revalidate();
                parent.repaint();
                
                // Create and add the new panel to the parent container
                JPanel formUpdateModule = new Delete_Module();
                parent.add(formUpdateModule);
                parent.revalidate();
                parent.repaint();
            }
        });
    }

    private javax.swing.JLabel lb;
}
