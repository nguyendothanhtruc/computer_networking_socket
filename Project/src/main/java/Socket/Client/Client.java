package Socket.Client;


import Socket.Book;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    // initialize socket and input output streams
    private Socket socket = null;

    public Socket getSocket() {
        return socket;
    }
    public DataInputStream getInput() {
        return input;
    }
    public ObjectInputStream getOIS() {
        return OIS;
    }

    private DataInputStream input = null;
    private DataOutputStream output = null;
    private ObjectInputStream OIS = null;

    Client(String address, int port) throws IOException {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            OIS = new ObjectInputStream(socket.getInputStream());

        } catch (UnknownHostException u) {
            System.out.println(u);

        } catch (IOException i) {
            System.out.println(i);
        }
    }

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

