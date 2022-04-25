package control.login;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import control.Main;
import dao.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Pwcheck implements Initializable{
	
	public static Pwcheck pwcheck;

	public Pwcheck(){pwcheck = this;}
	
	@FXML
    private PasswordField txt_pw;

    @FXML
    private Button bt_pw;
    
    public static int check;
    
    @FXML
    void pwcheck(ActionEvent event) {
    	String pw = txt_pw.getText();
    	
    	boolean result = DAO_Member.mdao.check_pw(Login.member.getM_number(),pw);
    	if(result) {
    		Stage thisForm = (Stage) txt_pw.getScene().getWindow();
    		thisForm.close();
    		if(check == 1) {
    			Alert alert = new Alert(AlertType.CONFIRMATION); // 확인,취소 버튼 타입
    			alert.setHeaderText("정말 탈퇴 하시겠습니까?");
    			Optional<ButtonType> optional = alert.showAndWait();
    			if(optional.get() == ButtonType.OK) { 
    				boolean result2 = DAO_Member.mdao.signout(Login.member.getM_number());
    				if(result2) {
    					Login.member = null;
    					Alert alert2 = new Alert(AlertType.INFORMATION);
    		    		alert2.setTitle("회원탈퇴");
    		    		alert2.setHeaderText(" 그동안 이용해 주셔서 감사합니다.");
    		    		alert2.setContentText("완료");
    		    		alert2.showAndWait();
    		    		Main.main.loadpage("/view/home");
    				}
    				else {
    					
    				}
    			}
    			else if(optional.get() == ButtonType.CANCEL) {
    				System.out.println("취소");
    			}
    		}
    		else if(check == 2){
    			Mypage.mypage.loadpage("/view/login/change");
    		}
    		else if(check == 3){
    			Mypage.mypage.loadpage("/view/login/pw_change");
    		}
    	
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
    		if(check == 1) {
    			Alert alert = new Alert(AlertType.CONFIRMATION); // 확인,취소 버튼 타입
    			alert.setHeaderText("정말 탈퇴 하시겠습니까?");
    			Optional<ButtonType> optional = alert.showAndWait();
    			if(optional.get() == ButtonType.OK) { 
    				boolean result2 = DAO_Member.mdao.signout(Login.member.getM_number());
    				if(result2) {
    					Login.member = null;
    					Alert alert2 = new Alert(AlertType.INFORMATION);
    		    		alert2.setTitle("회원탈퇴");
    		    		alert2.setHeaderText(" 그동안 이용해 주셔서 감사합니다.");
    		    		alert2.setContentText("완료");
    		    		alert2.showAndWait();
    		    		Main.main.loadpage("/view/home");
    				}
    				else {
    					
    				}
    			}
    			else if(optional.get() == ButtonType.CANCEL) {
    				System.out.println("취소");
    			}
    		}
    		else if(check == 2){
    			Mypage.mypage.loadpage("/view/login/change");
    		}
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
