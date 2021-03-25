package Socket;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
    private JTextField username;
    private JPasswordField password1;
    private JPasswordField password2;
    private JButton cancelButton;
    private JButton OKButton;
    private JLabel Username;
    private JLabel SIGNUPFORMLabel;
    private JSeparator separator1;
    private JLabel passwordLabel;
    private JLabel confirmPasswordLabel;
    private JSeparator separator2;

    public Login() {
        add(password1);
        add(password2);

    }


    public static void main(String[] args) {

        Login login = new Login();
        login.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}