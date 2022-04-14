package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Main implements Initializable{
	
	@FXML
    private Label lbl_login;

    @FXML
    void act_login(MouseEvent event) {
    	System.out.println("로그인 페이지 이동");
    	
    }	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
