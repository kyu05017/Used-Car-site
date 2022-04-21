package Controller.board;

import java.net.URL;
import java.util.ResourceBundle;

import control.Home;
import control.login.Login;
import dao.DAO_board;
import dto.DTO_Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    void addwrite(ActionEvent event) { //게시물 등록
    		//1. 입력된 데이터 가져오기
    	String title = txttitle.getText();
    	String content = txtcontents.getText();
    	
    	//로그인에 성공했을 경우 저장된 멤버 객체를 빼옴
    	String write = Login.member.getM_id();
    	
    	
    		//2.입력한 내용을 dto에 있는 board에 저장한다
    	DTO_Board board = new DTO_Board(0, title, content, null, 0, 0, 0);
    	
    	
    	
    		//3.db에 게시물을 저장한다.
    	boolean result = DAO_board.boarddao.write(board);
    	
    		if(result) { //성공했다면
    			Alert alert = new Alert(AlertType.INFORMATION);
    				alert.setHeaderText("게시글이 작성되었습니다.");
    			alert.showAndWait(); //페이지 전환
    			
    			Home.home.loadpage("/view/board/board_view");
    			
    		} else { //실패했다면
    			Alert alert = new Alert(AlertType.INFORMATION);
    				alert.setHeaderText("작성에 실패하였습니다. [관리자 문의]");
    			alert.showAndWait();
    		}	
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
