package Socket;

import javax.security.auth.login.LoginContext;
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
            while (!line.equals("Exit"))
            {
                try
                {
                    System.out.println(input.readUTF()); //Login
                    System.out.println(input.readUTF()); //Username
                    line = in.nextLine();
                    output.writeUTF(line);
                    System.out.println(input.readUTF()); //Password
                    line = in.nextLine();
                    output.writeUTF(line);
                    line = in.nextLine(); //Enter to continue
                    boolean LoginSuccess=input.readBoolean();
                    if(LoginSuccess) System.out.println("OK");
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

    public static void main(String args[])
    {
        Client client = new Client("127.0.0.1", 9999);
    }
}

