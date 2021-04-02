package Socket.Server;

import Socket.Server.GUI.Server_GUI;

import java.io.IOException;

public class Server_Main
{
    public static void main(String[] args) throws IOException {
        //Set up database
        Server server = new Server(9999);
        Server_GUI server_gui = new Server_GUI(server);
        server_gui.Run();
    }
}
