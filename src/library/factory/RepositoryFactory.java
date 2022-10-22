package library.factory;

import library.dao.impls.BookRentRepository;
import library.dao.impls.BookRepository;
import library.dao.interfaces.IRepository;
import library.enums.RepoType;

public class RepositoryFactory {
    private RepositoryFactory(){
    }

    public static IRepository createRepository(RepoType type){
        switch (type){
            case BOOK: return new BookRepository();
            case BOOKRENT: return new BookRentRepository();
            default: throw new IllegalArgumentException("Thiếu tham số rồi");
        }
    }
}
