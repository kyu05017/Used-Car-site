package control.letter;

	import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import control.login.Login;
import dao.DAO_Letter;
import dto.DTO_Letter;
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
	    void write(ActionEvent event) {
	    	String l_content = txtcontent.getText();
	    	String m_id = Login.member.getM_id();
	    	
	    	
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			System.out.println(letter1.letter.getM_number());
			System.out.println(letter1.letter.getC_number());
			ArrayList<DTO_Letter> letters = DAO_Letter.dao_Letter.get(letter1.letter.getC_number(),letter1.letter.getM_number());
			
			for(DTO_Letter temp : letters) {
				if(temp.getM_number() == Login.member.getM_number()) {
					txtcontentlist.appendText(Login.member.getM_id()+" : "+ temp.getL_content() + "\n");
				}
				else {
					txtcontentlist.appendText("���� : "+ temp.getL_content() + "\n");
				}
				System.out.println(temp.getL_content());
			}
			

		}

}