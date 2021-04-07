package Socket.Client;

import Socket.Book;
import Socket.Client.GUI.*;

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
    private String bookName; //Current book executing

    Client_Services(Client client) {
        this.client = client;
        input = client.getInput();
    }

    public void SignIn() throws IOException {
        String command = "3";

        do {
            new FirstMenu(client.getSocket()).run();
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

    public void getBook(ObjectInputStream OIS) throws IOException, ClassNotFoundException, InterruptedException {
        Book myBook = null;
        myBook = (Book) OIS.readObject();
        BookInfo bookInfo = new BookInfo(myBook);
        bookInfo.RunBI();

        //Store book data
        flag = bookInfo.cmd; //Function chosen
        client.send(flag);

        //Send sort category

        if (flag.equals("3")) {
            OptionPanel clientOp = new OptionPanel();
            clientOp.RunOp();

            String category = "";
            category = clientOp.genre;
            System.out.println(category);
            client.send(category);

            if (category.equals("1")) client.send(myBook.type);
            else client.send(myBook.author);
            clientOp.dispose();
        }
        bookName = myBook.name;
    }

    public void FindBook() throws InterruptedException, IOException, ClassNotFoundException {

        SearchBook searchBook = new SearchBook(client.getSocket());
        searchBook.RunSB(client.getSocket());
        getBook(client.getOIS());

    }

    public void MoreBook(ObjectInputStream OIS) throws IOException, InterruptedException, ClassNotFoundException {
        ArrayList<Book> bookArrayList = null;

        boolean getList = input.readBoolean();

        if (getList) {
            bookArrayList = (ArrayList<Book>) OIS.readObject();
        }
        new findMoreBooks(client.getSocket(), bookArrayList).Run();
    }

    public void Menu() throws Exception {
        switch (flag) {
            case "1" -> ViewBook();
            case "2" -> Download();
            case "3" -> MoreBook(client.getOIS());
        }
    }

    private void receiveFile(String fileName) throws Exception {
        int bytes = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        long size = input.readLong();     // read file size
        System.out.println(size);

        byte[] buffer = new byte[4 * 1024];
        while (size > 0 && (bytes = input.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
            fileOutputStream.write(buffer, 0, bytes);
            size -= bytes;      // read upto file size
        }
        fileOutputStream.close();
    }

    private void ViewBook() throws Exception {
        String filename = bookName;
        receiveFile("Books\\Client\\" + filename + ".txt");
        //THV ID=5
        new viewBook(bookName, "Books\\Client\\" + bookName + ".txt").RunViewBook();
    }

    private void Download() throws Exception {
        String filename = bookName;
        receiveFile("Books\\Client\\" + filename + ".txt");
        JOptionPane.showMessageDialog(null, "Download successfully");
    }

    public void Run() throws Exception {
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
