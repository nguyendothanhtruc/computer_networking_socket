package Socket.Client.GUI;

public class findMoreBooks extends javax.swing.JFrame {
    public findMoreBooks() {
        super("Online Library - Truc&PA");
        initComponents();
    }

    private void initComponents() {

        MainPanel = new keeptoo.KGradientPanel();
        Title = new javax.swing.JLabel();
        View = new javax.swing.JButton();
        ByTrucPA = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ViewManyInfo = new javax.swing.JTextArea();
        BookPIck = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setkEndColor(new java.awt.Color(0, 51, 204));
        MainPanel.setkStartColor(new java.awt.Color(255, 102, 255));

        Title.setFont(new java.awt.Font("iCiel Panton Black", 0, 48)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("LIBRARY FOUND:");

        View.setBackground(new java.awt.Color(51, 204, 255));
        View.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        View.setForeground(new java.awt.Color(255, 255, 255));
        View.setText("VIEW");
        View.setAlignmentY(0.0F);
        View.setBorderPainted(false);
        View.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ByTrucPA.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        ByTrucPA.setForeground(new java.awt.Color(255, 255, 255));
        ByTrucPA.setText("By Truc & PA");

        ViewManyInfo.setColumns(20);
        ViewManyInfo.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        ViewManyInfo.setRows(5);
        ViewManyInfo.setBorder(javax.swing.BorderFactory.createMatteBorder(10, 10, 10, 10, new java.awt.Color(255, 255, 255)));
        jScrollPane1.setViewportView(ViewManyInfo);

        BookPIck.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        BookPIck.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        BookPIck.setText("Input F_ID <Content> or F_Name <Content>");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ByTrucPA, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addComponent(View, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(BookPIck)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(Title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(View, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                        .addComponent(BookPIck))
                                .addGap(17, 17, 17)
                                .addComponent(ByTrucPA)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(findMoreBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(findMoreBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(findMoreBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(findMoreBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new findMoreBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField BookPIck;
    private javax.swing.JLabel ByTrucPA;
    private keeptoo.KGradientPanel MainPanel;
    private javax.swing.JLabel Title;
    private javax.swing.JButton View;
    private javax.swing.JTextArea ViewManyInfo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration
}
