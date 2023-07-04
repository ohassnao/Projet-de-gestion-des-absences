package javaswingdev.form;

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

public class Form_Choice extends javax.swing.JPanel {

    public Form_Choice() {
        initComponents();
        lb.setText("Creation d'un nouveau element");
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
                parent.remove(Form_Choice.this);
                parent.revalidate();
                parent.repaint();
                
                // Create and add the new panel to the parent container
                JPanel formCreateEns = new Form_Create_Ens();
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
                parent.remove(Form_Choice.this);
                parent.revalidate();
                parent.repaint();
                
                // Create and add the new panel to the parent container
                JPanel formCreateEtd = new Form_Create_Etd();
                parent.add(formCreateEtd);
                parent.revalidate();
                parent.repaint();
            }
        });
        
        // Add action listener to the "Etudiants" button
        btnModules.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Remove the current panel from its parent container
                Container parent = getParent();
                parent.remove(Form_Choice.this);
                parent.revalidate();
                parent.repaint();
                
                // Create and add the new panel to the parent container
                JPanel formCreateModule = new Form_Create_Module();
                parent.add(formCreateModule);
                parent.revalidate();
                parent.repaint();
            }
        });
    }

    private javax.swing.JLabel lb;
}
