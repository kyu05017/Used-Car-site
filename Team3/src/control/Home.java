package control;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
	
	@FXML
    private Label lbl_reg;
	
	@FXML
    private Label lbl_alert;

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
