package Socket.Client;

import Socket.Book;
import Socket.Client.Client;
import Socket.Client.GUI.*;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Client_Services {
    private Client client;

    Client_Services(Client client) {
        this.client = client;
    }

    public void SignIn() throws IOException {
        String command = "3";
        DataInputStream input = client.getInput();

        do {
            FirstMenu firstMenu = new FirstMenu(client.getSocket());
            firstMenu.run(client.getSocket());

            command = input.readUTF();

            switch (command) {
                case "1": {
                    Login login = new Login(client.getSocket());
                    login.RunLogin(client.getSocket());
                    break;
                }
                case "2": {
                    Registration registration = new Registration(client.getSocket());
                    registration.RunReg(client.getSocket());
                    break;
                }
                default:
                    System.out.println("ERROR flag");
            }

        } while (!command.equals("1"));

    }

    public void getBook(ObjectInputStream OIS) throws IOException, ClassNotFoundException {
        Book myBook = (Book) OIS.readObject();
        BookInfo bookInfo = new BookInfo(myBook);
        bookInfo.RunBI();
        OIS.close();
    }

    public void FindBook() throws IOException, ClassNotFoundException {
        SearchBook searchBook = new SearchBook(client.getSocket());
        searchBook.RunSB(client.getSocket());
        getBook(client.getOIS());
    }

    public void Run() throws IOException, ClassNotFoundException {
        SignIn();
        FindBook();

    }
}
