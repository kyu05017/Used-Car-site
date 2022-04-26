package control.letter;

	import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import control.car.Carlist;
import control.login.Login;
import dao.DAO_Letter;
import dao.DAO_Member;
import dto.DTO_Letter;
import javafx.event.ActionEvent;
	import javafx.fxml.FXML;
	import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
	import javafx.scene.control.TextArea;
	import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
	    void write(ActionEvent event) {
	    	String msg = txtcontent.getText();
	    	Alert alert2 = new Alert(AlertType.INFORMATION);
	    	
	    	if(msg.equals("")) {
	    		alert2.setTitle("알림창");
	    		alert2.setHeaderText(" 내용을 입력해주세요. ");
	    		alert2.setContentText("확인");
	    		alert2.showAndWait();
	    		txtcontent.requestFocus();
	    	}
	    	else {
	    		String dealer_id = letter1.letter.getM_id();
	    		
	    		DTO_Letter letter = new DTO_Letter(0,Login.member.getM_number(),dealer_id, msg,null,letter1.letter.getC_number());
	    			
	    		boolean result = DAO_Letter.dao_Letter.send(letter);
	    		
	    		if(result) {
	    			txtcontent.setText("");
	    			get();
	    		}
	    	}
	    	
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			get();
			

		}
		
		void get() {
			txtcontentlist.setText("");
			
			ArrayList<DTO_Letter> letters = DAO_Letter.dao_Letter.get(letter1.letter.getC_number(),letter1.letter.getM_number(),Login.member.getM_id());
			
			
			for(DTO_Letter temp : letters) {
				if(temp.getM_number() == Login.member.getM_number()) {
					txtcontentlist.appendText(Login.member.getM_id()+" : "+ temp.getL_content() + "\n");
				}
				else if(temp.getM_id().equals(Login.member.getM_id())){
					txtcontentlist.appendText(letter1.letter.getM_id()+" : "+ temp.getL_content() + "\n");
				}
			}
		}

}