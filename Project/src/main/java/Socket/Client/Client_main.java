package Socket.Client;

import Socket.Client.GUI.SearchBook;

import java.io.IOException;

public class Client_main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Client client = new Client("127.0.0.1", 9999);

        Client_Services services = new Client_Services(client);
        services.Run();
        SearchBook searchBook=new SearchBook(client.getSocket());
        searchBook.RunSB(client.getSocket());
        client.getBook();
        client.Disconnect();

    }

}

