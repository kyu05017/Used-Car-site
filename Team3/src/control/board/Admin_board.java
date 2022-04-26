package control.board;

import java.net.URL;
import java.util.ResourceBundle;

import control.Home;
import control.login.Login;
import control.login.Mypage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Admin_board implements Initializable{
	
	public static Admin_board admin_board;

	public Admin_board(){admin_board = this;}
	
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
    void act_QnA(MouseEvent event) {
		if(Login.member != null) {
			board.board_check = 3;
			Admin_board.admin_board.loadpage("/view/board/write");
    	}
    	else {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("알림창");
    		alert2.setHeaderText(" 로그인 후 이용 가능합니다. ");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    	}
    }

    @FXML
    void act_myQna(MouseEvent event) {
    	if(Login.member != null) {
    		board.board_check = 3;
        	Admin_board.admin_board.loadpage("/view/board/board_view");
    	}
    	else {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("알림창");
    		alert2.setHeaderText(" 로그인 후 이용 가능합니다. ");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    	}
    }	

    @FXML
    void act_notice(MouseEvent event) {
    	board.board_check = 1;
    	loadpage("/view/board/board_view");
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {// TODO Auto-generated method stub
    	board.board_check = 1;
    	loadpage("/view/board/board_view");
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