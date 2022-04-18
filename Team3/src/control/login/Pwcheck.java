package control.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Pwcheck implements Initializable{
	
//	public static Pwcheck pwcheck;
//
//	public Pwcheck(){pwcheck = this;}
	
	@FXML
    private PasswordField txt_pw;

    @FXML
    private Button bt_pw;
    
//  public static int check;
    
    @FXML
    void pwcheck(ActionEvent event) {
    	String pw = txt_pw.getText();
    	
    	boolean result = DAO_Member.mdao.check_pw(Login.member.getM_number(),pw);
    	if(result) {
    		Stage thisForm = (Stage) txt_pw.getScene().getWindow();
    		thisForm.close();
//    		if(check == 1) {
//    		}
//    		else if(check == 2){
    		Mypage.mypage.loadpage("/view/login/change");
//    		}
    	}
    	else {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("알림창");
    		alert2.setHeaderText(" 비밀번호가 잘못 되었습니다. ");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		return;
    	}
    }

    @FXML
    void use_pw(ActionEvent event) {
    	String pw = txt_pw.getText();
    	
    	boolean result = DAO_Member.mdao.check_pw(Login.member.getM_number(),pw);
    	if(result) {
    		Stage thisForm = (Stage) bt_pw.getScene().getWindow();
    		thisForm.close();
    		Mypage.mypage.loadpage("/view/login/change");
    	}
    	else {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("알림창");
    		alert2.setHeaderText(" 비밀번호가 잘못 되었습니다. ");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		return;
    	}
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    }
	
}
