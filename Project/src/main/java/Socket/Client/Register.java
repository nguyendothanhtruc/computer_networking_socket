package Socket.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Register extends JFrame {
    private JPanel RootPanel;
    private JLabel JLabel_SignUp;
    private JButton Button_OK;
    private JTextField Text_Username;
    private JPasswordField Pass_Password;
    private JPasswordField Pass_Confirm;
    private JLabel JLabel_Username;
    private JLabel JLabel_Password;
    private JLabel JLabel_Confirm;

    //Socket
    private static Socket socket = null;
    private static int port;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    public Register(Socket socket) throws IOException {
        super("Sign up panel");

        //Socket
        this.socket = socket;
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());


        Text_Username.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        Text_Username.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
        Button_OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean RegisSuccess = false;
                while (!RegisSuccess) {
                    try {

                        output.writeUTF(Text_Username.getText());

                        output.writeUTF(String.valueOf(Pass_Password.getPassword()));

                        output.writeUTF(String.valueOf(Pass_Password.getPassword()));

                        output.flush();

                        RegisSuccess = input.readBoolean(); //Receive regis_flag from sv
                        //Check if Login_success
                        if (RegisSuccess) {
                            JOptionPane.showMessageDialog(null, "Register successfully");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to register");
                        }
                    } catch (IOException i) {
                        System.out.println(i);
                    }
                }
            }
        });
    }


    public static void main(String[] args) throws IOException {

        Client client = new Client("localhost", 9999);
        String direction_flag = "";
        do {
            direction_flag = client.SignUpForm(); //LOOP UNTIL LOGIN SUCCESSFULLY
            switch (direction_flag) {
                case "1": {
                    client.Login();
                    break;
                }
                case "2": {
                    JFrame frame = new JFrame("SignUp");
                    Register reg = new Register(client.getSocket());
                    //Add cac thanh phan trong RootPanel vao
                    frame.setContentPane(reg.RootPanel);
                    //Tat khi bam exit
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setVisible(true);

                    break;
                }
            }
        } while (!direction_flag.equals("1"));

    }
}