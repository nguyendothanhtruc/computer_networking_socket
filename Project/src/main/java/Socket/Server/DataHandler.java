package Socket.Server;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

import java.sql.*;

public class DataHandler {
    private SQLServerDataSource ds;

    private String server_name = "DESKTOP-IJHRRIK\\SQLEXPRESS";
    private int port = 1433;

    //private String server_name = "MSI";
    //private int port = 1432;

    public DataHandler() {
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName(server_name);
        ds.setPortNumber(port);
        ds.setDatabaseName("Online_Library");
    }

    public Boolean checkPassword(String u, String p) throws SQLException {
        Connection connection = ds.getConnection();

        String sql = "SELECT password FROM account WHERE username = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, u);

        ResultSet rs = preparedStatement.executeQuery();

        String pass = "";

        if (!rs.next()) //Account don't exist
        {
            connection.close();
            return false;
        }
        else pass = rs.getString("password");

        if (pass.equals(p))
        {
            connection.close();
            return true;
        }
        connection.close(); //Wrong password
        return false;
    }

    public Boolean Register(String u, String p) throws SQLException {
        Connection connection = ds.getConnection();

        PreparedStatement statement = null;

        String isExisted = "SELECT username FROM account where username = ?";
        statement = connection.prepareStatement(isExisted);
        statement.setString(1,u);

        ResultSet rs = statement.executeQuery();

        if (rs.next()) //Username was used
        {
            connection.close();
            return false;
        }

        String insert = "INSERT INTO account(username, password) VALUES (?,?)";
        statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,u);
        statement.setString(2,p);

        int rowAffected = statement.executeUpdate();
        System.out.println(rowAffected);
        connection.close();
        return true;
    }
}
