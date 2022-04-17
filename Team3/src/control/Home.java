package control;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import control.login.Login;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Home implements Initializable{
	
	static boolean alert_check; 
	
	@FXML
    private Label lbl_reg;
	
	@FXML
    private BorderPane board_main;
	
	@FXML
    private Label lbl_alert;
	
	@FXML
    private Label lbl_login;
	
	@FXML
    private Label lbl_logout;

    @FXML
    private Label lbl_myinfo;
	
    @FXML
    void act_alert(MouseEvent event) {
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
    
    @FXML
    void reg(MouseEvent event) {
    	Main.main.loadpage("/view/login/registration");
    }

    @FXML
    void act_login(MouseEvent event){
    	Main.main.loadpage("/view/login/login");
    }
    
    @FXML
    void act_logout(MouseEvent event) {
    	Login.member = null;
    	Main.main.loadpage("/view/home");
    }

    @FXML
    void info(MouseEvent event) {
    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(Login.member != null) {
			try {
				Stage stage = new Stage();
				Parent parent = FXMLLoader.load(getClass().getResource("/view/alert.fxml"));
				Scene scene = new Scene(parent);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				System.out.println("Main 알림창 열기 실패"+ e); 
			}
			lbl_logout.setVisible(true);
			lbl_myinfo.setVisible(true);
			lbl_login.setVisible(false);
			lbl_reg.setVisible(false);
		}
		else {
			lbl_logout.setVisible(false);
			lbl_myinfo.setVisible(false);
			lbl_login.setVisible(true);
			lbl_reg.setVisible(true);
		}
	}
}
