package library.dao.interfaces;

import library.entities.Book;

import java.util.ArrayList;

public interface IBookRepository {
    ArrayList<Book> all();
    boolean create(Book book);
    boolean update(Book book);
    boolean delete(Book book);
    Book findOne(Integer id);
}
