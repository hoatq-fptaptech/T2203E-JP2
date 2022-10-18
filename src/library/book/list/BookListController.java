package library.book.list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.Main;
import library.entities.Book;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<Book,Integer>("id"));
        tdName.setCellValueFactory(new PropertyValueFactory<Book,String>("name"));
        tdAuthor.setCellValueFactory(new PropertyValueFactory<Book,String>("author"));
        tdQty.setCellValueFactory(new PropertyValueFactory<Book,Integer>("qty"));

        ObservableList<Book> ls = FXCollections.observableArrayList();

        // lay data from database
        try {
            String sql_txt = "select * from books";
            Connector conn = new Connector();
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
        }finally {
            tbBooks.setItems(ls);
        }

    }

    public void createNewBook(ActionEvent actionEvent)  throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("../create/create.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }
}
