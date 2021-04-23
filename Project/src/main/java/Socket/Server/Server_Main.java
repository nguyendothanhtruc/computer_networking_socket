package Socket.Server;

import Socket.Server.GUI.ServerGUI;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Server_Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        //Set up database
        FileInputStream fileInputStream = new FileInputStream("hostname.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

        String IP = "";

        for (int i = 0; i < 5; i++)
            IP = bufferedReader.readLine();

        Server server = new Server(IP, 9999);

        ServerGUI sGUI = new ServerGUI(server);

        sGUI.Run();
        server.Run();
    }
}
