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

public class Main_board implements Initializable{
	
	public static Main_board main_board;

	public Main_board(){main_board = this;}
	
	@FXML
    private BorderPane info_board;

    @FXML
    private Label notice;

    @FXML
    private Label free;

    @FXML
    private Label after_buy;
    
    
    @FXML
    void act_afterbuy(MouseEvent event) {
    	
    }

    @FXML
    void act_free(MouseEvent event) {
    	board.board_check = 2;
    	loadpage("/view/board/board_view");
    }

    @FXML
    void act_notice(MouseEvent event) {
    	board.board_check = 1;
    	loadpage("/view/board/board_view");
    }
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	board.board_check = 2;
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
