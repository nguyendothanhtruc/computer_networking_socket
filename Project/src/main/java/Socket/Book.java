package Socket;


import java.io.Serializable;

public class Book implements Serializable
{
    private int ID;
    private String name;
    private String author;
    private int year;
    private String type;
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
    public void display()
    {
        System.out.println(ID + " " + name + " " + author);
    }

}
