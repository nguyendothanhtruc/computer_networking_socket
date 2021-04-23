package Socket.Server;

import Socket.Book;
import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class DataHandler {
    SQLServerDataSource ds;

    String server_name;
    int port;

    public DataHandler() {
        try {
            String Port, username, password;

            FileInputStream fileInputStream = new FileInputStream("hostname.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            server_name = bufferedReader.readLine();
            Port = bufferedReader.readLine();
            port = Integer.parseInt(Port);
            username = bufferedReader.readLine();
            password = bufferedReader.readLine();

            ds = new SQLServerDataSource();
            ds.setUser(username);
            ds.setPassword(password);
            ds.setServerName(server_name);
            ds.setPortNumber(port);
            ds.setDatabaseName("Online_Library");

        } catch (FileNotFoundException e) {
            System.out.println("Error in hostname.txt");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Boolean isStandardized(String password) {
        boolean containChar = false, containDigit = false;
        if (password.length() < 6) return false;
        char[] pass = password.toCharArray();
        for (char c : pass)
            if (Character.isDigit(c)) containChar = true;
            else if (Character.isAlphabetic(c)) containDigit = true;
        return containChar && containDigit;
    }

    public Boolean checkPassword(String u, String p) {

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

    public Boolean Register(String u, String p) {

        try (Connection connection = ds.getConnection()) {

            if (!isStandardized(p)) {
                System.out.println("Password is invalid");
                return false;
            }
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

    public Boolean find_Book(String option, String Search_key, Book found) {

        try (Connection connection = ds.getConnection()) {
            String sql;
            PreparedStatement stmt;
            ResultSet rs;

            if (option.equals("1")) {
                sql = "SELECT * FROM book where id = ?";
                stmt = connection.prepareStatement(sql);
                int id = Integer.parseInt(Search_key);
                stmt.setInt(1, id);

            } else {
                sql = "SELECT * FROM book where name = ?";
                stmt = connection.prepareStatement(sql);
                stmt.setString(1, Search_key);
            }

            rs = stmt.executeQuery();
            if (!rs.next()) {
                System.out.println("[" + LocalDate.now() + " " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute() + ":" + LocalDateTime.now().getSecond()
                        + "] Book not found!");
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

    public Boolean List_Book(String option, String Search_key, ArrayList<Book> books) {

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

