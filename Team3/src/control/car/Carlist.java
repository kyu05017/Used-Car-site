package control.car;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.mysql.cj.protocol.FullReadInputStream;

import control.Home;
import control.Main;
import control.login.Login;
import dao.DAO_Car;
import dto.DTO_Car;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


public class Carlist implements Initializable{
	
	public static DTO_Car select ;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	@FXML
    private VBox vbox;
	
    @FXML
    private ImageView carimg;

    @FXML
    private Label carname; 
	
    void show() {
    	//모든 제품 가져오기
    	 ArrayList<DTO_Car> carlist = DAO_Car.dao_Car.list();
    	 
    	 GridPane gridPane = new GridPane();
    	 
    	 int i = 0;
    	 for (int row = 0; row < carlist.size(); row++) {
			ImageView imageView = new ImageView( new Image(carlist.get(i).getC_img()));
			
			//이미지 사이즈
			imageView.setFitHeight(200);
			imageView.setFitWidth(150);
			
			Button button = new Button(null, imageView);
			
			button.setStyle("-fx-background-color:transparent");
			button.setId("");
			button.setOnAction(e -> {
			
			System.out.println(e.toString());
			int id = Integer.parseInt( e.toString().split(",")[0].split("=")[2]);
		 		
	 		select = carlist.get(id);
	 		
		 	});
		}
    	 vbox.getChildren().add(gridPane);
    }
    
}