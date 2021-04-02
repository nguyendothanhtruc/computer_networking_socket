package Socket.Client.GUI;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class SearchBook extends javax.swing.JFrame {
    //Socket
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;
    //JFrame
    private javax.swing.JLabel BookSearching;
    private javax.swing.JLabel FrogPic;
    private javax.swing.JTextField Insert;
    private keeptoo.KGradientPanel MainPanel;
    private javax.swing.JButton Search;
    private javax.swing.JLabel Syntax;
    private javax.swing.JTextField jTextField1;

    public SearchBook(Socket socket) throws IOException {
        this.socket = socket;
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
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
        javax.swing.JLabel byTrucPA = new javax.swing.JLabel();

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
                try {
                    SearchActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
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

        byTrucPA.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        byTrucPA.setForeground(new java.awt.Color(255, 255, 255));
        byTrucPA.setText("By Truc & PA");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(BookSearching, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Syntax, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(107, 107, 107)
                                                .addComponent(FrogPic)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(97, 97, 97)
                                                .addComponent(Insert, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addComponent(byTrucPA)
                                .addGap(20, 20, 20))
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
                                .addGap(53, 53, 53)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addComponent(FrogPic)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addComponent(Search, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(byTrucPA)
                                                .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    public void waitForInputs() throws InterruptedException {
        synchronized (this) {
            // Make the current thread waits until a notify or an interrupt
            wait();
        }
    }

    private void SearchActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        String searchContent = Insert.getText();

        String BookHeader, BookContent = null;
        String direction_flag = ""; //Get_type

        //Loop until type of searching is found
        int pos = searchContent.indexOf(" ");
        BookHeader = searchContent.substring(0, pos); //Get the F_X part

        BookContent = searchContent.substring(pos + 1, searchContent.length()); //Get the name/ID part
        /*
        System.out.println("H:" + BookHeader);
        System.out.println("S:" + BookContent);
        System.out.println("Str: " + searchContent.length());*/

        if (BookHeader.equals("F_ID")) direction_flag = "1";
        else if (BookHeader.equals("F_Name")) direction_flag = "2";

        output.writeUTF(direction_flag); //Send the search-option to server
        System.out.println(direction_flag);
        output.writeUTF(BookContent);

        Boolean isReturn=input.readBoolean();
        System.out.println(isReturn);

        if(isReturn)
        { switch (direction_flag) {
            case "1" -> {
                JOptionPane.showMessageDialog(null, "Searching by ID");
                this.setVisible(false);
                synchronized (this) {
                    notifyAll();
                }
            }
            case "2" -> {
                JOptionPane.showMessageDialog(null, "Searching by Name");
                this.setVisible(false);
                synchronized (this) {
                    notifyAll();
                }
            }
            default -> System.out.println("Error search book");
        }
    }
        else  JOptionPane.showMessageDialog(null, "Book not found");
    }

    public void RunSB(Socket socket) {

        try {
            SearchBook searchBook = new SearchBook(socket);
            searchBook.setVisible(true);
            searchBook.waitForInputs();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }


}
