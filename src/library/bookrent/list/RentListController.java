package library.bookrent.list;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import library.dao.impls.BookRentRepository;
import library.entities.BookRent;
import library.enums.RepoType;
import library.factory.RepositoryFactory;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class RentListController implements Initializable {
    public TableView<BookRent> tbRents;
    public TableColumn<BookRent,String> tdbook;
    public TableColumn<BookRent,Integer> tdStudent;
    public TableColumn<BookRent, Date> tdRentDate;
    public TableColumn<BookRent,Date> tdExpired;
    public TableColumn<BookRent,String> tdStatus;
    public TableColumn<BookRent,Integer> tdId;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tdId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tdbook.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        tdStudent.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        tdRentDate.setCellValueFactory(new PropertyValueFactory<>("rentDate"));
        tdExpired.setCellValueFactory(new PropertyValueFactory<>("expiredDate"));
        tdStatus.setCellValueFactory(new PropertyValueFactory<>("statusLabel"));
        BookRentRepository brr = (BookRentRepository)RepositoryFactory.createRepository(RepoType.BOOKRENT);
        tbRents.getItems().addAll(brr.all());
    }
}
