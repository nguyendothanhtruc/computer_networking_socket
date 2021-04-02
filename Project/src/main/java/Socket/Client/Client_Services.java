package Socket.Client;

import Socket.Client.Client;
import Socket.Client.GUI.FirstMenu;
import Socket.Client.GUI.Login;
import Socket.Client.GUI.Registration;

import java.io.DataInputStream;
import java.io.IOException;


public class Client_Services {
    private Client client;

    Client_Services(Client client){
        this.client=client;
    }

    public void SignIn() throws IOException {
        String command = "3";
        DataInputStream input = client.getInput();

        do {
            FirstMenu firstMenu = new FirstMenu(client.getSocket());
            firstMenu.run(client.getSocket());

            command = input.readUTF();

            switch (command) {
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

        } while (!command.equals("1"));

    }
    public void Run() throws IOException {
        SignIn();

    }
}
