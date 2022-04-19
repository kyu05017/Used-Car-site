package control.board;

import java.net.URL;
import java.util.ResourceBundle;

import dao.DAO_Board;
import dto.DTO_Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

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
    //글작성
    @FXML
    void addwrite(ActionEvent event) {
    	String b_title = txttitle.getText();
    	String b_content = txtcontents.getText();
    	
    	DTO_Board dto_Board = new DTO_Board(0, b_title, b_content, null, 0, 0, 0);
    	
    	boolean result = DAO_Board.bdao.write(dto_Board);
    	if(result) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("글작성되었습니다");
    		alert.showAndWait();
    		Main_board.main_board.loadpage("/view/board/board_view");
    	}else {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("게시글작성실패");
    		alert.showAndWait();
    	}
    	
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	if(Admin_board.board_check == 2){
    		txttitle.setText("자유 게시판"); 
    	}
    }
}
