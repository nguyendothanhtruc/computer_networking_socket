package Socket.Server;

import Socket.Book;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DataHandler {
    final SQLServerDataSource ds;

  final String server_name = "DESKTOP-IJHRRIK\\SQLEXPRESS";
   int port = 1433;

    //final String server_name = "MSI";
    //final int port = 1432;

    public DataHandler() {
        ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("1");
        ds.setServerName(server_name);
        ds.setPortNumber(port);
        ds.setDatabaseName("Online_Library");
    }

    public Boolean checkPassword(String u, String p){

        try (Connection connection = ds.getConnection()) {
            String sql = "SELECT password FROM account WHERE username = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, u);

            ResultSet rs = preparedStatement.executeQuery();

            String pass;

            if (!rs.next()) //Account don't exist
                return false;
            else pass = rs.getString("password");

            if (pass.equals(p)) return true;

        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }
        return false; //Wrong password
    }

    public Boolean Register(String u, String p){

        try (Connection connection = ds.getConnection()) {
            PreparedStatement statement;
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

        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }
        return true;
    }

    public Boolean find_Book(String option, String Search_key, Book found) throws SQLException {

        try (Connection connection = ds.getConnection()) {
            String sql;
            PreparedStatement stmt;
            ResultSet rs;

            if (option.equals("1")) {

                System.out.println("by ID");
                sql = "SELECT * FROM book where id = ?";
                stmt = connection.prepareStatement(sql);
                int id = Integer.parseInt(Search_key);
                stmt.setInt(1, id);

            } else {
                System.out.println("by Name");
                sql = "SELECT * FROM book where name = ?";
                stmt = connection.prepareStatement(sql);
                stmt.setString(1, Search_key);
            }

            rs = stmt.executeQuery();
            if (!rs.next()) {
                System.out.println("Book not found!");
                return false; //Not found
            } else {
                int ID = rs.getInt("ID");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int year = rs.getInt("year");
                String type = rs.getString("type");
                found.change(ID, name, author, year, type);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Boolean List_Book(String option, String Search_key, List<Book> books) {

        boolean Success = false;
        try {
            Connection connection = ds.getConnection();
            String sql;

            if (option.equals("1"))
                sql = "SELECT * FROM book WHERE type = ?";
            else
                sql = "SELECT * FROM book WHERE author = ?";


            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Search_key);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
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
        } catch (SQLException troubles) {
            troubles.printStackTrace();
        }
        return Success;
    }
}

