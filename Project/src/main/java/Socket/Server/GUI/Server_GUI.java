package Socket.Server.GUI;

import javax.swing.*;

import Socket.Server.Server;

import java.io.IOException;

public class Server_GUI extends JFrame {

    Server server;

    private javax.swing.JButton CONNECT;
    private javax.swing.JLabel Credit;
    private javax.swing.JButton DISCONNECT;
    private javax.swing.JTextArea Display;
    private keeptoo.KGradientPanel Panel;
    private javax.swing.JScrollBar ScrollBar;
    private javax.swing.JLabel Title;
    private javax.swing.JScrollPane jScrollPane1;

    private static Object lock = new Object();

    public Server_GUI(Server s) {
        server = s;
        initComponents();
    }


    private void initComponents() {

        Panel = new keeptoo.KGradientPanel();
        Title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Display = new javax.swing.JTextArea();
        ScrollBar = new javax.swing.JScrollBar();
        Credit = new javax.swing.JLabel();
        CONNECT = new javax.swing.JButton();
        DISCONNECT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Title.setFont(new java.awt.Font("iCiel Panton Black", 0, 48)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("SERVER LOG");
        Title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        Display.setColumns(20);
        Display.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Display.setRows(5);
        jScrollPane1.setViewportView(Display);

        Credit.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        Credit.setForeground(new java.awt.Color(255, 255, 255));
        Credit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Credit.setText("By Truc & PA");

        CONNECT.setBackground(new java.awt.Color(0, 204, 51));
        CONNECT.setFont(new java.awt.Font("iCiel Panton Black", 1, 18)); // NOI18N
        CONNECT.setForeground(new java.awt.Color(255, 255, 255));
        CONNECT.setText("CONNECT");
        CONNECT.setBorderPainted(false);
        CONNECT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONNECTActionPerformed(evt);
            }
        });

        DISCONNECT.setBackground(new java.awt.Color(255, 102, 102));
        DISCONNECT.setFont(new java.awt.Font("iCiel Panton Black", 1, 18)); // NOI18N
        DISCONNECT.setForeground(new java.awt.Color(255, 255, 255));
        DISCONNECT.setText("DISCONNECT");
        DISCONNECT.setBorderPainted(false);
        DISCONNECT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DISCONNECTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
                PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(PanelLayout.createSequentialGroup()
                                                .addComponent(CONNECT, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(DISCONNECT, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(ScrollBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(40, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Credit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        PanelLayout.setVerticalGroup(
                PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(PanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                                        .addComponent(ScrollBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(CONNECT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(DISCONNECT, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Credit)
                                .addContainerGap())
        );

        Title.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>

    private void DISCONNECTActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null,"OK");
        //server.setAlive(false);
        //server.Disconnect();
    }

    private void CONNECTActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        server.setAlive(true);
        JOptionPane.showMessageDialog(null,"Server is online");
        synchronized (this) {
            // Release the waiting threads
            notifyAll();
        }
    }

    public void waitForInputs() throws InterruptedException {
        synchronized (this) {
            // Make the current thread waits until a notify or an interrupt
            wait();
        }
    }
    public void Run()
    {
        try {
            Server_GUI server_gui=new Server_GUI(server);
            server_gui.setVisible(true);
            server_gui.waitForInputs();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
