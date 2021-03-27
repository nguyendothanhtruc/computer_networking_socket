package Socket.Client;

import java.io.IOException;

public class Client_main {
    public static void main(String[] args) throws IOException {
        Client client = new Client("127.0.0.1", 9999);
        client.Login();
    }
}

