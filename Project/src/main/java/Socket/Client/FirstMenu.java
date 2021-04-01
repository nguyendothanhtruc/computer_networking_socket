package Socket.Client;


import javax.swing.*;
import Socket.Client.Client;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class FirstMenu extends JFrame {

    //Socket
    private static Socket socket = null;
    private DataOutputStream output = null;

    public String getOption() {
        return option;
    }

    private String option=null;

    //JFrame
    private javax.swing.JLabel ByTrucPA;
    private javax.swing.JLabel HCMUS;
    private javax.swing.JButton Login;
    private javax.swing.JPanel LoginBackground;
    private keeptoo.KGradientPanel MainPanel;
    private javax.swing.JLabel OnlineLibrary;
    private javax.swing.JLabel Picture;
    private javax.swing.JButton Regis;
    private javax.swing.JPanel RegisBackground;
    private javax.swing.JLabel SocketP;
    private javax.swing.JTextField jTextField1;
    private Object BufferedImage;

    public FirstMenu(Socket socket) throws IOException {
        this.socket = socket;
        output = new DataOutputStream(socket.getOutputStream());
        initComponents();
    }

    public static void FirstMenu_Run(Socket socket) throws IOException {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    new FirstMenu(socket).setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initComponents() throws IOException {

        jTextField1 = new javax.swing.JTextField();
        MainPanel = new keeptoo.KGradientPanel();
        OnlineLibrary = new javax.swing.JLabel();
        LoginBackground = new javax.swing.JPanel();
        Login = new javax.swing.JButton();
        RegisBackground = new javax.swing.JPanel();
        Regis = new javax.swing.JButton();
        Picture = new javax.swing.JLabel();
        ByTrucPA = new javax.swing.JLabel();
        HCMUS = new javax.swing.JLabel();
        SocketP = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MainPanel.setkEndColor(new java.awt.Color(0, 51, 204));
        MainPanel.setkStartColor(new java.awt.Color(255, 102, 255));

        OnlineLibrary.setFont(new java.awt.Font("iCiel Panton Black", 0, 48)); // NOI18N
        OnlineLibrary.setForeground(new java.awt.Color(255, 255, 255));
        OnlineLibrary.setText("ONLINE LIBRARY");

        LoginBackground.setBackground(new java.awt.Color(255, 255, 255));

        Login.setBackground(new java.awt.Color(102, 153, 255));
        Login.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        Login.setForeground(new java.awt.Color(255, 255, 255));
        Login.setText("New account");
        Login.setBorder(null);
        Login.setBorderPainted(false);
        Login.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    LoginActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout LoginBackgroundLayout = new javax.swing.GroupLayout(LoginBackground);
        LoginBackground.setLayout(LoginBackgroundLayout);
        LoginBackgroundLayout.setHorizontalGroup(
                LoginBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginBackgroundLayout.createSequentialGroup()
                                .addContainerGap(14, Short.MAX_VALUE)
                                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        LoginBackgroundLayout.setVerticalGroup(
                LoginBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginBackgroundLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Login, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        RegisBackground.setBackground(new java.awt.Color(255, 255, 255));

        Regis.setBackground(new java.awt.Color(102, 153, 255));
        Regis.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        Regis.setForeground(new java.awt.Color(255, 255, 255));
        Regis.setText("Login");
        Regis.setBorder(null);
        Regis.setBorderPainted(false);
        Regis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Regis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    RegisActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout RegisBackgroundLayout = new javax.swing.GroupLayout(RegisBackground);
        RegisBackground.setLayout(RegisBackgroundLayout);
        RegisBackgroundLayout.setHorizontalGroup(
                RegisBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisBackgroundLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(Regis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        RegisBackgroundLayout.setVerticalGroup(
                RegisBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, RegisBackgroundLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Regis, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
        Picture.setIcon(new javax.swing.ImageIcon(String.valueOf(getClass().getClassLoader().getResource("D:\\MMT_Socket\\Project\\src\\main\\java\\Socket\\Client")))); // NOI18N


        ByTrucPA.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        ByTrucPA.setText("BY TRUC & PA");

        HCMUS.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        HCMUS.setForeground(new java.awt.Color(255, 255, 255));
        HCMUS.setText("HCMUS - 19CLC5");

        SocketP.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        SocketP.setText("SOCKET PROGRAMMING");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ByTrucPA)
                                        .addComponent(Picture)
                                        .addComponent(HCMUS)
                                        .addComponent(SocketP))
                                .addGap(32, 32, 32)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                                .addComponent(LoginBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(RegisBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(40, 40, 40))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(OnlineLibrary, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(81, 81, 81))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(OnlineLibrary)
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                                .addComponent(HCMUS)
                                                .addGap(18, 18, 18)
                                                .addComponent(SocketP)
                                                .addGap(18, 18, 18)
                                                .addComponent(ByTrucPA)
                                                .addGap(26, 26, 26)
                                                .addComponent(Picture, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(64, 64, 64)
                                                .addComponent(RegisBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(LoginBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))))
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

    private void LoginActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        output.writeUTF("1");
        this.setVisible(false);
        option="1";
        output.close();
    }

    private void RegisActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        output.writeUTF("2");
        this.setVisible(false);
        option="2";
        output.close();
    }


}
