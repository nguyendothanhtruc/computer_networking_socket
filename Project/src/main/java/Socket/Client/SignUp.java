package Socket.Client;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
        Button_OK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username, password, c_password;
                username=JLabel_Username.getText();
                password=String.valueOf(Pass_Password.getPassword());
                c_password=String.valueOf(Pass_Confirm.getPassword());
                System.out.println(c_password);
                //clien.register(user,pass,pass2) bool -> if(1) ->GUI khac'
                if(true) {
                    //JOptionPane.showMessageDialog("OK");
                    Login login=new Login();
                    login.LoginCreate();

                }

            }
        });
    }

    public void SignUpCreate() {
        JFrame frame = new JFrame("SignUp");
        SignUp content = new SignUp();
        frame.setContentPane(content.RootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

