package Socket.Server;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.*;

public class DataHandler {
    private SQLServerDataSource ds;
    private Connection connection;
    //private String server_name = "DESKTOP-IJHRRIK\\SQLEXPRESS";
    private String server_name = "MSI";
    //private int port = 1433;
    private int port = 1432;
    public DataHandler() {
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName(server_name);
        ds.setPortNumber(port);
        ds.setDatabaseName("Online_Library");
    }

    public Boolean checkPassword(String u, String p) throws SQLException {
        connection = ds.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("Select password from account where username = ?");
        preparedStatement.setString(1, u);

        ResultSet rs = preparedStatement.executeQuery();

        String pass = "";

        if (!rs.next()) return false;
        else pass = rs.getString("password");
        if (pass.equals(p)) return true;
        return false;
    }
}
