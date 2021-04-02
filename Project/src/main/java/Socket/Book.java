package Socket;

import java.io.Serializable;

public class Book implements Serializable
{
    public int ID;
    public String name;
    public String author;
    public int year;
    public String type;
    public Book(int id, String n, String a, int y, String t)
    {
        ID = id;
        name = n;
        author = a;
        year = y;
        type = t;
    }
    public Book()
    {}
    public void change(int id, String n, String a, int y, String t)
    {
        ID = id;
        name = n;
        author = a;
        year = y;
        type = t;
    }
}
