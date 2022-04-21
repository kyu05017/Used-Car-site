package control.board;

import java.net.URL;

import java.util.ResourceBundle;

import control.Home;
import control.login.Login;

import dao.DAO_Board;
import dto.DTO_Board;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class board implements Initializable{
	
	@FXML
    private TableView<DTO_Board> table;

    @FXML
    private Label board_name;

    @FXML
    private Button bt_write;

    public static int board_check = 0;
    
    public static DTO_Board board; //자유게시판테이블에서 클릭한 글 객체를 저장하는 객체
    
    @FXML
    void act_write(MouseEvent event) {
    	if(Login.member == null) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("알림창");
    		alert2.setHeaderText(" 로그인 후 이용 가능합니다. ");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    	}
    	else {
    		if(board_check == 1) {
    			Admin_board.admin_board.loadpage("/view/board/write");
    		}
    		else if(board_check == 2){
    			Main_board.main_board.loadpage("/view/board/write");
    		}
    		
    	}
    }

    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	bt_write.setVisible(false);
    	
    	if(board_check == 1) {
    		board_name.setText("공지사항");
    		if(Login.member != null) {
    			if(Login.member.getM_gr() == 3) {
        			bt_write.setVisible(true);
        		}
    		}
    	}
    	else if(board_check == 2){
    		board_name.setText("자유 게시판");
    		bt_write.setVisible(true);
    		ObservableList<DTO_Board> boardlist = DAO_Board.bdao.list(board_check);

    		TableColumn tc = table.getColumns().get(0);
    		tc.setCellValueFactory(new PropertyValueFactory<>("b_number"));
    		
    		tc= table.getColumns().get(1);
    		tc.setCellValueFactory(new PropertyValueFactory<>("b_title"));
    		
    		tc= table.getColumns().get(2);
    		tc.setCellValueFactory(new PropertyValueFactory<>("b_date"));
    		
    		tc= table.getColumns().get(3);
    		tc.setCellValueFactory(new PropertyValueFactory<>("b_view"));
    		
    		table.setItems(boardlist);
    		
    		table.setOnMouseClicked( e -> { 
    			System.out.println("클릭되었습니다 : " +e);
    			//1.테이블에서 클릭한 객체를 임시객체에 저장
    			board = table.getSelectionModel().getSelectedItem();//클릭된 board 객체 호출
    			//2. 조회수 증가
    			//3.페이지전환
    			System.out.println(board.getB_title());
    			Main_board.main_board.loadpage("/view/board/board_read");
    		
    		} );
    		
    	}
    	

    }
	
}