package control.login;

import java.net.URL;
import java.util.ResourceBundle;

import control.Main;
import dao.DAO_Member;
import dto.DTO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Find_pw implements Initializable{

	@FXML
    private TextField txtname;

    @FXML
    private TextField txtemail;

    @FXML
    private Button btnfindpw;

    @FXML
    private Label lblalarm;

    @FXML
    private Button btnback;

    @FXML
    void back(ActionEvent event) {
    	Main.main.loadpage("/view/login/login");
    }

    @FXML
	void findpw(ActionEvent event) {

		String id = txtname.getText();
		String email = txtemail.getText();
		String pw = DAO_Member.mdao.find_pw(id, email);
		if(pw != null) {
			
			//이메일 전송
			DTO_Member.sendmail(email, pw);
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("회원님의 이메일로 비밀번호를 전송했습니다.");
			alert.showAndWait();
		} else { 
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("존재하지 않는 회원 입니다.");
			alert.showAndWait();
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}