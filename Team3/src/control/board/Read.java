package control.board;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import control.login.Login;
import dao.DAO_Board;
import dao.DAO_Member;
import dto.DTO_Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class Read implements Initializable{
	
	@FXML
    private Text lbl_board_title;

    @FXML
    private Button bt_back;

    @FXML
    private TextArea txt_contents;

    @FXML
    private Button bt_rewrite1;

    @FXML
    private Text lbl_title;

    @FXML
    private Button bt_delete;

    @FXML
    private Button bt_update;

    @FXML
    private Label lbl_writer;

    @FXML
    private Label blb_date;

    @FXML
    private Label lbl_view;

    @FXML
    private TextArea txt_recontents;

    @FXML
    private TableView<?> re_talbe;

    @FXML
    private Button bt_redelete;

    @FXML
    private Button btreupdate;

    @FXML
    void back(ActionEvent event) {
    	if(board.board_check == 1) {
    		Admin_board.admin_board.loadpage("/view/board/board_view");
		}
		else if(board.board_check == 2){
			Main_board.main_board.loadpage("/view/board/board_view");
		}
    }

    @FXML
    void delete(ActionEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setHeaderText("게시글을 삭제하시겠습니까?");
    	Optional<ButtonType> optional = alert.showAndWait();
    	
    	if(optional.get() == ButtonType.OK) {
    		DAO_Board.bdao.delete(board.board.getB_number());
    		Main_board.main_board.loadpage("/view/board/board_view");
    	}
    			
    	
    }

    @FXML
    void re_del(ActionEvent event) {

    }

    @FXML
    void re_update(ActionEvent event) {

    }

    @FXML
    void re_write(ActionEvent event) {

    }

    @FXML
    void update(ActionEvent event) {

    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(board.board_check == 1) {
			lbl_board_title.setText("공지사항");
		}
		else if(board.board_check == 2){
			lbl_board_title.setText("자유게시판");
		}
		String writer = DAO_Member.mdao.get_id(board.board.getM_number());
		System.out.println(writer);
		if(writer == null) {
			writer = "탈퇴한 회원";
		}
		
		lbl_title.setText(board.board.getB_title());
		lbl_writer.setText("작성자 : " + writer);
		blb_date.setText("작성일 : "+board.board.getB_date());
		lbl_view.setText("조회수 : "+board.board.getB_view());
		txt_contents.setText(board.board.getB_content());
		
//		if(writer.equals(DAO_Member.mdao.get_member(writer))) {
//			bt_delete.setVisible(true);//버튼보이기
//			bt_update.setVisible(true);
//		}else{
//			bt_delete.setVisible(false);//버튼숨기기
//			bt_update.setVisible(false);
//		}
		if(board.board.getM_number()== Login.member.getM_number()) {
			bt_delete.setVisible(true);//버튼보이기
			bt_update.setVisible(true);
		}else{
			bt_delete.setVisible(false);//버튼숨기기
			bt_update.setVisible(false);
		}
		
	}
}