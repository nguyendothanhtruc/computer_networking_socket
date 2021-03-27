package Socket.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.SyncFailedException;
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

    //First menu: 1-2 Regis/Login
    public String SignUpForm() throws IOException {
        System.out.println("SIGN IN FORM");
        System.out.println("1. Login");
        System.out.println("2. Register");

        Scanner in = new Scanner(System.in);
        String Option = "";
        boolean isFound = false;

        try {
            while (!isFound) {
                Option = in.nextLine();
                switch (Option) {
                    case "1":
                    case "2":
                        isFound = true;
                        break;
                    default:
                        System.out.println("Invalid option!");
                        System.out.println("Re-enter option: ");
                }
            }
            output.writeUTF(Option); //Send the search-option to server

        } catch (IOException e) {
            e.printStackTrace();
        }

        return Option;
    }

    //Login into the system - send user/pass to server
    public void Login() {

        //String to read from server
        String line = "";
        Scanner in = new Scanner(System.in);

        //Try to login until LoginSuccess
        boolean LoginSuccess = false;
        while (!LoginSuccess) {
            try {
                System.out.println("LOGIN");
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
       // in.close(); //Closer scanner
    }

    //Create new account - send user/pass/confirm to server
    public void Register() {
        //String to read from server
        String line = "";
        Scanner in = new Scanner(System.in);

        //Try to regis until RegisSuccess
        boolean RegisSuccess = false;
        while (!RegisSuccess) {
            try {
                System.out.println("REGISTER");
                System.out.println("Username: ");
                line = in.nextLine();
                output.writeUTF(line); //Send username

                System.out.println("Password: ");
                line = in.nextLine();
                output.writeUTF(line); //Send password

                System.out.println("Confirm password: ");
                line = in.nextLine();
                output.writeUTF(line); //Send re-password

                RegisSuccess = input.readBoolean(); //Receive login_flag from sv
                //Check if Login_success
                if (RegisSuccess) System.out.println("Register successfully! \n");
                else System.out.println("Failed to register you noob");

            } catch (IOException i) {
                System.out.println(i);
            }
        }
    }

    public void ViewBook() throws IOException {
        System.out.println("VIEW BOOK");

        String book_name="";
        Scanner in=new Scanner(System.in);

        book_name=in.nextLine();
        book_name=Searching_Type("F_ID","F_Name",book_name);


    }
    //Returns type of book-searching: 1-Search by type1; 2-Search by type2 to server
    public String Searching_Type(String type1, String type2, String input) throws IOException {
        //SYNTAX: TYPE1=F_ID; TYPE2=F_Name OR TYPE1=TYPE; TYPE2=AUTHOR

        //Presentation
        String header;

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

