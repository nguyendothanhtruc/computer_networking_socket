package Socket.Client.GUI;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


public class Registration extends JFrame {
    //Socket
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    //JFrame
    private keeptoo.KGradientPanel Apply;
    private javax.swing.JLabel Confirm;
    private javax.swing.JPasswordField ConfirmHidden;
    private javax.swing.JButton OK;
    private javax.swing.JLabel Password;
    private javax.swing.JPasswordField PasswordHidden;
    private javax.swing.JLabel Register;
    private javax.swing.JTextField TextUsername;
    private javax.swing.JLabel Username;
    private javax.swing.JPanel WhitePanel;
    private javax.swing.JLabel jLabel1;
    private keeptoo.KGradientPanel kGradientPanel1;

    private static Object lock = new Object();


    public Registration(Socket socket) throws IOException {
        this.socket = socket;
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
        initComponents();
    }

    public static void RunReg(Socket socket) throws IOException {
        //java.awt.EventQueue.invokeLater(new Runnable() {
        // public void run() {
        try {
            Registration registration = new Registration(socket);
            registration.setVisible(true);
            registration.waitForInputs();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        //}
        // });
    }

    public void waitForInputs() throws InterruptedException {
        synchronized (this) {
            // Make the current thread waits until a notify or an interrupt
            wait();
        }
    }

    private void initComponents() {
        kGradientPanel1 = new keeptoo.KGradientPanel();
        Register = new javax.swing.JLabel();
        WhitePanel = new javax.swing.JPanel();
        Username = new javax.swing.JLabel();
        TextUsername = new javax.swing.JTextField();
        Password = new javax.swing.JLabel();
        Confirm = new javax.swing.JLabel();
        Apply = new keeptoo.KGradientPanel();
        PasswordHidden = new javax.swing.JPasswordField();
        ConfirmHidden = new javax.swing.JPasswordField();
        OK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));

        kGradientPanel1.setkEndColor(new java.awt.Color(0, 0, 204));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 51, 255));

        Register.setFont(new java.awt.Font("iCiel Panton Black", 0, 48)); // NOI18N
        Register.setForeground(new java.awt.Color(255, 255, 255));
        Register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Register.setText("REGISTER");
        Register.setToolTipText("");

        WhitePanel.setBackground(new java.awt.Color(255, 255, 255));

        Username.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        Username.setForeground(new java.awt.Color(102, 102, 255));
        Username.setText("Username:");

        TextUsername.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        //TextUsername.setForeground(new java.awt.Color(204, 204, 204));
        TextUsername.setForeground(new java.awt.Color(0, 0, 0));
        TextUsername.setText("Enter username");
        TextUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(102, 102, 255)));
        TextUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        Password.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        Password.setForeground(new java.awt.Color(102, 102, 255));
        Password.setText("Password:");

        Confirm.setFont(new java.awt.Font("iCiel Panton Black", 0, 24)); // NOI18N
        Confirm.setForeground(new java.awt.Color(102, 102, 255));
        Confirm.setText("Confirm:");

        Apply.setkEndColor(new java.awt.Color(255, 102, 255));
        Apply.setkStartColor(new java.awt.Color(0, 0, 255));
        Apply.setMaximumSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout ApplyLayout = new javax.swing.GroupLayout(Apply);
        Apply.setLayout(ApplyLayout);
        ApplyLayout.setHorizontalGroup(
                ApplyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 39, Short.MAX_VALUE)
        );
        ApplyLayout.setVerticalGroup(
                ApplyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 19, Short.MAX_VALUE)
        );

        PasswordHidden.setText("jPasswordField1");
        PasswordHidden.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 120, 215)));

        ConfirmHidden.setText("jPasswordField1");
        ConfirmHidden.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 120, 215)));

        OK.setBackground(new java.awt.Color(102, 102, 255));
        OK.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        OK.setForeground(new java.awt.Color(255, 255, 255));
        OK.setText("OK");
        OK.setBorder(null);
        OK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    OKActionPerformed(evt);
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
                                .addGap(50, 50, 50)
                                .addGroup(WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(WhitePanelLayout.createSequentialGroup()
                                                .addGap(256, 256, 256)
                                                .addComponent(OK, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(66, 66, 66)
                                                .addComponent(Apply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(Confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(TextUsername, javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(ConfirmHidden, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                                                .addComponent(PasswordHidden, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        WhitePanelLayout.setVerticalGroup(
                WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(WhitePanelLayout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(Password, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ConfirmHidden, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                                .addGroup(WhitePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, WhitePanelLayout.createSequentialGroup()
                                                .addComponent(Confirm)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(PasswordHidden, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)
                                                .addComponent(Apply, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(OK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("By Truc & PA");

        javax.swing.GroupLayout kGradientPanel1Layout = new javax.swing.GroupLayout(kGradientPanel1);
        kGradientPanel1.setLayout(kGradientPanel1Layout);
        kGradientPanel1Layout.setHorizontalGroup(
                kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(WhitePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(52, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Register, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, kGradientPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
        );
        kGradientPanel1Layout.setVerticalGroup(
                kGradientPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(kGradientPanel1Layout.createSequentialGroup()
                                .addContainerGap(28, Short.MAX_VALUE)
                                .addComponent(Register)
                                .addGap(18, 18, 18)
                                .addComponent(WhitePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(kGradientPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)

        );

        pack();
    }

    private void OKActionPerformed(java.awt.event.ActionEvent evt) throws IOException {

        output.writeUTF(TextUsername.getText());
        output.writeUTF(String.valueOf(PasswordHidden.getPassword()));
        output.writeUTF(String.valueOf(ConfirmHidden.getPassword()));
        output.flush();

        boolean RegisSuccess = false;
        RegisSuccess = input.readBoolean(); //Receive regis_flag from sv

        //Check if Login_success
        if (RegisSuccess) {
            JOptionPane.showMessageDialog(null, "Register successfully");
            this.setVisible(false);
            synchronized (this) {
                // Release the waiting threads
                notifyAll();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Failed to register");
        }

    }
}


