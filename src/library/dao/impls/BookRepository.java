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
        String sql_txt = "insert into books(name,author,qty) values(?,?,?)";
        Connector conn = Connector.getInstance();
        ArrayList arr = new ArrayList();
        arr.add(book.getName());
        arr.add(book.getAuthor());
        arr.add(book.getQty());
        if(conn.execute(sql_txt,arr)){
            return true;
        }
        return false;
    }

    @Override
    public boolean update(Book book) {
        return false;
    }

    @Override
    public boolean delete(Book book) {
        return false;
    }

    @Override
    public Book findOne(Integer id) {
        return null;
    }
}
