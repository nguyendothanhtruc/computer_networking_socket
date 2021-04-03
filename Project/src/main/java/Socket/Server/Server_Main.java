package Socket.Server;

import Socket.Server.GUI.ServerGUI;

import java.io.IOException;

public class Server_Main
{
    public static void main(String[] args) throws IOException, InterruptedException {
        //Set up database
        Server server = new Server(9999);

        ServerGUI sGUI=new ServerGUI(server);
        sGUI.Run();
        server.run();
    }
}
