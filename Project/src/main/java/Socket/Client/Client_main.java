package Socket.Client;

import java.io.IOException;

public class Client_main {
    public static void main(String[] args) throws IOException {
        Client client = new Client("127.0.0.1", 9999);

        //First menu:
        String direction_flag = "";
        do {
            direction_flag = client.SignUpForm(); //LOOP UNTIL LOGIN SUCCESSFULLY
            switch (direction_flag) {
                case "1": {
                    client.Login();
                }
                case "2": {
                    client.Register();
                }
            }
        } while (!direction_flag.equals("1"));
        //Forced menu: View book
        direction_flag = "1";


        client.Disconnect();
    }
}

