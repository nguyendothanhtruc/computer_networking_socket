package Socket.Server;

import Socket.Book;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Services extends Thread {
    final DataInputStream in; //Take message from client
    final DataOutputStream out; //Print on client terminal
    final ObjectOutputStream oos;
    private String username;
    private List<String> Clients;
    final Socket socket;

    // Constructor
    public Services(Socket s, List<String> c) throws IOException {
        socket = s;
        Clients = c;

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

            if (!Clients.contains(username)) isCorrected = dataHandler.checkPassword(username, password);

            out.writeBoolean(isCorrected);
        }
        System.out.println("User: " + username + " logins successfully! \n");
        Clients.add(username);
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
                out.writeBoolean(false);

            } else {
                Regis_Success = dataHandler.Register(username, password);
                out.writeBoolean(Regis_Success); //Gui ve ham regis cua client xu ly
                if (Regis_Success) System.out.println("User: " + username + " registers successfully! \n");
                else System.out.println("Failed to register");
            }
        }

    }

    public void SignIn_Form() throws IOException, SQLException {
        //Receive 1: Login, 2: Register
        String op;
        do {
            op = in.readUTF();
            out.writeUTF(op);
            if (op.equals("1"))
                Login();
            else
                Register();

        } while (!op.equals("1"));
    }

    public void Look_up() throws IOException {
        DataHandler dataHandler = new DataHandler();
        Boolean isFound = false;
        System.out.println("User: " + username + " looks up books");
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

            } catch (SQLException | IOException throwable) {
                throwable.printStackTrace();
                System.out.println("Error in Look-up");
            }
        }
    }

    public void View() {
    }

    public void List_books() {
        System.out.println("User: " + username + " lists books");

        String option, search_key;
        DataHandler dataHandler = new DataHandler();

        try {
            List<Book> books = new ArrayList<Book>();
            Boolean Success = false;

            while (!Success) {
                option = in.readUTF();
                search_key = in.readUTF();
                //option = "1";
                //search_key = "Computer Science";

                Success = dataHandler.List_Book(option, search_key, books);

                out.writeBoolean(Success);

                if (Success) {
                    oos.writeObject(books);
                    System.out.println("There are " + books.size() + " books found");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error in List_books");
        }

    }

    public void Download() {
    }

    public void Main_Menu() throws IOException {
        String option = in.readUTF();
        //String option = "3";

        switch (option) {
            case "1":
                View();
                break;
            case "2":
                Download();
                break;
            default:
                List_books();
        }
    }

    public void Menu() {
        try {
            SignIn_Form();
            Look_up();
            Main_Menu();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
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
