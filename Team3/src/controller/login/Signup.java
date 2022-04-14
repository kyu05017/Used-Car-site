package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Signup implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
	@FXML
    private TextField txtid;

    @FXML
    private TextField txtpw;

    @FXML
    private TextField txtpwconfirm;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtphone;

    @FXML
    private TextField txtaddress;

    @FXML
    private Label lblconfirm;

    @FXML
    private Button btnsignup;

    @FXML
    void signup(ActionEvent event) {

    }
	
	
	
}
