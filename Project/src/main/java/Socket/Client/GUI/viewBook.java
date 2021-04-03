package Socket.Client.GUI;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

public class viewBook extends JFrame {
    //Name
    private String bookName;
    private String filePath;
    //JFrame
    private javax.swing.JTextArea Book;
    private javax.swing.JLabel Credit;
    private keeptoo.KGradientPanel Panel;
    private javax.swing.JScrollPane ScrollPanel;
    private javax.swing.JLabel Title;

    public viewBook(String bookName, String filepath) throws FileNotFoundException, IOException {
        super("Online Library - Truc&PA");
        this.bookName=bookName;
        this.filePath=filepath;
        initComponents();

        //Load book from file
        BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(filepath), StandardCharsets.UTF_8));
        Book.read(in, null);
        in.close();

        //Customize
        Book.setWrapStyleWord(true);
        Book.setLineWrap(true); //Lock width
        Book.setMargin( new Insets(10,10,10,10) );
        Book.requestFocus();
        Book.setEditable(false);
    }
    private void initComponents() {
        Panel = new keeptoo.KGradientPanel();
        Title = new javax.swing.JLabel();
        Credit = new javax.swing.JLabel();
        ScrollPanel = new javax.swing.JScrollPane();
        Book = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("iCiel Panton Black", 0, 48)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText(bookName);
        Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Credit.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        Credit.setForeground(new java.awt.Color(255, 255, 255));
        Credit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Credit.setText("By Truc & PA");

        Book.setColumns(20);
        Book.setFont(new java.awt.Font("iCiel Panton Black", 0, 20)); // NOI18N
        Book.setRows(5);
        ScrollPanel.setViewportView(Book);

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Credit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(ScrollPanel)
                                        .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE))
                                .addContainerGap(47, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ScrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(Credit)
                                .addGap(19, 19, 19))
        );

        Title.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    public void RunvB() {
        try {
            new viewBook(bookName,filePath).setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

