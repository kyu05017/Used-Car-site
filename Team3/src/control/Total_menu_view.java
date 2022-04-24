package control;

import java.io.IOException;
import java.util.Optional;

import control.board.Main_board;
import control.board.board;
import control.login.Pwcheck;
import dao.DAO_Board;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Total_menu_view {

	@FXML
    private Label lblfindid;
	
	@FXML
    private Label lblfindpw;

    @FXML
    private Label bt_signout;

    @FXML
    private Label bt_change;
    
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
    
}
