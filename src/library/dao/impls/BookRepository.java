package library.dao.impls;

import library.dao.interfaces.IBookRepository;
import library.entities.Book;
import library.helper.Connector;

import java.sql.ResultSet;
import java.util.ArrayList;

public class BookRepository implements IBookRepository {
    @Override
    public ArrayList<Book> all() {
        ArrayList<Book> ls = new ArrayList<>();
        try {
            String sql_txt = "select * from books";
            Connector conn = Connector.getInstance();
            ResultSet rs = conn.query(sql_txt);
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int qty = rs.getInt("qty");
                Book b = new Book(id,name,author,qty);
                ls.add(b);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return ls;
    }

    @Override
    public boolean create(Book book) {
        try {
            String sql_txt = "insert into books(name,author,qty) values(?,?,?)";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(book.getName());
            arr.add(book.getAuthor());
            arr.add(book.getQty());
            if(conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){
        }
        return false;
    }

    @Override
    public boolean update(Book book) {
        try {
            String sql_txt = "update books set name=?, author=?,qty=? where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(book.getName());
            arr.add(book.getAuthor());
            arr.add(book.getQty());
            arr.add(book.getId());
            if(conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public boolean delete(Book book) {
        try {
            String sql_txt = "delete from books where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(book.getId());
            if(conn.execute(sql_txt,arr)){
                return true;
            }
        }catch (Exception e){
        }

        return false;
    }

    @Override
    public Book findOne(Integer id) {
        try {
            String sql_txt = "select * from books where id=?";
            Connector conn = Connector.getInstance();
            ArrayList arr = new ArrayList();
            arr.add(id);
            ResultSet rs = conn.executeQuery(sql_txt,arr);
            while (rs.next()) {
                int Id = rs.getInt("id");
                String name = rs.getString("name");
                String author = rs.getString("author");
                int qty = rs.getInt("qty");
                return new Book(Id, name, author, qty);
            }
        }catch (Exception e){
        }
        return null;
    }
}
