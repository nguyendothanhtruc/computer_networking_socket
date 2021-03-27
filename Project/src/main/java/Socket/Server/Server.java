package Socket.Server;

import Socket.Server.DataHandler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Server {
    private ServerSocket server = null;
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;
    private DataHandler dataHandler;

    //Establish a connection between server and clients
    public Server(int port) throws IOException {
        server = new ServerSocket(port,1, InetAddress.getByName("localhost"));
        System.out.println("Server started");
        System.out.println("Waiting for clients....");

        socket = server.accept(); //Return a socket connecting to socket of clients
        System.out.println("A client connected");

        //Take input from client:
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
    }

    public void SignIn_Form() throws IOException, SQLException {
        Services service = new Services(socket, input, output);

        //Receive 1: Login, 2: Register
        String op = "";
        do
        {
            op = input.readUTF();
            switch(op)
            {
                case "1": service.Login();
                    break;
                default: service.Register();
            }
        } while (!op.equals("1"));
    }

    public void Disconnect() throws IOException {
        input.close();
        output.close();
        socket.close();
        System.out.println("Connection closed: " + socket);
    }

}
