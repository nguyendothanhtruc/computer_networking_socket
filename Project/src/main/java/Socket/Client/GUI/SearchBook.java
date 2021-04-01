package Socket.Client.GUI;

import javax.swing.*;

class SearchBook extends JFrame {
    //JFrame
    private javax.swing.JLabel BookSearching;
    private javax.swing.JLabel FrogPic;
    private javax.swing.JTextField Insert;
    private keeptoo.KGradientPanel MainPanel;
    private javax.swing.JButton Search;
    private javax.swing.JLabel Syntax;
    private javax.swing.JTextField jTextField1;
    public SearchBook() {
        initComponents();
    }

    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        MainPanel = new keeptoo.KGradientPanel();
        Syntax = new javax.swing.JLabel();
        Search = new javax.swing.JButton();
        Insert = new javax.swing.JTextField();
        BookSearching = new javax.swing.JLabel();
        FrogPic = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setkEndColor(new java.awt.Color(0, 51, 204));
        MainPanel.setkStartColor(new java.awt.Color(255, 102, 255));

        Syntax.setFont(new java.awt.Font("Calibri", 2, 24)); // NOI18N
        Syntax.setForeground(new java.awt.Color(0, 51, 102));
        Syntax.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Syntax.setText("SYNTAX: F_ID <content> OR F_Name <content>");

        Search.setBackground(new java.awt.Color(102, 153, 255));
        Search.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        Search.setForeground(new java.awt.Color(255, 255, 255));
        Search.setText("S E A R C H");
        Search.setBorder(null);
        Search.setBorderPainted(false);
        Search.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchActionPerformed(evt);
            }
        });

        Insert.setFont(new java.awt.Font("Tahoma", 2, 36)); // NOI18N
        Insert.setForeground(new java.awt.Color(0, 0, 153));
        Insert.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Insert.setText("Insert your book here");
        Insert.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 0, 4, 0, new java.awt.Color(120, 120, 255)));

        BookSearching.setFont(new java.awt.Font("iCiel Panton Black", 0, 48)); // NOI18N
        BookSearching.setForeground(new java.awt.Color(255, 255, 255));
        BookSearching.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BookSearching.setText("BOOK SEARCHING");

        FrogPic.setIcon(new ImageIcon("giaosu.png"));
        //FrogPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/mavenproject1/giaosu.png"))); // NOI18N

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BookSearching, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Syntax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(107, 107, 107)
                                                .addComponent(FrogPic)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(97, 97, 97)
                                                .addComponent(Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(109, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(BookSearching, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Syntax, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addComponent(FrogPic))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                       // .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MainPanel, 700, 700, 700)

        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        //.addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MainPanel, 500, 500, 500)
        );

        pack();
    }// </editor-fold>

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchBook().setVisible(true);
            }
        });
    }



}
