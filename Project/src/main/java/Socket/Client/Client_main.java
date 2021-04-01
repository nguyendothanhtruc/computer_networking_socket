package Socket.Client;

import java.io.IOException;
import Socket.Client.Registration;

public class Client_main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client client = new Client("127.0.0.1", 9999);

        //First menu:
        String direction_flag = "";
        do {
            direction_flag = client.SignUpForm(); //LOOP UNTIL LOGIN SUCCESSFULLY
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
        } while (!direction_flag.equals("1"));

        //Forced menu: View book
        direction_flag = "1";
        client.ViewBook();
        //client.MainMenu();

        // client.Disconnect();
    }


}

