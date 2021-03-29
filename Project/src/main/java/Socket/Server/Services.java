package Socket.Server;
import Socket.Book;

import Socket.Server.DataHandler;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;

public class Services {
    final DataInputStream in; //Take message from client
    final DataOutputStream out; //Print on client terminal
    final ObjectOutputStream oos;
    final Socket s;

    // Constructor
    public Services(Socket s, DataInputStream dis, DataOutputStream dos, ObjectOutputStream oos) {
        this.s = s;
        in = dis;
        out = dos;
        this.oos = oos;
    }

    public void Login() throws IOException, SQLException {
        String username = "", password;
        Boolean isCorrected = false;
        System.out.println("Client logins");

        while (!isCorrected) {
            // Receive user account
            username = in.readUTF();
            password = in.readUTF();

            DataHandler dataHandler = new DataHandler();

            isCorrected = dataHandler.checkPassword(username, password);
            out.writeBoolean(isCorrected);
        }
        System.out.println("User: " + username + " logins successfully!");
    }

    public void Register() throws IOException, SQLException {
        String username = "", password, confirm;
        Boolean Regis_Success = false;
        System.out.println("Client registers");

        DataHandler dataHandler = new DataHandler();

        while (!Regis_Success) {
            //Receive user account
            username = in.readUTF();
            password = in.readUTF();
            confirm = in.readUTF();

            System.out.println(username);
            System.out.println(password);
            System.out.println(confirm);

            if (!password.equals(confirm)) {
                System.out.println("User: " + username + " registers unsuccessfully!");
                out.writeBoolean(Regis_Success);
            } else {
                Regis_Success = dataHandler.Register(username, password);
                System.out.println("User: " + username + " registers successfully!");
                out.writeBoolean(Regis_Success);
            }
        }

    }

    public void Look_up() {
    }

    public void List_books() {
    }

    public void Download() {
    }

    public void View(String option, String Search_key) {
        DataHandler dataHandler = new DataHandler();
        try {
            Book found = new Book();
            Boolean isFound = dataHandler.find_Book(option, Search_key, found);

            out.writeBoolean(isFound);
            if (isFound)
            {
                oos.writeObject(found);
                found.display();
            }
        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
}
