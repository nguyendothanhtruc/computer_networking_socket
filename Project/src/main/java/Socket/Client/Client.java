package Socket.Client;


import Socket.Book;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    // initialize socket and input output streams
    private Socket socket = null;

    public Socket getSocket() {
        return socket;
    }

    public DataInputStream getInput() {
        return input;
    }
    public DataOutputStream getOutput() {
        return output;
    }

    private DataInputStream input = null;
    private DataOutputStream output = null;
    private ObjectInputStream objectInputStream = null;

    Client(String address, int port) throws IOException {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());

        } catch (UnknownHostException u) {
            System.out.println(u);

        } catch (IOException i) {
            System.out.println(i);
        }
    }
    //Input a line to view a book by name/id
    public void getBook() throws IOException, ClassNotFoundException {

        Book myBook = (Book) objectInputStream.readObject();
        myBook.display();
        objectInputStream.close();
    }

    //Close client-connection
    public void Disconnect() {

        try {
            input.close();
            output.close();
            socket.close();
            System.out.println("Connection closed");
        } catch (
                IOException i) {
            System.out.println(i);
        }

    }


}

