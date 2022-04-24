package control;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import control.board.board;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;

public class Total_menu_view implements Initializable {
	
	@FXML
	private Label notice;

	@FXML
	private Label free;

	@FXML
    private Label lblfindid;
	
	@FXML
    private Label lblfindpw;

    @FXML
    private Label bt_signout;

    @FXML
    private Label bt_change;
    
    @FXML
    private Label add_car;
    
    @FXML
    void act_addcar(MouseEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("알림창");
		alert.setHeaderText(" 로그인먼저하세요 ");
		Optional<ButtonType> optional = alert.showAndWait();
		
		if(optional.get() == ButtonType.OK) {
			Main.main.loadpage("/view/login/login");
    	}
    }
    
    @FXML
    void act_free(MouseEvent event) {
    	board.board_check = 2;
    	Main.main.loadpage("/view/home");
    	if(board.board_check==2) {
    		Main.main.loadpage("/view/board/main_board");
    	}
    	
    }

    @FXML
    void act_notice(MouseEvent event) {
    	board.board_check = 1;
    	Main.main.loadpage("/view/home");
    	if(board.board_check==1) {
    		Main.main.loadpage("/view/board/main_board");
    	}
    }
    
    @FXML
    void bt_signout(MouseEvent event) {
    	
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("알림창");
		alert.setHeaderText(" 로그인먼저하세요 ");
		Optional<ButtonType> optional = alert.showAndWait();
		
		if(optional.get() == ButtonType.OK) {
			Main.main.loadpage("/view/login/login");
    	}

    }

    @FXML
    void change(MouseEvent event) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("알림창");
		alert.setHeaderText(" 로그인먼저하세요 ");
		Optional<ButtonType> optional = alert.showAndWait();
		
		if(optional.get() == ButtonType.OK) {
			Main.main.loadpage("/view/login/login");
    	}
    }

    @FXML
    void findid(MouseEvent event) {
    	Main.main.loadpage("/view/login/findid");
    }
    
    @FXML
    void findpw(MouseEvent event) {
    	Main.main.loadpage("/view/login/findpw");
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	
    }
    
}
