package Socket;

import java.io.IOException;
import java.sql.SQLException;

public class Server_Main
{
    public static void main(String[] args) throws IOException, SQLException {
        //Set up database
        Server server = new Server(9999);
        server.login_User();
    }
}