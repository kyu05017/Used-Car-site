package control.board;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Admin_board implements Initializable{
	
	@FXML
    private BorderPane info_board;

    @FXML
    private Label notice;

    @FXML
    private Label QnA;

    @FXML
    private Label car_qna;

    @FXML
    private Label myQna;

    @FXML
    void bt_signout(MouseEvent event) {

    }

    @FXML
    void change(MouseEvent event) {

    }

    @FXML
    void info(MouseEvent event) {

    }

    @FXML
    void letter(MouseEvent event) {

    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {// TODO Auto-generated method stub
    	
    }
    public void loadpage( String page ) {
		try {
			Parent parent = FXMLLoader.load( getClass().getResource(page+".fxml"));
			info_board.setCenter(parent);
		}
		catch( Exception e ) {
			System.out.println("Main 컨트롤 페이지 열기 실패"+ e); 
		}
	}
}
