package Socket.Server;

import Socket.Book;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;

public class Services extends Thread {
    final DataInputStream in; //Take message from client
    final DataOutputStream out; //Print on client terminal
    final ObjectOutputStream oos;
    private String username;
    private List<String> Clients;
    final Socket socket;
    private String bookName;
    // Constructor
    public Services(Socket s, List<String> c) throws IOException {
        socket = s;
        Clients = c;

        //Communicate with client:
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        oos = new ObjectOutputStream(out);
    }

    private void Login() throws IOException{
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

    private void Register() throws IOException{
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
                System.out.println("Failed to register");
                out.writeBoolean(false);

            } else {
                Regis_Success = dataHandler.Register(username, password);
                out.writeBoolean(Regis_Success); //Gui ve ham regis cua client xu ly
                if (Regis_Success) System.out.println("User: " + username + " registers successfully! \n");
                else System.out.println("Failed to register");
            }
        }

    }

    private void SignIn_Form() throws IOException, SQLException {
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

    private void Look_up() throws IOException {
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
                    bookName = found.name;
                }

            } catch (SQLException | IOException throwable) {
                throwable.printStackTrace();
                System.out.println("Error in Look-up");
            }
        }
    }

    private void View() throws IOException {
        int bytes;

        File file = new File("Books\\Server\\"+bookName+".txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        // send file size
        out.writeLong(file.length());
        System.out.println(file.length());

        // break file into chunks
        byte[] buffer = new byte[4*1024];

        while ((bytes=fileInputStream.read(buffer))!=-1){
            out.write(buffer,0,bytes);
            out.flush();
        }
        fileInputStream.close();
    }

    private void List_books() {
        System.out.println("List_book");
        /*System.out.println("User: " + username + " lists books");

        String option, search_key;
        DataHandler dataHandler = new DataHandler();

        try {
            List<Book> books = new ArrayList<>();
            Boolean Success = false;

            while (!Success) {
                option = in.readUTF();
                search_key = in.readUTF();

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
*/
    }

    private void Download() throws IOException {
        int bytes;

        File file = new File("Books\\Server\\"+bookName+".txt");
        FileInputStream fileInputStream = new FileInputStream(file);

        // send file size
        out.writeLong(file.length());
        System.out.println(file.length());

        // break file into chunks
        byte[] buffer = new byte[4*1024];

        while ((bytes=fileInputStream.read(buffer))!=-1){
            out.write(buffer,0,bytes);
            out.flush();
        }
        fileInputStream.close();
    }

    private void Main_Menu() throws IOException {
        String option = in.readUTF();

        switch (option) {
            case "1" -> View();
            case "2" -> Download();
            default -> List_books();
        }
    }

    private void Menu() {
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
