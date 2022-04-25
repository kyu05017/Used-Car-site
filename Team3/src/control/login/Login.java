package control.login;

import java.net.URL;
import java.util.ResourceBundle;
import control.Main;
import DAO.DAO_Member;
import DTO.DTO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class Login implements Initializable{
	
	public static Login login;
	public Login() {
		login = this;
	}
	public static DTO_Member member;
	
	@FXML
    private TextField txtid;

    @FXML
    private PasswordField  txtpw;

    @FXML
    private Button btnlogin;

    @FXML
    private Label lblerror;

    @FXML
    private Label lblfindid;

    @FXML
    private Label lblfindpw;

    @FXML
    private Label lblsignup;
    
    @FXML
    private Button bt_back;
    
    @FXML
    void back(ActionEvent event) {
    	Main.main.loadpage("/view/home");
    }
    
	@FXML
    void acclogin(ActionEvent event) {
    	
    	String id = txtid.getText();
    	String pw = txtpw.getText();
    	
    	boolean result = DAO_Member.mdao.login(id, pw);
    	if(result) {
    		Login.member = DAO_Member.mdao.get_member(id);
    		Main.main.loadpage("/view/home");
    	}
    	else {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("알림창");
    		alert2.setHeaderText(" 아이디 또는 비밀번호가 잘못 되었습니다. ");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    	}
    }
	
	@FXML
    void login(ActionEvent event) {
		String id = txtid.getText();
    	String pw = txtpw.getText();
    	
    	boolean result = DAO_Member.mdao.login(id, pw);
    	if(result) {
    		Login.member = DAO_Member.mdao.get_member(id);
    		Main.main.loadpage("/view/home");
    	}
    	else {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("알림창");
    		alert2.setHeaderText(" 아이디 또는 비밀번호가 잘못 되었습니다. ");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    	}
    }
	
    @FXML
    void findid(MouseEvent event) {
    	Main.main.loadpage("/view/login/findid");
    }

    @FXML
    void findpw(MouseEvent event) {
    	Main.main.loadpage("/view/login/findpw");
    }

    @FXML
    void signup(MouseEvent event) {
    	Main.main.loadpage("/view/login/registration");
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
}
