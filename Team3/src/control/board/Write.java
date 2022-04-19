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
    	if(Admin_board.board_check == 1){
    		txttitle.setText("공지 사항");
    	}
    	if(Admin_board.board_check == 2){
    		txttitle.setText("자유 게시판");
    	}
    }
}
