package Socket.Client;

import Socket.Book;
import Socket.Client.GUI.First_Book_2.BookInfo;
import Socket.Client.GUI.First_Book_2.SearchBook;
import Socket.Client.GUI.Menu_Book_3.OptionPanel;
import Socket.Client.GUI.Menu_Book_3.findMoreBooks;
import Socket.Client.GUI.Menu_Book_3.viewBook;
import Socket.Client.GUI.Sign_In_1.Login;
import Socket.Client.GUI.Sign_In_1.Option_Login_Register;
import Socket.Client.GUI.Sign_In_1.Registration;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Client_Services {
    //Socket
    private Client client;
    private DataInputStream input;
    //Handler var
    private String flag; //Option direction for menu
    private Book firstBook = null; //Current book executing

    //Constructor
    Client_Services(Client client) {
        this.client = client;
        input = client.getInput();
    }

    //Sign_In_1
    public void SignIn() throws IOException {
        String command;

        do {
            new Option_Login_Register(client.getSocket()).run();
            command = input.readUTF();

            switch (command) {
                case "1": {
                    new Login(client.getSocket()).RunLogin();
                    break;
                }
                case "2": {
                    new Registration(client.getSocket()).RunReg();
                    break;
                }
                default:
                    System.out.println("ERROR in SIGNIN flag");
            }
        } while (!command.equals("1"));

    }

    //First_Book_2
    public void FindBook() throws InterruptedException, IOException, ClassNotFoundException {

        SearchBook searchBook = new SearchBook(client.getSocket());
        searchBook.RunSB(client.getSocket());
        getBook(client.getOIS());

    }

    public void getBook(ObjectInputStream OIS) throws IOException, ClassNotFoundException {
        firstBook = (Book) OIS.readObject();
        BookInfo bookInfo = new BookInfo(firstBook);
        bookInfo.RunBI();

        //Send menu-option: 1-View 2-Download 3-FindMore
        flag = bookInfo.cmd;
        client.send(flag);
    }

    public void StoreBook() throws InterruptedException {
        //Send sort category
        OptionPanel clientOp = new OptionPanel();
        clientOp.RunOp();

        //genre: 1-Type 2-Author
        String category = "";
        category = clientOp.genre;
        client.send(category);

        if (category.equals("1")) client.send(firstBook.type);
        else client.send(firstBook.author);

        clientOp.dispose();
    }

    //Menu_Book_3
    public void Menu() throws Exception {

        switch (flag) {
            case "1" -> ViewBook();
            case "2" -> Download();
            case "3" -> {
                StoreBook();
                MoreBook(client.getOIS());
                firstBook = (Book) client.getOIS().readObject();
                ViewBook();
            }
        }
    }

    private void receiveFile(String fileName) throws Exception {
        int bytes = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        long size = input.readLong();     // read file size

        byte[] buffer = new byte[4 * 1024];
        while (size > 0 && (bytes = input.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
            fileOutputStream.write(buffer, 0, bytes);
            size -= bytes;      // read upto file size
        }
        fileOutputStream.close();
    } //Sub-func

    private void ViewBook() throws Exception {
        String filename = firstBook.name;
        receiveFile("Books\\Client\\" + filename + ".txt");
        new viewBook(firstBook.name, "Books\\Client\\" + firstBook.name + ".txt").RunViewBook();
    }

    private void Download() throws Exception {
        String filename = firstBook.name;
        receiveFile("Books\\Client\\" + filename + ".txt");
        JOptionPane.showMessageDialog(null, "Download successfully");
    }

    public void MoreBook(ObjectInputStream OIS) throws IOException, InterruptedException, ClassNotFoundException {
        ArrayList<Book> bookArrayList = null;
        boolean getList = input.readBoolean();
        if (getList) {
            bookArrayList = (ArrayList<Book>) OIS.readObject();
        }
        new findMoreBooks(client.getSocket(), bookArrayList).Run();
    }

    //Client_main
    public void Run() {
        try {
            SignIn();
            FindBook();
            Menu();
        } catch (Exception e) {
            System.out.println(e.toString());

        } finally {
            System.out.println("Disconnected");
            client.Disconnect();
        }
    }
}
