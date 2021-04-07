package Socket.Client.GUI.Menu_Book_3;

import Socket.Book;
import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class findMoreBooks extends JFrame {
    //Socket
    private JFrame frame=null;
    private Socket socket = null;
    private DataOutputStream output = null;
    private DataInputStream input = null;
    private ArrayList<Book> bookList =null;
    //JFrame
    private javax.swing.JTextField BookPIck;
    private javax.swing.JLabel ByTrucPA;
    private keeptoo.KGradientPanel MainPanel;
    private javax.swing.JLabel Title;
    private javax.swing.JButton View_Search;
    private javax.swing.JTextArea ViewManyInfo;
    private javax.swing.JScrollPane jScrollPane1;

    public findMoreBooks(Socket socket, ArrayList<Book> bookList) throws IOException {
        super("Online Library - Truc&PA");
        this.socket=socket;
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
        this.bookList=bookList;
        initComponents();

        ViewManyInfo.setMargin( new Insets(10,10,10,10) );
        ViewManyInfo.requestFocus();
        ViewManyInfo.setEditable(false);

        frame=this;
    }

    private void initComponents() {

        MainPanel = new keeptoo.KGradientPanel();
        Title = new javax.swing.JLabel();
        View_Search = new javax.swing.JButton();
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

        View_Search.setBackground(new java.awt.Color(51, 204, 255));
        View_Search.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        View_Search.setForeground(new java.awt.Color(255, 255, 255));
        View_Search.setText("VIEW");
        View_Search.setAlignmentY(0.0F);
        View_Search.setBorderPainted(false);
        View_Search.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        View_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    SearchActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

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
                                                .addComponent(View_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(View_Search, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
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
        setLocationRelativeTo(null);
    }

    public void waitForInputs() throws InterruptedException {
        synchronized (this) {
            wait();
        }
    }
    private void SearchActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        try {
            String searchContent = BookPIck.getText();

            String BookHeader, BookContent = null;
            String direction_flag = ""; //Get_type

            int pos = searchContent.indexOf(" ");
            BookHeader = searchContent.substring(0, pos); //Get the F_X part

            BookContent = searchContent.substring(pos + 1); //Get the name/ID part

            if (BookHeader.equals("F_ID")) direction_flag = "1";
            else if (BookHeader.equals("F_Name")) direction_flag = "2";

            output.writeUTF(direction_flag); //Send the search-option to server
            output.writeUTF(BookContent);

            Boolean isReturn = input.readBoolean();
            System.out.println("Give me back");

            if (isReturn) {
                switch (direction_flag) {
                    case "1" -> {
                        JOptionPane.showMessageDialog(null, "Searching by ID");
                        this.setVisible(false);
                        synchronized (this) {
                            notifyAll();
                        }
                        this.dispose();
                    }
                    case "2" -> {
                        JOptionPane.showMessageDialog(null, "Searching by Name");
                        this.setVisible(false);
                        synchronized (this) {
                            notifyAll();
                        }
                        this.dispose();
                    }
                    default -> System.out.println("Error search book");
                }
            } else JOptionPane.showMessageDialog(null, "Book not found");
        }catch (IOException io)
        {
            System.out.println(io.toString());
            System.out.println("Close GUI");
            socket.close();
            input.close();
            output.close();
            this.dispose();
        }
    }
    public void Run() throws InterruptedException {
        StringBuilder content= new StringBuilder();
        int NumBook=bookList.size();

        for (int i=0;i<NumBook;i++)
        {
            content.append(bookList.get(i).convertBook());
            content.append("\n\n");
        }

        ViewManyInfo.setText(content.toString());

        this.setVisible(true);
        this.waitForInputs();
    }




}
