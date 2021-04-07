package Socket.Client;


import Socket.Client.GUI.IPAddress;

public class Client_main {
    public static void main(String[] args) throws Exception {
        Client client = null;
        //First GUI to get IP
        IPAddress getIP= new IPAddress();
        getIP.Run();

        //Create connection
        client = new Client(getIP.IP, 9999);
        getIP.dispose();

        //Run functions
        Client_Services services = new Client_Services(client);
        services.Run();
    }
}

