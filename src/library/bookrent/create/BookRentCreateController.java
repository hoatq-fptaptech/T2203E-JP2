package library.bookrent.create;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import library.dao.impls.BookRepository;
import library.entities.Book;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class BookRentCreateController implements Initializable {
    public ComboBox<Book> cbBook;
    public ComboBox cbStudent;
    public DatePicker dpExpired;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        BookRepository rp = new BookRepository();
        ObservableList<Book> ls = FXCollections.observableArrayList();
        ls.addAll(rp.all());
        cbBook.setItems(ls);
    }

    public void submit(ActionEvent event) {
        Book selected = cbBook.getSelectionModel().getSelectedItem();
        LocalDate dp = dpExpired.getValue();
        System.out.println(selected.getName());
        System.out.println(dp);
    }
}
