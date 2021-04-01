package Socket.Server;

import Socket.Book;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.sun.net.httpserver.Authenticator;

import java.sql.*;
import java.util.List;

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

    public Boolean checkPassword(String u, String p) throws SQLException
    {
        Connection connection = ds.getConnection();

        try {
            String sql = "SELECT password FROM account WHERE username = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, u);

            ResultSet rs = preparedStatement.executeQuery();

            String pass = "";

            if (!rs.next()) //Account don't exist
                return false;
            else pass = rs.getString("password");

            if (pass.equals(p)) return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connection.close();
        }
        return false; //Wrong password
    }

    public Boolean Register(String u, String p) throws SQLException
    {
        Connection connection = ds.getConnection();

        PreparedStatement statement = null;
        try {
            String isExisted = "SELECT username FROM account where username = ?";
            statement = connection.prepareStatement(isExisted);
            statement.setString(1, u);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) //Username was used
            {
                System.out.println("Username was used!");
                return false;
            }
            String insert = "INSERT INTO account(username, password) VALUES (?,?)";
            statement = connection.prepareStatement(insert);
            statement.setString(1, u);
            statement.setString(2, p);
            statement.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            connection.close();
        }
        return true;
    }

    public Boolean find_Book(String option, String Search_key, Book found) throws SQLException
    {
        Connection connection = ds.getConnection();

        try
        {
            String sql = "";
            PreparedStatement pstmt = null;
            ResultSet rs = null;

            switch (option)
            {
                case "1":
                    System.out.println("by ID");
                    sql = "SELECT * FROM book where id = ?";
                    pstmt = connection.prepareStatement(sql);
                    int id = Integer.parseInt(Search_key);
                    pstmt.setInt(1, id);
                    break;
                default:
                    System.out.println("by Name");
                    sql = "SELECT * FROM book where name = ?";
                    pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1,Search_key);
            }

            rs = pstmt.executeQuery();
            if (!rs.next()) {
                System.out.println("Book not found!");
                return false; //Not found
            }
            else
            {
                int ID = rs.getInt("ID");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int year = rs.getInt("year");
                String type = rs.getString("type");
                found.change(ID, name, author, year, type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
        }
        return true;
    }

    public Boolean List_Book(String option, String Search_key, List<Book> books) {

        Boolean Success = false;
        try {
            Connection connection = ds.getConnection();
            String sql;

            switch (option) {
                case "1": //By Type
                    sql = "SELECT * FROM book WHERE type = ?";
                    break;
                default: //By Author
                    sql = "SELECT * FROM book WHERE author = ?";
            }

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Search_key);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                int ID = rs.getInt("ID");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int year = rs.getInt("year");
                String type = rs.getString("type");
                Book newBook = new Book(ID, name, author, year, type);
                books.add(newBook);
                Success = true;
            }

            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return Success;
    }
}

