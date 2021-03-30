package Socket.Server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Server {
    private ServerSocket server = null;
    private Socket socket = null;
    private DataHandler dataHandler;

    //Establish a connection between server and clients
    public Server(int port) throws IOException {
        server = new ServerSocket(port, 1, InetAddress.getByName("localhost"));
        System.out.println("Server started");
        System.out.println("Waiting for clients.... \n ");
    }

    public void Connect() throws IOException
    {

        while (true)
        {
            socket = null;
            try {
                socket = server.accept();

                System.out.println("A new client is connected : " + socket);

                System.out.println("Assigning new thread for this client \n");

                // create a new thread object
                Services ClientHandler = new Services(socket);

                // Invoking the start() method
                ClientHandler.start();

            } catch (IOException e) {
                socket.close();
                System.out.println("Connection closed: " + socket);
                e.printStackTrace();
            }
        }
    }
}
