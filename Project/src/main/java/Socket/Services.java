package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Services
{
    final DataInputStream in; //Take message from client
    final DataOutputStream out; //Print on client terminal
    final Socket s;
    // Constructor
    public Services(Socket s, DataInputStream dis, DataOutputStream dos)
    {
        this.s = s;
        in = dis;
        out = dos;
    }
    public void Login() throws IOException {
        String username, password;
        Boolean isCorrected = false;
        while (!isCorrected) {
            // Ask user account
            out.writeUTF("Login: ");
            out.writeUTF("Username: ");
            username = in.readUTF();
            out.writeUTF("Password: ");
            password = in.readUTF();
            System.out.println(username);
            System.out.println(password);
            //isCorrected = checkAccount(username, password);
            isCorrected = true;
        }
    }
    public void Register ()
    {}
    public void Look_up() throws IOException {
        out.writeUTF("LOOK UP MENU \n 1. By ID \n 2. By Name \n Option:" );
        String op = "";
        Boolean stop = false;
        while(!stop)
        {
            op = in.readUTF();
            switch(op)
            {
                case "1":
                    stop = true;
                    break;
                case "2":
                    stop = true;
                    break;
                default: out.writeUTF("Invalid option!");
                out.writeUTF("Re-enter option: ");
            }
        }

    }
    public void List_books() throws IOException {
        out.writeUTF("LIST BOOKS MENU \n 1. By Type \n 2. By Author \n Option:" );
        String op = "";
        Boolean stop = false;
        while(!stop)
        {
            op = in.readUTF();
            switch(op)
            {
                case "1":
                    stop = true;
                    break;
                case "2":
                    stop = true;
                    break;
                default: out.writeUTF("Invalid option!");
                    out.writeUTF("Re-enter option: ");
            }
        }
    }
    public void Download()
    {}
    public void View() throws IOException {
        out.writeUTF("VIEW BOOK");
    }
}
