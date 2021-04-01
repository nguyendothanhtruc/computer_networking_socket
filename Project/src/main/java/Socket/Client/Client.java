package Socket.Client;


import Socket.Book;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    // initialize socket and input output streams
    private Socket socket = null;

    public Socket getSocket() {
        return socket;
    }

    public DataInputStream getInput() {
        return input;
    }
    public DataOutputStream getOutput() {
        return output;
    }

    private DataInputStream input = null;
    private DataOutputStream output = null;
    private ObjectInputStream objectInputStream = null;

    // constructor to put ip address and port
    Client(String address, int port) throws IOException {
        // establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");
            // Successfully connected

            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            //Init IO stream

        } catch (UnknownHostException u) {
            System.out.println(u);

        } catch (IOException i) {
            System.out.println(i);
        }
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

    //Input a line to view a book by name/id
    public void ViewBook() throws IOException, ClassNotFoundException {

        Boolean isFound = false;
        while (!isFound) {
            System.out.println("VIEW BOOK");

            String Book_name = "";

            Book_name = Searching_Type("F_ID", "F_Name");
            output.writeUTF(Book_name);
            isFound = input.readBoolean();

            if (isFound) {
                Book myBook = (Book) objectInputStream.readObject();
                myBook.display();
                objectInputStream.close();
            }
        }

        // List<Message> listOfMessages = (List<Message>) objectInputStream.readObject();
    }

    //Returns type of book-searching: 1-Search by type1; 2-Search by type2 to server
    public String Searching_Type(String type1, String type2) throws IOException {
        //SYNTAX: TYPE1=F_ID; TYPE2=F_Name OR TYPE1=Type; TYPE2=Author

        //Input the data to search
        String GetDataString;
        Scanner in = new Scanner(System.in);

        //F_X part, Name part
        String BookHeader, BookContent = null;

        String direction_flag = ""; //Get_type
        Boolean isFound = false; //Stop-flag

        //Loop until type of searching is found
        while (!isFound) {
            GetDataString = in.nextLine();

            int pos = GetDataString.indexOf(" ");
            BookHeader = GetDataString.substring(0, pos); //Get the F_X part

            BookContent = GetDataString.substring(pos + 1, GetDataString.length()); //Get the name/ID part

           /*TEST SPLIT
            System.out.println("H:" +BookHeader);
            System.out.println("S:" +BookContent);
            System.out.println("Str: "+GetDataString.length()); */

            if (BookHeader.equals(type1)) direction_flag = "1";
            else if (BookHeader.equals(type2)) direction_flag = "2";
            else direction_flag = "3";

            switch (direction_flag) {
                case "1":
                case "2":
                    isFound = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    System.out.println("Re-enter option: ");
            }
        }

        output.writeUTF(direction_flag); //Send the search-option to server

        return BookContent;
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

