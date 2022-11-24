package library;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import library.entities.CurrentWeather;
import library.enums.LangType;
import library.services.WeatherService;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    public Button books;
    public Button students;
    public Button rents;
    public RadioButton langEn;
    public RadioButton langVi;
    public RadioButton langDe;
    private static LangType lang = LangType.EN;
    public Text city;
    public Text temp;
    public ImageView icon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ResourceBundle rb = ResourceBundle.getBundle("demoI18n.message");
        books.setText(rb.getString("books"));
        students.setText(rb.getString("students"));
        rents.setText(rb.getString("rents"));
        changeSelected();

        CurrentWeather cw = WeatherService.getCurrentWeather();
        if(cw != null){
            city.setText(cw.getName());
            temp.setText(cw.getMain().getTemp().toString());
            String ic = cw.getWeather().get(0).getIcon();
            Image img = new Image("http://openweathermap.org/img/wn/"+ic+"@2x.png");
            icon.setImage(img);
        }
    }

    private void changeSelected(){
        langEn.setSelected(false);
        langVi.setSelected(false);
        langDe.setSelected(false);
        if(lang== LangType.EN){
            langEn.setSelected(true);
        }else if(lang== LangType.VN){
            langVi.setSelected(true);
        }else{
            langDe.setSelected(true);
        }
    }

    public void goToBookList(ActionEvent actionEvent) throws Exception {
        Parent listBook = FXMLLoader.load(getClass().getResource("book/list/list.fxml"));
        Main.rootStage.setTitle("Books");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void goToRents(ActionEvent event) throws Exception{
        Parent listBook = FXMLLoader.load(getClass().getResource("bookrent/list/list.fxml"));
        Main.rootStage.setTitle("Book rents");
        Main.rootStage.setScene(new Scene(listBook,800,600));
    }

    public void changeLang(ActionEvent actionEvent) {
        Node node = (Node) actionEvent.getSource() ;
        String data = (String) node.getUserData();
        if(data.equals("vi")){
            Locale vi = new Locale("vi","VN");
            Locale.setDefault(vi);
            lang = LangType.VN;
        }else if(data.equals("en")){
            Locale en = new Locale("en","VN");
            Locale.setDefault(en);
            lang = LangType.EN;
        }else{
            Locale de = new Locale("de","DE");
            Locale.setDefault(de);
            lang = LangType.DE;
        }
        try {
            Parent listBook = FXMLLoader.load(getClass().getResource("home.fxml"));
            Main.rootStage.setScene(new Scene(listBook,800,600));
        }catch (Exception e){}
    }
}
