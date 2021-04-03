package Socket.Client;

import Socket.Book;
import Socket.Client.GUI.*;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

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
                    System.out.println("ERROR flag");
            }

        } while (!command.equals("1"));

    }

    public void getBook(ObjectInputStream OIS) throws IOException, ClassNotFoundException {
        Book myBook = (Book) OIS.readObject();
        BookInfo bookInfo = new BookInfo(myBook);
        bookInfo.RunBI();
        //OIS.close();

        //Get menuOption
        flag = bookInfo.cmd;
        client.send(flag);
        bookName = myBook.name;
    }

    public void FindBook() throws IOException, ClassNotFoundException {
        SearchBook searchBook = new SearchBook(client.getSocket());
        searchBook.RunSB(client.getSocket());
        getBook(client.getOIS());
    }

    public void Menu() throws Exception {

        switch (flag) {
            case "1" -> ViewBook();
            case "2" -> Download();
            case "3" -> System.out.println("LookUp");
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
        new viewBook(bookName, "Books\\Client\\" + bookName + ".txt").RunvB();
    }

    private void Download() throws Exception {
        String filename = bookName;
        receiveFile("Books\\Client\\" + filename + ".txt");
        //THV ID=5
        new viewBook(bookName, "Books\\Client\\" + bookName + ".txt").RunvB();
    }

    public void Run() throws Exception {
        SignIn();
        FindBook();
        Menu();

    }
}
