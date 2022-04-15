package control.login;

import java.net.URL;
import java.util.ResourceBundle;

import control.Main;
import dao.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Login implements Initializable{
	
	@FXML
    private TextField txtid;

    @FXML
    private TextField txtpw;

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
    		Main.main.loadpage("/view/home");
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
