package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Record implements Initializable{

	 @FXML
	 private BorderPane record_border;

	 
	 @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		 loadpage("/view/record_view");
		
	}
	 
	 public void loadpage( String page ) {
			try {
				Parent parent = FXMLLoader.load( getClass().getResource(page+".fxml"));
				record_border.setCenter(parent);
			}
			catch( Exception e ) {
				System.out.println("Main 컨트롤 페이지 열기 실패"+ e); 
			}
	}
	 
}
