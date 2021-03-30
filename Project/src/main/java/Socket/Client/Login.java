package Socket.Client;

import javax.swing.*;


public class Login {
    private JPanel Login;

    public void LoginCreate() {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().Login);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
