package Controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import Controller.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main implements Initializable{
	
	public static Main main;
	public Main(){main = this;}
	
	@FXML
    private BorderPane boarderPane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadpage("/view/home");
		try {
			Stage stage = new Stage();
			Parent parent = FXMLLoader.load(getClass().getResource("/view/alert.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			System.out.println("Main 알림창 열기 실패"+ e); 
		}
		
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
