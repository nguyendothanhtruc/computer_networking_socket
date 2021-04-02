package Socket.Client.GUI;

import Socket.Book;

import javax.swing.*;

public class BookInfo extends JFrame {
    private Book myBook;
    //JFrame
    private JFrame frame;
    private javax.swing.JLabel ByTrucPA;
    private javax.swing.JButton Download;
    private javax.swing.JButton FindMore;
    private keeptoo.KGradientPanel MainPanel;
    private javax.swing.JLabel Title;
    private javax.swing.JButton View;
    private javax.swing.JLabel Content;
    private javax.swing.JPanel jPanel1;
    public BookInfo(Book b) {
        myBook=b;
        initComponents();
        frame=this;
    }

    private void initComponents() {

        MainPanel = new keeptoo.KGradientPanel();
        Title = new javax.swing.JLabel();
        Download = new javax.swing.JButton();
        FindMore = new javax.swing.JButton();
        View = new javax.swing.JButton();
        ByTrucPA = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Content = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setkEndColor(new java.awt.Color(0, 51, 204));
        MainPanel.setkStartColor(new java.awt.Color(255, 102, 255));

        Title.setFont(new java.awt.Font("iCiel Panton Black", 0, 48)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("BOOK INFORMATION");

        Download.setBackground(new java.awt.Color(51, 204, 255));
        Download.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        Download.setForeground(new java.awt.Color(255, 255, 255));
        Download.setText("DOWNLOAD");
        Download.setBorderPainted(false);
        Download.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        FindMore.setBackground(new java.awt.Color(51, 204, 255));
        FindMore.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        FindMore.setForeground(new java.awt.Color(255, 255, 255));
        FindMore.setText("FIND MORE");
        FindMore.setBorderPainted(false);
        FindMore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        Content.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        Content.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(Content, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(Content, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(View, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(Download, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                                .addGap(26, 26, 26)
                                .addComponent(FindMore, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ByTrucPA, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(Title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(View, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Download, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(FindMore, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
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
    }

    public void RunBI(){
        Content.setText("<html>" + myBook.convertBook().replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>");
        frame.setVisible(true);
    }

}
