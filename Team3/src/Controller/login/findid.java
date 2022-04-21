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

public class findid implements Initializable{
	
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
	void findid(ActionEvent event) { //1.아이디 찾기 버튼 클릭
		String name = txtemail.getText();
		String email = txtemail.getText();

		//db에서 찾아오기
		String id = Dao_member.dmem.find_id(name, email);
				//DAO_Member.mdao.find_id(name, email);


		if(id != null) {

			//1.메시지(알람)
			Alert alert = new Alert(AlertType.INFORMATION); //메시지 객체 선언
				//내용물 채우기
				alert.setHeaderText("회원님의 아이디는 : "+ id);
			alert.showAndWait(); //실행

		} else { lblalarm.setText("일치하는 정보가 없습니다."); }

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}

