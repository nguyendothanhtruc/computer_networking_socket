package Socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
    private ServerSocket server = null;
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    //Establish a connection between server and clients
    public Server(int port) throws IOException {
        server = new ServerSocket(port,1, InetAddress.getByName("localhost"));
        System.out.println("Server started");
        System.out.println("Waiting for clients....");
    }

    public void actions() throws IOException
    {
        socket = server.accept(); //Return a socket connecting to socket of clients
        System.out.println("A client connected");
        //Take input from client:
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
        Services service = new Services(socket, input, output);
        service.Login();
        disconnect();

        /*String options = "";
        while (!options.equals("Exit"))
        {
            options = input.readUTF();
            System.out.println(options);
        }
*/
    }
    public void disconnect() throws IOException {
        input.close();
        output.close();
        socket.close();
        System.out.println("Connection closed: " + socket);
    }
    public static void main(String[] args) throws IOException
    {
        Server server = new Server(9999);
        server.actions();
    }
}
