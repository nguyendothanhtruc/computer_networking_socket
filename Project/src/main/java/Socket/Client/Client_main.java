package Socket.Client;


public class Client_main {
    public static void main(String[] args) throws Exception {
        Client client = null;
        client = new Client("127.0.0.1", 9999);
        Client_Services services = new Client_Services(client);
        services.Run();
    }
}

