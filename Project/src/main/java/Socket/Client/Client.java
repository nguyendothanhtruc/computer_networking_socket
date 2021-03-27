package Socket.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    // initialize socket and input output streams
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    // constructor to put ip address and port
    Client(String address, int port) throws IOException {
        // establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            // Successfully connected

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            //Init IO stream

        } catch (UnknownHostException u) {
            System.out.println(u);

        } catch (IOException i) {
            System.out.println(i);
        }
    }

    //Login into the system - send user/pass to server
    void Login() {

        //String to read from server
        String line = "";
        Scanner in = new Scanner(System.in);

        //Try to login until LoginSuccess
        boolean LoginSuccess = false;
        while (!LoginSuccess) {
            try {
                System.out.println("Login: ");
                System.out.println("Username: ");
                line = in.nextLine();
                output.writeUTF(line); //Send username

                System.out.println("Password: ");
                line = in.nextLine();
                output.writeUTF(line); //Send password

                LoginSuccess = input.readBoolean(); //Receive login_flag from sv
                //Check if Login_success
                if (LoginSuccess) System.out.println("Login successfully! \n");
                else System.out.println("Failed to login you noob");

            } catch (IOException i) {
                System.out.println(i);
            }
        }
        in.close(); //Closer scanner
    }

    public void menu() throws IOException {
        //List_book=Tra cuu them
        System.out.println("Menu options: \n 1. View book \n 2. Download \n 3. List books \n Option: ");
        Boolean stop = false;
        String op = "";
        while (!stop) {
            Scanner in = new Scanner(System.in);
            op = in.nextLine(); //Read input from client
            switch (op) {
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

    //Returns type of book-searching: 1-Search by type1; 2-Search by type2 to server
    public String Searching_Type(String Menu,String type1, String type2) throws IOException {
        //SYNTAX: TYPE1=ID; TYPE2=NAME OR TYPE1=TYPE; TYPE2=AUTHOR OR TYPE1=LOGIN; TYPE2=REGISTER

        //Presentation
        String temp;
        temp=Menu;
        System.out.println(Menu);
        temp = "1. " + type1;
        System.out.println(temp);

        temp = "2. " + type2;
        System.out.println(temp);

        String Option = ""; //Buffer-holder
        Boolean isFound = false; //Stop-flag
        Scanner in = new Scanner(System.in); //IO scanner

        //Loop until type of searching is found
        while (!isFound) {
            Option = in.next();
            switch (Option) {
                case "1":
                    isFound = true;
                    break;
                case "2":
                    isFound = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    System.out.println("Re-enter option: ");
            }
        }
        in.close();
        output.writeUTF(Option); //Send the search-option to server
        return Option;
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

