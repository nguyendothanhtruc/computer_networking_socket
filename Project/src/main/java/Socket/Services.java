package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

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
    public void Login() throws IOException, SQLException {
        String username, password;
        Boolean isCorrected = false;
        while (!isCorrected) {
            // Ask user account
            username = in.readUTF();
            password = in.readUTF();

            DataHandler dataHandler = new DataHandler();
            isCorrected = dataHandler.checkPassword(username, password);
            out.writeBoolean(isCorrected);
        }
    }

    public void Register ()
    {}
    public void Look_up()
    {}
    public void List_books()
    {}
    public void Download()
    {}
    public void View(){

    }
}
