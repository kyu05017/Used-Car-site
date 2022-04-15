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

public class Find_pw implements Initializable{
	
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
    	//1.입력된 데이터 가져오기
    	String m_id = txtid.getText();
    	String m_email = txtemail.getText();
    	//2. DB메소드 호출
    	String m_pw = DAO_Member.mdao.find_pw(m_id, m_email);
    	//3.확인
    	if(m_pw != null) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("비밀번호는"+m_pw+"입니다");
    		alert.showAndWait();
    		
    	}else {
    		lblalarm.setText("입력한 정보가 틀렸습니다.");
    	}
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
}
