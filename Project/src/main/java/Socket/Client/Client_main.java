package Socket.Client;

import java.io.DataInputStream;
import java.io.IOException;
import Socket.Client.Registration;

public class Client_main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client client = new Client("127.0.0.1", 9999);

        DataInputStream input= client.getInput();

        //First menu:

        String direction_flag=null;

        do{
            FirstMenu firstMenu= new FirstMenu(client.getSocket(),client.getOutput());
            FirstMenu.FirstMenu_Run(client.getSocket(),client.getOutput());
            boolean StepOver=input.readBoolean();
            direction_flag= firstMenu.choose;
            System.out.println(direction_flag);

            switch (direction_flag) {
                case "1": {
                    client.Login();
                    break;
                }
                case "2": {
                    Registration registration= new Registration(client.getSocket());
                    registration.Regist_run(client.getSocket());
                }
            }

        }  while(direction_flag!="1");

        //Forced menu: View book

        //client.ViewBook();
        //client.MainMenu();

        // client.Disconnect();
    }


}

