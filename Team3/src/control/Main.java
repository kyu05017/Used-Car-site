package control;

import java.net.URL;
import java.util.ResourceBundle;

import control.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable{
	
	public static Main main;
	public Main(){main = this;}
	
	@FXML
    private BorderPane boarderPane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadpage("/view/home");
	}
	public void loadpage( String page ) {
		try {
			Parent parent = FXMLLoader.load( getClass().getResource(page+".fxml"));
			boarderPane.setCenter(parent);
		}
		catch( Exception e ) {
			System.out.println("Main 컨트롤 페이지 열기 실패"+ e); 
		}
	}
}
