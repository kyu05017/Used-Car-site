package controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Findpw implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
	}
	
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

	    }

	    @FXML
	    void findpw(ActionEvent event) {

	    }
	
}
