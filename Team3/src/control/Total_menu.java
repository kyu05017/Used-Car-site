package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class Total_menu implements Initializable{
	  @FXML
	  private BorderPane total_board;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadpage("/view/total_menu_view");
		
	}
	
	 public void loadpage( String page ) {
		try {
			Parent parent = FXMLLoader.load( getClass().getResource(page+".fxml"));
			total_board.setCenter(parent);
		}
		catch( Exception e ) {
			System.out.println("토탈메뉴 열기 실해 "+ e); 
		}
	}
}