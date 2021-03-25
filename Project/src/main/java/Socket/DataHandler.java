package Socket;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.*;

public class DataHandler
{
    private SQLServerDataSource ds;
    private Connection connection;
    public DataHandler(String user, String password, String server_name, int port)
    {
        ds = new SQLServerDataSource();
        ds.setUser(user);
        ds.setPassword(password);
        ds.setServerName(server_name);
        ds.setPortNumber(port);
        ds.setDatabaseName("Online_Library");
    }
    public Boolean checkPassword(String u, String p) throws SQLException {
        connection = ds.getConnection();
        //Statement st = connection.createStatement();
        PreparedStatement preparedStatement= connection.prepareStatement("Select password from account where username = ?");
        preparedStatement.setString(1,u);
        ResultSet rs = preparedStatement.executeQuery();
        rs.next();
        if (rs.getString("password") == p )
        {
            System.out.println("true");
            return true;
        }
        return false;
    }
}
