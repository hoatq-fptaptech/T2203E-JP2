package library.dao.impls;

import library.dao.interfaces.IRepository;
import library.entities.BookRent;

import java.util.ArrayList;

public class BookRentRepository implements IRepository<BookRent> {
    @Override
    public ArrayList<BookRent> all() {
        return null;
    }

    @Override
    public boolean create(BookRent bookRent) {
        return false;
    }

    @Override
    public boolean update(BookRent bookRent) {
        return false;
    }

    @Override
    public boolean delete(BookRent bookRent) {
        return false;
    }

    @Override
    public BookRent findOne(Integer id) {
        return null;
    }
}
