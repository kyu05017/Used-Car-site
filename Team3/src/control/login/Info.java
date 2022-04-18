package control.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class Info implements Initializable{
	
	@FXML
    private Label lbl_id;

    @FXML
    private Label lbl_name;

    @FXML
    private Label lbl_email;

    @FXML
    private Label lbl_phone;

    @FXML
    private Label lbl_date;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		lbl_id.setText(Login.member.getM_id());
		lbl_name.setText(Login.member.getM_name());
		lbl_email.setText(Login.member.getM_email());
		lbl_phone.setText(Login.member.getM_phone());
		lbl_date.setText(Login.member.getM_date());
	}
}
