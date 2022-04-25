package control.login;

import java.net.URL;
import java.util.ResourceBundle;

import dao.DAO_Letter;
import dto.DTO_Letter;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

public class letter1 implements Initializable{
	
    @FXML
    private TableView<DTO_Letter> letter1board;

    @FXML
    private Text txtletter;

	public static DTO_Letter letter;
	
	public static int m_gr = 0;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		int m_number = Login.member.getM_number();
		
    	ObservableList<DTO_Letter> letters = DAO_Letter.dao_Letter.letters(m_number);
    	
		TableColumn tc = letter1board.getColumns().get(0);
		tc = letter1board.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("m_id"));
		
		tc= letter1board.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("c_number"));

		tc= letter1board.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("l_content"));
		
		tc= letter1board.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("l_date"));

		letter1board.setItems(letters);
		
    	letter1board.setOnMouseClicked( e ->  {
    		
    		letter = letter1board.getSelectionModel().getSelectedItem();
    		
    		control.Home.home.loadpage("/view/login/letterview");
    	});
	}
}
