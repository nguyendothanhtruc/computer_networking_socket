package Socket.Server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    final ServerSocket server;
    private final ExecutorService pool = Executors.newFixedThreadPool(3);
    private ArrayList<String> clients;
    private boolean Alive;

    //Establish a connection between server and clients
    public Server(String IP, int port) throws IOException {
        server = new ServerSocket(port, 1, InetAddress.getByName(IP));
        clients = new ArrayList<>();
        Alive = false;
    }

    public void setAlive(boolean alive) {
        Alive = alive;
    }

    public void Connect() throws IOException {
        System.out.println("[" + java.time.LocalDate.now() + " " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":" + LocalDateTime.now().getSecond()
                + "] Server started");
        System.out.println("Waiting for clients.... \n ");
        while (server.isBound() && !server.isClosed()) {
            Socket socket = null;
            try {
                socket = server.accept();

                System.out.println("[" + LocalDate.now() + " " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":" + LocalDateTime.now().getSecond()
                        + "] A new client connected : " + socket + "\n");

                // create a new thread object
                Services ClientHandler = new Services(socket, clients);

                //Add to pool thread
                pool.execute(ClientHandler);

            } catch (IOException e) {
                if (socket != null)
                    socket.close();
                if (!server.isClosed()) server.close();
                System.out.println("[" + LocalDate.now() + " " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":" + LocalDateTime.now().getSecond()
                        + "] Connection closed: " + socket);
                e.printStackTrace();
            }
        }
    }

    public void Run() {
        try {
            if (Alive)
                Connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
