package Socket.Client.GUI;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Login extends JFrame {
    //Socket
    private Socket socket = null;
    private DataOutputStream output = null;
    private DataInputStream input = null;

    //JFrame
    private javax.swing.JLabel ByTrucPA;
    private javax.swing.JLabel LOGIN;
    private keeptoo.KGradientPanel MainPanel;
    private javax.swing.JButton OKButton;
    private javax.swing.JPanel WhitePanel;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel password;
    private javax.swing.JLabel username;
    private javax.swing.JTextField usernameInput;

    public Login(Socket socket) throws IOException {
        super("Online Library - Truc&PA");
        this.socket = socket;
        output = new DataOutputStream(socket.getOutputStream());
        input = new DataInputStream(socket.getInputStream());
        initComponents();
    }

    private void initComponents() {
        MainPanel = new keeptoo.KGradientPanel();
        LOGIN = new javax.swing.JLabel();
        WhitePanel = new javax.swing.JPanel();
        username = new javax.swing.JLabel();
        usernameInput = new javax.swing.JTextField();
        password = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        OKButton = new javax.swing.JButton();
        ByTrucPA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LOGIN.setFont(new java.awt.Font("iCiel Panton Black", 0, 48)); // NOI18N
        LOGIN.setForeground(new java.awt.Color(255, 255, 255));
        LOGIN.setText("LOGIN");

        WhitePanel.setBackground(new java.awt.Color(255, 255, 255));

        username.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        username.setForeground(new java.awt.Color(102, 102, 255));
        username.setText("Username:");

        usernameInput.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        usernameInput.setForeground(new java.awt.Color(0, 0, 0));
        usernameInput.setText("Enter_username");
        usernameInput.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 102, 255)));


        password.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        password.setForeground(new java.awt.Color(102, 102, 255));
        password.setText("Password:");

        jPasswordField1.setText("jPasswordField1");
        jPasswordField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(120, 120, 255)));


        OKButton.setBackground(new java.awt.Color(120, 120, 255));
        OKButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        OKButton.setForeground(new java.awt.Color(255, 255, 255));
        OKButton.setText("OK");
        OKButton.setBorderPainted(false);
        OKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    OKButtonActionPerformed(evt);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout WhitePanelLayout = new javax.swing.GroupLayout(WhitePanel);
        WhitePanel.setLayout(WhitePanelLayout);
        WhitePanelLayout.setHorizontalGroup(
                WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WhitePanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(password)
                                        .addComponent(username)
                                        .addComponent(usernameInput)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                                .addContainerGap(45, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WhitePanelLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27))
        );
        WhitePanelLayout.setVerticalGroup(
                WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WhitePanelLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(username)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(password)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)
                                .addComponent(OKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(20, Short.MAX_VALUE))
        );

        ByTrucPA.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        ByTrucPA.setForeground(new java.awt.Color(255, 255, 255));
        ByTrucPA.setText("By Truc & PA");

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(129, 129, 129)
                                                .addComponent(LOGIN))
                                        .addGroup(MainPanelLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(WhitePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(45, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ByTrucPA)
                                .addGap(21, 21, 21))
        );
        MainPanelLayout.setVerticalGroup(
                MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainPanelLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(LOGIN)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(WhitePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                        .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }

    public void waitForInputs() throws InterruptedException {
        synchronized (this) {
            wait();
        }
    }

    public void RunLogin() {
        try {
            this.setVisible(true);
            this.waitForInputs();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void OKButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {

        try {
            output.writeUTF(usernameInput.getText());
            output.writeUTF(String.valueOf(jPasswordField1.getPassword()));
            output.flush();

            boolean LoginSuccess = false;
            LoginSuccess = input.readBoolean(); //Receive regis_flag from sv

            if (LoginSuccess) {
                JOptionPane.showMessageDialog(null, "Login successfully");
                this.setVisible(false);
                synchronized (this) {
                    notifyAll();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Failed to login");
            }

        } catch (IOException io) {
            System.out.println("Close GUI");
            socket.close();
            input.close();
            output.close();
        } finally {
            this.dispose();
        }
    }
}
