package library.book.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.Main;
import library.dao.impls.BookRepository;
import library.entities.Book;
import library.enums.RepoType;
import library.factory.RepositoryFactory;
import library.helper.Connector;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class BookListController implements Initializable {
    public TableView<Book> tbBooks;
    public TableColumn<Book,Integer> tdId;
    public TableColumn<Book,String> tdName;
    public TableColumn<Book,String> tdAuthor;
    public TableColumn<Book,Integer> tdQty;
    public TableColumn<Book, Button> tdEdit;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Book,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Book,String>("name"));
        tdAuthor.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        tdQty.setCellValueFactory(new PropertyValueFactory<Book,Integer>("qty"));
        tdEdit.setCellValueFactory(new PropertyValueFactory<Book,Button>("edit"));

        ObservableList<Book> ls = FXCollections.observableArrayList();
        // lay data from database
        BookRepository rp = (BookRepository)RepositoryFactory.createRepository(RepoType.BOOK);
        ls.addAll(rp.all());
        tbBooks.setItems(ls);
    }

    public void createNewBook(ActionEvent actionEvent)  throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("../create/create.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
