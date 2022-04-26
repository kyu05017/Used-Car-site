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
    
    public static DTO_Board board;
    
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
    	}
    	else if(board_check == 2){
    		board_name.setText("문의사항");
    		bt_write.setVisible(true);
    	}
    	
    	ObservableList<DTO_Board> boardlist = null;
    	
    	if(board_check == 3) {
    		boardlist = DAO_Board.bdao.list2(board_check,Login.member.getM_number());
    	}
    	else {
    		boardlist = DAO_Board.bdao.list(board_check);
    	}
    	
		TableColumn<?, ?> 
		tc = table.getColumns().get(0);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_number"));
		
		tc= table.getColumns().get(1);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_title"));
		
		tc= table.getColumns().get(2);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_date"));
		
		tc= table.getColumns().get(3);
		tc.setCellValueFactory(new PropertyValueFactory<>("b_view"));
		
		table.setItems(boardlist);
		
		table.setOnMouseClicked( e -> { 
			board = table.getSelectionModel().getSelectedItem();
			DAO_Board.bdao.view(board.getB_number(), board.getB_view());
			System.out.println(board_check);
			if(board_check == 1 || board_check == 3) {
				Admin_board.admin_board.loadpage("/view/board/board_read");
			}
			else if(board_check == 2) {
				Main_board.main_board.loadpage("/view/board/board_read");
			}
			
		} );

    }
	
}