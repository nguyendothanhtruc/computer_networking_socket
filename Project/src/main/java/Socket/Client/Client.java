package Socket.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client
{
    // initialize socket and input output streams
    private Socket socket            = null;
    private DataInputStream input   = null;
    private DataOutputStream output     = null;

    // constructor to put ip address and port
    Client(String address, int port)
    {
        // establish a connection
        try
        {
            socket = new Socket(address, port);
            System.out.println("Connected");
            // takes messages from server
            input = new DataInputStream(socket.getInputStream());
            // sends output to the socket
            output    = new DataOutputStream(socket.getOutputStream());


            // string to read message from input
            String line ="";
            // takes input from terminal
            Scanner in  = new Scanner(System.in);
            // keep reading until "Exit" is input
            boolean LoginSuccess = false;
            while (!LoginSuccess)
            {
                try
                {
                    System.out.println("Login: ");
                    System.out.println("Username: ");
                    line = in.nextLine();
                    output.writeUTF(line);

                    System.out.println("Password: ");
                    line = in.nextLine();
                    output.writeUTF(line);

                    LoginSuccess = input.readBoolean();
                    if(LoginSuccess) {
                        System.out.println(input.readUTF());
                        break;
                    }
                    else System.out.println("Failed to login you noob");
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }

            }
            // close the connection
            try
            {
                input.close();
                output.close();
                socket.close();
                System.out.println("Connection closed");
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
            finally {
                 in.close();

            }
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

    }
    public void List_books() throws IOException {
        System.out.println("LIST BOOKS MENU \n 1. By Type \n 2. By Author \n Option:" );
        String op = "";
        Boolean stop = false;
        while(!stop)
        {
            Scanner in  = new Scanner(System.in);
            op = in.next();
            switch(op)
            {
                case "1":
                    stop = true;
                    break;
                case "2":
                    stop = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    System.out.println("Re-enter option: ");
            }
        }
    }
    public void Look_up() throws IOException {
        System.out.println("LOOK UP MENU \n 1. By ID \n 2. By Name \n Option:" );
        String op = "";
        Boolean stop = false;
        while(!stop)
        {
            Scanner in  = new Scanner(System.in);
            op = in.nextLine();

            switch(op)
            {
                case "1":
                    stop = true;
                    break;
                case "2":
                    stop = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    System.out.println("Re-enter option: ");
            }
        }

    }
    public void menu() throws IOException {

        System.out.println("Menu options: \n 1. View book \n 2. Download \n 3. List books \n Option: ");
        Boolean stop = false;
        String op = "";
        while(!stop)
        {
            Scanner in = new Scanner(System.in);
            op = in.nextLine(); //Read input from client
            switch (op)
            {
                /*case "1": service.View();
                    stop = true;
                    break;
                case "2": service.Download();
                    stop = true;
                    break;
                case "3": service.List_books();
                    stop = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    System.out.println("Re-enter option: ");*/
            }
        }
    }
    public static void main(String args[])
    {
        Client client = new Client("127.0.0.1", 9999);
    }
}

