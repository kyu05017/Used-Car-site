package control.login;

import java.net.URL;
import java.util.ResourceBundle;

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
    void accid(ActionEvent event) {

    }

    @FXML
    void acclogin(ActionEvent event) {

    }

    @FXML
    void accpw(ActionEvent event) {

    }

    @FXML
    void findid(MouseEvent event) {

    }

    @FXML
    void findpw(MouseEvent event) {

    }

    @FXML
    void signup(MouseEvent event) {

    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
