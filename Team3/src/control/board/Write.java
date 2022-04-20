package control.board;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Write implements Initializable{
	@FXML
    private Button btback;

    @FXML
    private TextArea txtcontents;

    @FXML
    private Button btwrite1;

    @FXML
    private TextField txttitle;

    @FXML
    private Label lbl_title;

    @FXML
    void accback(ActionEvent event) {
    	Main_board.main_board.loadpage("/view/board/board_view");
    }

    @FXML
    void addwrite(ActionEvent event) {
    	
    }

    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	if(board.board_check == 1) {
    		lbl_title.setText("공지 사항");
    	}
    	else if(board.board_check == 2){
    		lbl_title.setText("자유 게시판");
    	}
    }
}
