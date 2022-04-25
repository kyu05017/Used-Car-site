package control.login;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import dao.DAO_Member;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Alert.AlertType;


public class Duplicat implements Initializable{
	
	@FXML
	private TextField txt_newid;
	
	@FXML
	private Button bt_newid;	
	
	public static String id2;
	@FXML
	void use_id(ActionEvent event) {
		Alert alert2 = new Alert(AlertType.INFORMATION);
		id2 = txt_newid.getText();
    	if(txt_newid.getText().equals("")) {
    		alert2.setTitle("회원가입");
    		alert2.setHeaderText(" 아이디를 입력해 주세요.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		return;
    	}
    	Boolean result1 = DAO_Member.mdao.id_duplicat(id2);
    	if(result1) {
    		alert2.setTitle("회원가입");
    		alert2.setHeaderText("중복된 아이디 입니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		return;
    	}
    	else {
    		txt_newid.setText(id2);
    		Stage thisForm = (Stage) bt_newid.getScene().getWindow();
    		thisForm.close();
    	    return;
    	}
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		txt_newid.setText(Registration.id);
	}
}
