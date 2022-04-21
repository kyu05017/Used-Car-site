package Controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.Dao_member;
import Controller.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class findpw implements Initializable {
	
	@FXML
	private TextField txtid;

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

			//\\입력된 데이터 확인
		String id = txtid.getText();
		String email = txtemail.getText();

		//db
		String pw = Dao_member.dmem.find_pw(id, email);

		//확인
		if(pw != null) {

			//1.메시지(알람)
			Alert alert = new Alert(AlertType.INFORMATION); //메시지 객체 선언
				//내용물 채우기
				alert.setHeaderText("회원님의 비밀번호는 : "+ pw);
			alert.showAndWait(); //실행

		} else { lblalarm.setText("일치하는 정보가 없습니다."); }

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
