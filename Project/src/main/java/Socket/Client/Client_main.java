package Socket.Client;

import Socket.Client.GUI.FirstMenu;
import Socket.Client.GUI.Login;
import Socket.Client.GUI.Registration;
import Socket.Client.GUI.SearchBook;

import java.io.DataInputStream;
import java.io.IOException;

public class Client_main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client client = new Client("127.0.0.1", 9999);

        //Tao co dieu huong
        String direction_flag = "3";
        DataInputStream input = client.getInput();

        do {
            //Chay Menu: Login-Regis
            FirstMenu firstMenu = new FirstMenu(client.getSocket());
            firstMenu.run(client.getSocket());
            //Nhan gia tri 1-2
            direction_flag = input.readUTF();

            switch (direction_flag) {
                case "1": {
                    Login login = new Login(client.getSocket());
                    login.RunLogin(client.getSocket());
                    break;
                }
                case "2": {
                    Registration registration = new Registration(client.getSocket());
                    registration.RunReg(client.getSocket());
                    break;
                }
                default:
                    System.out.println("ERROR flag");
            }

        } while (!direction_flag.equals("1"));

        SearchBook searchBook=new SearchBook(client.getSocket());
        searchBook.RunSB(client.getSocket());
        client.getBook();
        //client.Disconnect();

    }

}

