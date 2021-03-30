package Socket.Client;

import javax.swing.*;
import Socket.Client.Client;


public class SignUp {
    private JPanel RootPanel;
    private JLabel JLabel_SignUp;
    private JButton Button_OK;
    private JTextField Text_Username;
    private JPasswordField Pass_Password;
    private JPasswordField Pass_Confirm;
    private JLabel JLabel_Username;
    private JLabel JLabel_Password;
    private JLabel JLabel_Confirm;

    public SignUp() {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("SignUp");
        SignUp content = new SignUp();
        frame.setContentPane(content.RootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}