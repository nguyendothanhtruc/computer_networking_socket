package Socket.Client.GUI.Menu_Book_3;

import javax.swing.*;

public class OptionPanel extends JFrame {
    public String genre = "";
    private keeptoo.KGradientPanel Hehe;
    private javax.swing.JLabel Title;
    private javax.swing.JButton AuthorButton;
    private javax.swing.JButton TypeButton;
    private javax.swing.JPanel TypePanel;
    private javax.swing.JPanel TypePanel3;

    public OptionPanel() {
        super("Online Library - Truc&PA");
        initComponents();
    }

    private void initComponents() {
        Hehe = new keeptoo.KGradientPanel();
        Title = new javax.swing.JLabel();
        TypePanel = new javax.swing.JPanel();
        AuthorButton = new javax.swing.JButton();
        TypePanel3 = new javax.swing.JPanel();
        TypeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Hehe.setkEndColor(new java.awt.Color(0, 51, 255));
        Hehe.setkStartColor(new java.awt.Color(153, 204, 255));

        Title.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("SEARCH MORE BOOKS BY");

        TypePanel.setBackground(new java.awt.Color(255, 255, 255));

        AuthorButton.setBackground(new java.awt.Color(255, 255, 255));
        AuthorButton.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        AuthorButton.setText("AUTHOR");
        AuthorButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 10, 0, new java.awt.Color(51, 51, 255)));
        AuthorButton.setBorderPainted(false);
        AuthorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        AuthorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    AuthorActionPerformed(evt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout TypePanelLayout = new javax.swing.GroupLayout(TypePanel);
        TypePanel.setLayout(TypePanelLayout);
        TypePanelLayout.setHorizontalGroup(
                TypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(TypePanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(AuthorButton, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                                .addContainerGap())
        );
        TypePanelLayout.setVerticalGroup(
                TypePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TypePanelLayout.createSequentialGroup()
                                .addGap(0, 13, Short.MAX_VALUE)
                                .addComponent(AuthorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        TypePanel3.setBackground(new java.awt.Color(255, 255, 255));

        TypeButton.setBackground(new java.awt.Color(255, 255, 255));
        TypeButton.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        TypeButton.setText("TYPE");
        TypeButton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 10, 0, new java.awt.Color(51, 51, 255)));
        TypeButton.setBorderPainted(false);
        TypeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TypeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    TypeActionPerformed(evt);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout TypePanel3Layout = new javax.swing.GroupLayout(TypePanel3);
        TypePanel3.setLayout(TypePanel3Layout);
        TypePanel3Layout.setHorizontalGroup(
                TypePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TypePanel3Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        TypePanel3Layout.setVerticalGroup(
                TypePanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TypePanel3Layout.createSequentialGroup()
                                .addGap(0, 13, Short.MAX_VALUE)
                                .addComponent(TypeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout HeheLayout = new javax.swing.GroupLayout(Hehe);
        Hehe.setLayout(HeheLayout);
        HeheLayout.setHorizontalGroup(
                HeheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HeheLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(TypePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(TypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(58, Short.MAX_VALUE))
                        .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        HeheLayout.setVerticalGroup(
                HeheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(HeheLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(Title)
                                .addGap(18, 18, 18)
                                .addGroup(HeheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(TypePanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(TypePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Hehe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Hehe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void AuthorActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {
        genre = "2";
        synchronized (this) {
            notifyAll();
        }
        this.setVisible(false);
    }

    private void TypeActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException {
        genre = "1";
        synchronized (this) {
            notifyAll();
        }
        this.setVisible(false);
    }

    public void waitForInputs() throws InterruptedException {
        synchronized (this) {
            wait();
        }
    }

    public void RunOp() throws InterruptedException {
        this.setVisible(true);
        this.waitForInputs();
    }
}
