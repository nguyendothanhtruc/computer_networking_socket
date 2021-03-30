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

public class Services extends Thread {
    private DataInputStream in = null; //Take message from client
    private DataOutputStream out = null; //Print on client terminal
    private ObjectOutputStream oos = null;
    private String username;
    final Socket socket;

    // Constructor
    public Services(Socket s) throws IOException {
        socket = s;

        //Communicate with client:
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        oos = new ObjectOutputStream(out);
    }

    public void Login() throws IOException, SQLException {
        String password;
        Boolean isCorrected = false;
        System.out.println("Client logins: ");

        while (!isCorrected) {
            // Receive user account
            username = in.readUTF();
            password = in.readUTF();

            DataHandler dataHandler = new DataHandler();

            isCorrected = dataHandler.checkPassword(username, password);
            out.writeBoolean(isCorrected);
        }
        System.out.println("User: " + username + " logins successfully! \n");
    }

    public void Register() throws IOException, SQLException {
        String password, confirm;
        Boolean Regis_Success = false;
        System.out.println("Client registers: ");

        DataHandler dataHandler = new DataHandler();

        while (!Regis_Success) {
            //Receive user account
            username = in.readUTF();

            password = in.readUTF();

            confirm = in.readUTF();

            if (!password.equals(confirm)) {
                System.out.println("Registers unsuccessfully!");
                out.writeBoolean(Regis_Success);
            } else {
                Regis_Success = dataHandler.Register(username, password);
                System.out.println("User: " + username + " registers successfully! \n");
                out.writeBoolean(Regis_Success);
            }
        }

    }

    public void SignIn_Form() throws IOException, SQLException {
        //Receive 1: Login, 2: Register
        String op = "";
        do {
            op = in.readUTF();
            switch (op) {
                case "1":
                    Login();
                    break;
                default:
                    Register();
            }
        } while (!op.equals("1"));
    }

    public Boolean View() throws IOException {
        DataHandler dataHandler = new DataHandler();
        Boolean isFound = false;
        while (!isFound) {
            //Receive 1: View by ID, 2: by Name
            String option = in.readUTF();
            String Search_key = in.readUTF();

            try {
                Book found = new Book();

                isFound = dataHandler.find_Book(option, Search_key, found);

                out.writeBoolean(isFound);

                if (isFound) {
                    oos.writeObject(found);
                    found.display();
                }

            } catch (SQLException | IOException throwables) {
                throwables.printStackTrace();
                System.out.println("Error in View");
            }
        }
        return isFound;
    }

    public void Look_up() {
    }

    public void List_books() {
    }

    public void Download() {
    }

    public void Main_Menu() {

    }

    public void Menu() {
        try {
            SignIn_Form();
            View();
            //Main_Menu();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void run() {

        try {
            Menu();
            System.out.println("Close connection with client: " + socket);
            in.close();
            out.close();
            oos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
