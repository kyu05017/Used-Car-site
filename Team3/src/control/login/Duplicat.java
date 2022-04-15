package control.login;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import dao.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class Duplicat implements Initializable{
	
	@FXML
	private TextField txt_newid;
	
	@FXML
	private Button bt_newid;
	
	public TextField new_id = txt_newid;

	@FXML
	void use_id(ActionEvent event) {
		Alert alert2 = new Alert(AlertType.INFORMATION);
    	String id = txt_newid.getText();
    	if(txt_newid.getText().equals("")) {
    		alert2.setTitle("회원가입");
    		alert2.setHeaderText(" 아이디를 입력해 주세요.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		return;
    	}
    	Boolean result1 = DAO_Member.mdao.id_duplicat(id);
    	if(result1) {
    		alert2.setTitle("회원가입");
    		alert2.setHeaderText("중복된 아이디 입니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		return;
    	}
    	else {
    		Alert alert = new Alert(AlertType.CONFIRMATION); // 확인,취소 버튼 타입
    		alert.setHeaderText(id+" 를 사용하시겠습니다?");
    		// 2. 버튼 확인 [ Optional 클래스 ]
    		Optional<ButtonType> optional = alert.showAndWait();
    		if(optional.get() == ButtonType.OK) { 
    			txt_newid.setText(id);
    			new_id.setText(id);
    		}
    		else {
    			txt_newid.setText("");
    			return;
    		}
    	}
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
}
