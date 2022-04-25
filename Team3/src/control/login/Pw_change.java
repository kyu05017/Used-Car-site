package control.login;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import DAO.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;

public class Pw_change implements Initializable{

	
	@FXML
	private Button btcom;
	
	@FXML
	private PasswordField pw;
	
	@FXML
	private PasswordField pw_check;
	
	@FXML
	void bt_com(ActionEvent event) {
		Alert alert2 = new Alert(AlertType.INFORMATION);
		
		String pw1 = pw.getText();
		String pw2 = pw_check.getText();
		
		Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z0-9])(?=.*\\d)(?=.*\\W).{8,20}$");
		Matcher passMatcher1 = passPattern1.matcher(pw1);
		Pattern passPattern2 = Pattern.compile("(\\w)\\1\\1\\1");
		Matcher passMatcher2 = passPattern2.matcher(pw1);

		if (pw1.equals("")) {
			alert2.setTitle("비밀번호 변경");
    		alert2.setHeaderText("비밀번호를 입력하세요");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		pw.requestFocus();
    		return;
		}
		if(!passMatcher1.find()){
			alert2.setTitle("비밀번호 변경");
    		alert2.setHeaderText("비밀번호는 영문과 특수문자 숫자를 포함하며 8자 이상이어야 합니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		pw.requestFocus();
			return;
		}
		if(passMatcher2.find()){
			alert2.setTitle("비밀번호 변경");
    		alert2.setHeaderText("비밀번호에 동일한 문자를 과도하게 연속해서 사용할 수 없습니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		pw.requestFocus();
			return;
		}
		if(pw1.contains(Login.member.getM_id())){
		    alert2.setTitle("비밀번호 변경");
    		alert2.setHeaderText("비밀번호에 아이디가 포함되어있습니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		pw.requestFocus();
		    return;
		}
		if(pw1.contains(" ")){
		    alert2.setTitle("비밀번호 변경");
    		alert2.setHeaderText("비밀번호에 공란이 포함되어있습니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		pw.requestFocus();
		    return;
		}
		
		if(pw2.equals("")) {
			alert2.setTitle("비밀번호 변경");
    		alert2.setHeaderText("비밀번호를 재입력해주세요.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		pw_check.requestFocus();
		}
		if(!pw1.equals(pw2)) {
			alert2.setTitle("비밀번호 변경");
    		alert2.setHeaderText("비밀번호가 다릅니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		pw_check.requestFocus();
		    return;
		}
		boolean result = DAO_Member.mdao.change_pw(Login.member.getM_number(),pw1);
		if(result) {
			alert2.setTitle("비밀번호 변경");
    		alert2.setHeaderText("비밀번호 변경이 완료 되었습니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		Mypage.mypage.loadpage("/view/login/info");
		}
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
