package Socket.Server;

import java.io.IOException;

public class Server_Main
{
    public static void main(String[] args) throws IOException {
        //Set up database
        Server server = new Server(9999);

        server.Connect();
    }
}
