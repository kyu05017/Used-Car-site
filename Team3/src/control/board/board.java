package control.board;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class board implements Initializable{
	
	@FXML
    private TableView<?> table;

    @FXML
    private Label board_name;

    @FXML
    private Button bt_write;

    @FXML
    void act_write(MouseEvent event) {
    	
    	Main_board.main_board.loadpage("/view/board/write");
    }

    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    	if(Admin_board.board_check == 1) {
    		board_name.setText("공지사항");
    		bt_write.setVisible(false);
    	}
    	else if(Admin_board.board_check == 2){
    		board_name.setText("자유 게시판");
    		bt_write.setVisible(true);
    	}
    	

    }
	
}
