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

    public void SignIn() {
        String command = "3";
        try {
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
        } catch (IOException e) {
            System.out.println("Close processing SignIn");
            client.Disconnect();
        }

    }

    public void getBook(ObjectInputStream OIS) {
        try {
            Book myBook = null;
            myBook = (Book) OIS.readObject();
            BookInfo bookInfo = new BookInfo(myBook);
            bookInfo.RunBI();

            //Store book data
            flag = bookInfo.cmd; //Function chosen
            client.send(flag);
            bookName = myBook.name;

        } catch (IOException e) {
            System.out.println(e.toString());
            System.out.println("SERVER DIED");
            client.Disconnect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void FindBook() {
        try {
            SearchBook searchBook = new SearchBook(client.getSocket());
            searchBook.RunSB(client.getSocket());
            getBook(client.getOIS());
        } catch (IOException io) {
            System.out.println(io.toString());
            System.out.println("Close processing FindBook");
            client.Disconnect();
        }
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
        SignIn();
        FindBook();
        Menu();
    }
}
