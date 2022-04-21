package control.login;

import java.net.URL;
import java.util.ResourceBundle;

import control.Main;
import dao.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Find_id implements Initializable{
	
	@FXML
    private TextField txtname;

    @FXML
    private TextField txtemail;

    @FXML
    private Button btnfindid;

    @FXML
    private Label lblalarm;

    @FXML
    private Button btnback;

    @FXML
    void back(ActionEvent event) {
    	Main.main.loadpage("/view/login/login");
    }

    @FXML
	void findid(ActionEvent event) {
		String name = txtname.getText();
		String email = txtemail.getText();
		String id = DAO_Member.mdao.find_id(name, email);
		if(id != null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("회원님의 아이디는 : "+ id);
			alert.showAndWait();
			
		} else { 
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("존재하지 않는 회원입니다.");
			alert.showAndWait();
		}
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
