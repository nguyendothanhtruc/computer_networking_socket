package Socket.Server;

public class Account
{
    private String username;
    private String password;
    public Account(String u, String p)
    {
        username = u;
        password = p;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
