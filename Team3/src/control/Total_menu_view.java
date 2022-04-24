package control;


import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import control.board.Admin_board;
import control.board.Main_board;
import control.board.board;
import control.login.Login;
import control.login.Mypage;
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
    	if(Login.member != null) {
    		if(Login.member.getM_gr() == 1) {
    			Home.home.loadpage("/view/car/Caradd");
    		}
    		else {
    			Alert alert2 = new Alert(AlertType.INFORMATION);
        		alert2.setTitle("알림창");
        		alert2.setHeaderText(" 딜러만 이용가능합니다.");
        		alert2.setContentText("확인");
        		alert2.showAndWait();
        		return;
    		}
    	}
    	else {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("알림창");
			alert.setHeaderText(" 로그인먼저하세요 ");
			Optional<ButtonType> optional = alert.showAndWait();
			
			if(optional.get() == ButtonType.OK) {
				Main.main.loadpage("/view/login/login");
	    	}
    	}
    	
    }
    
    @FXML
    void act_free(MouseEvent event) {
    	Home.home.loadpage("/view/board/main_board");

    }

    @FXML
    void act_notice(MouseEvent event) {
    	
    	Home.home.loadpage("/view/board/admin_board");
    }
    
    @FXML
    void bt_signout(MouseEvent event) {
    	if(Login.member != null) {
    		
    	}
    	else {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("알림창");
			alert.setHeaderText(" 로그인먼저하세요 ");
			Optional<ButtonType> optional = alert.showAndWait();
			
			if(optional.get() == ButtonType.OK) {
				Main.main.loadpage("/view/login/login");
	    	}
    	}
    	

    }

    @FXML
    void change(MouseEvent event) {
    	if(Login.member != null) {
    		
    	}
    	else {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("알림창");
			alert.setHeaderText(" 로그인먼저하세요 ");
			Optional<ButtonType> optional = alert.showAndWait();
			
			if(optional.get() == ButtonType.OK) {
				Main.main.loadpage("/view/login/login");
	    	}
    	}
    }

    @FXML
    void findid(MouseEvent event) {
    	if(Login.member != null) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("알림창");
    		alert2.setHeaderText(" 이미 로그인 중입니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		return;
    	}
    	else {
    		Main.main.loadpage("/view/login/findid");
    	}
    	
    }
    
    @FXML
    void findpw(MouseEvent event) {
    	if(Login.member != null) {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("알림창");
    		alert2.setHeaderText(" 이미 로그인 중입니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		return;
    	}
    	else {
    		Main.main.loadpage("/view/login/findpw");
    	}
    }
    
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	
    	
    }
    
}