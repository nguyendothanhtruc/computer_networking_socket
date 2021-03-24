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

    public void login_User() throws IOException
    {
        socket = server.accept(); //Return a socket connecting to socket of clients
        System.out.println("A client connected");
        //Take input from client:
        input = new DataInputStream(socket.getInputStream());
        output = new DataOutputStream(socket.getOutputStream());
        Services service = new Services(socket, input, output);
        service.Login();
        output.writeUTF("Login successfully! + \n");

        //Move to menu
        menu(service);


        disconnect();

        /*String options = "";
        while (!options.equals("Exit"))
        {
            options = input.readUTF();
            System.out.println(options);
        }
*/
    }
    public void menu(Services service) throws IOException {
        service.Look_up();
        output.writeUTF("Menu options: + \n 1. View book \n 2. Download \n 3. List books \n Option: ");
        Boolean stop = false;
        String op = "";
        while(!stop)
        {
            op = input.readUTF(); //Read input from client
            switch (op)
            {
                case "1": service.View();
                    stop = true;
                    break;
                case "2": service.Download();
                    stop = true;
                    break;
                case "3": service.List_books();
                    stop = true;
                    break;
                default: output.writeUTF("Invalid option!");
                    output.writeUTF("Re-enter option: ");
            }
        }


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
        server.login_User();
    }
}
