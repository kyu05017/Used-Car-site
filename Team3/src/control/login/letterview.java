package control.login;

import java.net.URL;
import java.util.ResourceBundle;

import controller.login.Login;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class letterview implements Initializable {


    @FXML
    private Text txtletter;

    @FXML
    private TextField txtcontent;

    @FXML
    private Button btnget;

    @FXML
    private Button btnwrite;

    @FXML
    private TextArea txtcontentlist;

    @FXML
    void get(ActionEvent event) {

    }

    @FXML
    void write(ActionEvent event) {

    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		dto.DTO_Letter letter = control.login.letter1.letter;
		
		txtcontentlist.setText(letter.getL_content());
		
	}
	
	
}
