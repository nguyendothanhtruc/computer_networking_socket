package Socket.Server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    final ServerSocket server;
    private List<String> clients;
    private final ExecutorService pool = Executors.newFixedThreadPool(3);

    public void setAlive(boolean alive) {
        Alive = alive;
    }

    private boolean Alive;

    //Establish a connection between server and clients
    public Server(int port) throws IOException {
        server = new ServerSocket(port, 1, InetAddress.getByName("localhost"));
        System.out.println("Server started");
        System.out.println("Waiting for clients.... \n ");

        clients = new ArrayList<>();
        Alive = false;
    }

    public void Connect() throws IOException {
        while (server.isBound() && !server.isClosed()) {
            Socket socket = null;
            try {
                socket = server.accept();

                System.out.println("A new client is connected : " + socket);

                System.out.println("Assigning new thread for this client \n");

                // create a new thread object
                Services ClientHandler = new Services(socket, clients);

                //Add to pool thread
                pool.execute(ClientHandler);

            } catch (IOException e) {
                if (socket != null)
                    socket.close();
                server.close();
                System.out.println("Connection closed: " + socket);
                e.printStackTrace();
            }
        }
        System.out.println("Dead");
    }
    public void run()
    {
        try {
            System.out.println(Alive);
            if(Alive)
            Connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void Disconnect()
    {
        if (!server.isClosed()) {
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }
}
