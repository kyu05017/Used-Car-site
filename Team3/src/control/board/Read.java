package control.board;

import java.net.URL;
import java.util.ResourceBundle;

import dao.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
		
	}
}