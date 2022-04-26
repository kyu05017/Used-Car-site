package control.letter;


import java.net.URL;
import java.util.ResourceBundle;

import control.Home;
import control.car.Carlist;
import control.login.Login;
import control.login.Mypage;
import dao.DAO_Letter;
import dao.DAO_Member;
import dto.DTO_Letter;
import dto.Letter;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class letter1 implements Initializable{
	
    @FXML
    private TableView<Letter> letter1board;

    @FXML
    private Text txtletter;
    
    public static letter1 letter1;

	public letter1(){letter1 = this;}
    
	public static Letter letter;
	
	public static int m_gr = 0;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		int m_number = Login.member.getM_number();
		int grade = Login.member.getM_gr();
		String id = Login.member.getM_id();
		
		ObservableList<Letter> letters = DAO_Letter.dao_Letter.letters(m_number,id);
 
		TableColumn tc = letter1board.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("title"));

		tc= letter1board.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("l_content"));
		
		tc= letter1board.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("l_date"));

		letter1board.setItems(letters);
		

    	letter1board.setOnMouseClicked( e ->  {

    		letter = letter1board.getSelectionModel().getSelectedItem();

    		Mypage.mypage.loadpage("/view/letter/letterview");
    	});
		
    	
	}
}
