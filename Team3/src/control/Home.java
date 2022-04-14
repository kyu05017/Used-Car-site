package control;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Home implements Initializable{
	
	@FXML
    private Label lbl_login;

    @FXML
    void act_login(MouseEvent event){
    	Main.main.loadpage("/view/login/login");
    }
    @FXML
    private BorderPane board_main;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
