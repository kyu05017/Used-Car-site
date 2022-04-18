package control.login;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Change implements Initializable{
	@FXML
    private TextField txt_new_email;

    @FXML
    private TextField txt_new_phone;
    
    @FXML
    private Button btcom;

    @FXML
    void bt_com(ActionEvent event) {
    	
    	Alert alert2 = new Alert(AlertType.INFORMATION);
    	String email = txt_new_email.getText();
    	String phone = txt_new_phone.getText();
    	Pattern pattern = Pattern.compile("\\d{3}-\\d{4}-\\d{4}");
		Matcher matcher = pattern.matcher(phone);
		
		if(phone.contains("-")) {
			if(phone.length() == 13) {}
			else {
				alert2.setTitle("정보 변경");
	    		alert2.setHeaderText("올바르지 않은 전화번호 형식입니다.");
	    		alert2.setContentText("확인");
	    		alert2.showAndWait();
	    		return;
			}
		}
		else {
			if(phone.length() == 11) {}
			else {
				alert2.setTitle("정보 변경");
	    		alert2.setHeaderText("올바르지 않은 전화번호 형식입니다.");
	    		alert2.setContentText("확인");
	    		alert2.showAndWait();
	    		return;
			}
		}
		if (matcher.matches()) {
	    } 
	    else if(!matcher.matches() &&  phone.length() == 11){
	    	String str1 = phone.substring(0, 3);
            String str2 = phone.substring(3, 7);
            String str3 = phone.substring(7, 11);
            phone = str1+"-"+str2+"-"+str3;
            txt_new_phone.setText(phone);
	    }
    	
		boolean result = DAO_Member.mdao.change_info(Login.member.getM_number(), email, phone);
		if(result) {
			alert2.setTitle("정보 변경");
    		alert2.setHeaderText("정보 변경이 완료 되었습니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		Login.member.setM_email(email);
    		Login.member.setM_phone(phone);
    		Mypage.mypage.loadpage("/view/login/info");
		}
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	if (Login.member != null) {
			txt_new_email.setText(Login.member.getM_email());
			txt_new_phone.setText(Login.member.getM_phone());
		}
    }
}
