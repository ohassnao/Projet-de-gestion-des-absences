package javaswingdev.main;


public class Acceuil extends javax.swing.JFrame {
    public Acceuil() {
        initComponents();
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	setUndecorated(true);
        mainPane = new javax.swing.JPanel();
        topPane = new javax.swing.JPanel();
        btnToGet = new javax.swing.JButton();
        lblHello = new javax.swing.JLabel();
        lblFirstLine = new javax.swing.JLabel();
        lblSecondLine = new javax.swing.JLabel();
        lblFirstSmallLine = new javax.swing.JLabel();
        lblSecondSmallLine = new javax.swing.JLabel();
        btnChatToUs = new javax.swing.JButton();
        bottomPane = new javax.swing.JPanel();
        lblOfBottom = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        topPane.setBackground(new java.awt.Color(255, 255, 255));

        btnToGet.setBackground(new java.awt.Color(102, 0, 255));
        btnToGet.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnToGet.setForeground(new java.awt.Color(255, 255, 255));
        btnToGet.setText("Get in touch");
        btnToGet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        lblHello.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblHello.setText("hello@usms.ac.ma");

        lblFirstLine.setFont(new java.awt.Font("Microsoft Tai Le", 1, 30)); // NOI18N
        lblFirstLine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFirstLine.setText("Effortlessly Track Attendance");

        lblSecondLine.setFont(new java.awt.Font("Microsoft Tai Le", 1, 30)); // NOI18N
        lblSecondLine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSecondLine.setText("With Our Attendance Management Application");

        lblFirstSmallLine.setBackground(new java.awt.Color(102, 102, 102));
        lblFirstSmallLine.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        lblFirstSmallLine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFirstSmallLine.setText("IID Project in Java Programming Language");

        lblSecondSmallLine.setBackground(new java.awt.Color(102, 102, 102));
        lblSecondSmallLine.setFont(new java.awt.Font("Lucida Sans Unicode", 0, 14)); // NOI18N
        lblSecondSmallLine.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSecondSmallLine.setText("ENSA Khouribga 2022/2023 ©");

        btnChatToUs.setBackground(new java.awt.Color(102, 0, 255));
        btnChatToUs.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnChatToUs.setForeground(new java.awt.Color(255, 255, 255));
        btnChatToUs.setText("Log In");
        btnChatToUs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChatToUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // Login successful, open the main application window
                Swing main = new Swing();
                main.setVisible(true);
                dispose(); // Close the login window
            }
        });

        javax.swing.GroupLayout topPaneLayout = new javax.swing.GroupLayout(topPane);
        topPane.setLayout(topPaneLayout);
        topPaneLayout.setHorizontalGroup(
            topPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPaneLayout.createSequentialGroup()
                .addGap(708, 708, 708)
                .addComponent(lblHello)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnToGet)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lblFirstLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSecondLine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblFirstSmallLine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblSecondSmallLine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChatToUs, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(416, 416, 416))
        );
        topPaneLayout.setVerticalGroup(
            topPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPaneLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(topPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnToGet)
                    .addComponent(lblHello))
                .addGap(69, 69, 69)
                .addComponent(lblFirstLine)
                .addGap(0, 0, 0)
                .addComponent(lblSecondLine)
                .addGap(17, 17, 17)
                .addComponent(lblFirstSmallLine)
                .addGap(0, 0, 0)
                .addComponent(lblSecondSmallLine)
                .addGap(18, 18, 18)
                .addComponent(btnChatToUs, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        bottomPane.setBackground(new java.awt.Color(255, 255, 255));

        lblOfBottom.setIcon(new javax.swing.ImageIcon("back2.jpg")); // NOI18N

        javax.swing.GroupLayout bottomPaneLayout = new javax.swing.GroupLayout(bottomPane);
        bottomPane.setLayout(bottomPaneLayout);
        bottomPaneLayout.setHorizontalGroup(
            bottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOfBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bottomPaneLayout.setVerticalGroup(
            bottomPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblOfBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout mainPaneLayout = new javax.swing.GroupLayout(mainPane);
        mainPane.setLayout(mainPaneLayout);
        mainPaneLayout.setHorizontalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bottomPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPaneLayout.setVerticalGroup(
            mainPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPaneLayout.createSequentialGroup()
                .addComponent(topPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(bottomPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChatToUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatToUsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChatToUsActionPerformed


    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acceuil.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Acceuil().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomPane;
    private javax.swing.JButton btnChatToUs;
    private javax.swing.JButton btnToGet;
    private javax.swing.JLabel lblFirstLine;
    private javax.swing.JLabel lblFirstSmallLine;
    private javax.swing.JLabel lblHello;
    private javax.swing.JLabel lblOfBottom;
    private javax.swing.JLabel lblSecondLine;
    private javax.swing.JLabel lblSecondSmallLine;
    private javax.swing.JPanel mainPane;
    private javax.swing.JPanel topPane;
    // End of variables declaration//GEN-END:variables
}
