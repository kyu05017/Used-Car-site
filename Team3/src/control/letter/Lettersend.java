package control.letter;


import java.net.URL;
import java.util.ResourceBundle;

import control.Main;
import control.car.Carlist;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Lettersend implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

    @FXML
    private Button btnback;

    @FXML
    private Button btnsend;

    @FXML
    private Label content;

    @FXML
    private Label letter;

    @FXML
    private TextArea textsend;

    @FXML
    void accback(ActionEvent event) {
    	Stage thisForm = (Stage) btnback.getScene().getWindow();
		thisForm.close();
    	Main.main.loadpage("/view/home");
    }
    

    
    public static Carlist selectcar; //carlist에서 선택한 차
  
    

    @FXML
    void accsend(ActionEvent event) { //보내기 버튼을 눌렀을 때

    }

    
}