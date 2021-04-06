package Socket.Client;


public class Client_main {
    public static void main(String[] args) {
        Client client = null;
        try {
            client = new Client("127.0.0.1", 9999);
            Client_Services services = new Client_Services(client);
            services.Run();
        } catch (Exception e) {
            System.out.println("SERVER DISCONNECTED");
            client.Disconnect();
        }
    }
}

