package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

public class Record implements Initializable{

	 @FXML
	 private BorderPane record_border;

	 
	 @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 Home.home.loadpage("/view/record_view");
		
	}
	 
	 
}
