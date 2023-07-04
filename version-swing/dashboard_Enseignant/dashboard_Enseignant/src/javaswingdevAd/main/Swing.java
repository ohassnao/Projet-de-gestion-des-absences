package javaswingdevAd.main;
import javax.swing.*;

public class Swing extends javax.swing.JFrame {
	private String email, password;

    public Swing() {
        initComponents();
        setSize(875, 650);
        setResizable(false);
        setLocationRelativeTo(null);
        
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        btnsGroup = new javax.swing.ButtonGroup();
        mainPane = new javax.swing.JPanel();
        firstPane = new javax.swing.JPanel();
        lblWelcome = new javax.swing.JLabel();
        lblSentence = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        lblQuestion = new javax.swing.JLabel();
        rbProfessor = new javax.swing.JRadioButton();
        rbAdmin = new javax.swing.JRadioButton();
        lblIndicator_1 = new javax.swing.JLabel();
        lblIndicator_2 = new javax.swing.JLabel();
        secondPane = new javax.swing.JPanel();
        lblImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        firstPane.setBackground(new java.awt.Color(255, 255, 255));

        lblWelcome.setFont(new java.awt.Font("Leelawadee UI", 1, 36)); // NOI18N
        lblWelcome.setText("Welcome back !");

        lblSentence.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        lblSentence.setForeground(new java.awt.Color(102, 102, 102));
        lblSentence.setText("Enter to get unlimited access to data & information.");

        lblEmail.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        lblEmail.setText("Email *");

        txtEmail.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        lblPassword.setText("Password *");

        txtPassword.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        txtPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btnLogin.setBackground(new java.awt.Color(0, 102, 204));
        btnLogin.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Log In");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        lblQuestion.setFont(new java.awt.Font("Leelawadee UI", 0, 14)); // NOI18N
        lblQuestion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblQuestion.setText("Don't have an account ? Check USMS");

        btnsGroup.add(rbProfessor);
        rbProfessor.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        rbProfessor.setText("Professor");
        rbProfessor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbProfessor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProfessorActionPerformed(evt);
            }
        });

        btnsGroup.add(rbAdmin);
        rbAdmin.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        rbAdmin.setText("Admin");
        rbAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAdminActionPerformed(evt);
            }
        });

        lblIndicator_1.setBackground(new java.awt.Color(255, 255, 204));
        lblIndicator_1.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        lblIndicator_1.setForeground(new java.awt.Color(255, 0, 0));
        lblIndicator_1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblIndicator_2.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        lblIndicator_2.setForeground(new java.awt.Color(255, 0, 0));
        lblIndicator_2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout firstPaneLayout = new javax.swing.GroupLayout(firstPane);
        firstPane.setLayout(firstPaneLayout);
        firstPaneLayout.setHorizontalGroup(
            firstPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstPaneLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(firstPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSentence, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmail)
                    .addComponent(lblPassword)
                    .addGroup(firstPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lblQuestion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(firstPaneLayout.createSequentialGroup()
                            .addComponent(rbProfessor)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rbAdmin))
                        .addComponent(lblIndicator_1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblIndicator_2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        firstPaneLayout.setVerticalGroup(
            firstPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(firstPaneLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(lblWelcome)
                .addGap(0, 0, 0)
                .addComponent(lblSentence)
                .addGap(41, 41, 41)
                .addComponent(lblEmail)
                .addGap(0, 0, 0)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lblPassword)
                .addGap(0, 0, 0)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblIndicator_1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(firstPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(firstPaneLayout.createSequentialGroup()
                        .addComponent(rbProfessor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblIndicator_2)
                        .addGap(11, 11, 11)
                        .addComponent(btnLogin)
                        .addGap(42, 42, 42)
                        .addComponent(lblQuestion)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(firstPaneLayout.createSequentialGroup()
                        .addComponent(rbAdmin)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        secondPane.setBackground(new java.awt.Color(255, 255, 255));

        lblImage.setIcon(new javax.swing.ImageIcon("testss.jpg")); // NOI18N

        javax.swing.GroupLayout secondPaneLayout = new javax.swing.GroupLayout(secondPane);
        secondPane.setLayout(secondPaneLayout);
        secondPaneLayout.setHorizontalGroup(
            secondPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(secondPaneLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        secondPaneLayout.setVerticalGroup(
            secondPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPaneLayout = new javax.swing.GroupLayout(mainPane);
        mainPane.setLayout(mainPaneLayout);
        mainPaneLayout.setHorizontalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPaneLayout.createSequentialGroup()
                .addComponent(firstPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(secondPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPaneLayout.setVerticalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(firstPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(secondPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPane, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        email = txtEmail.getText();
        password = txtPassword.getText();
        if (rbAdmin.isSelected() == false && rbProfessor.isSelected() == false) {
            lblIndicator_2.setText("* Professor or Admin ?");

        }
        else {
            lblIndicator_2.setText("");
            if (email.equals("") || password.equals("")) {
                lblIndicator_1.setText("* All fields should be filled in");
            }
            else if (email.endsWith("@usms.ac.ma") == false) {
                lblIndicator_1.setText("* Email should end with @usms.ac.ma");
            }
            else {
                lblIndicator_1.setText("");
               /* Connection to database */
               
            }
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {
        // Function
    }//GEN-LAST:event_txtEmailActionPerformed

    private void rbProfessorActionPerformed(java.awt.event.ActionEvent evt) {
        lblIndicator_2.setText("");
        email = txtEmail.getText();
        password = txtPassword.getText();
        if (email.equals("") || password.equals("")) {
            lblIndicator_1.setText("* All fields should be filled in");
        }
        else {
            lblIndicator_1.setText("");
        }
    }

    private void rbAdminActionPerformed(java.awt.event.ActionEvent evt) {
        lblIndicator_2.setText("");
        email = txtEmail.getText();
        password = txtPassword.getText();
        if (email.equals("") || password.equals("")) {
            lblIndicator_1.setText("* All fields should be filled in");
        }
        else if (email.endsWith("@usms.ac.ma") == false){
            lblIndicator_1.setText("* Email should end with @usms.ac.ma");
        }
        else {
            lblIndicator_1.setText("");
        }
    }
  
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Swing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Swing().setVisible(true);
            }
        });
    }

    private javax.swing.JButton btnLogin;
    private javax.swing.ButtonGroup btnsGroup;
    private javax.swing.JPanel firstPane;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblIndicator_1;
    private javax.swing.JLabel lblIndicator_2;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblQuestion;
    private javax.swing.JLabel lblSentence;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JPanel mainPane;
    private javax.swing.JRadioButton rbAdmin;
    private javax.swing.JRadioButton rbProfessor;
    private javax.swing.JPanel secondPane;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtPassword;
}
