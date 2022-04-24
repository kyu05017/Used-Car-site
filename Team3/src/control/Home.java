package control;


import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;

import control.board.Admin_board;
import control.car.Carlist;
import control.login.Login;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Home implements Initializable{
	
	static boolean alert_check; 
	
	public static Home home;

	public Home(){home = this;}
	
	@FXML
	private Label add_car;
	
	@FXML
    private Label new_car;
	
	@FXML
	private ImageView bt_home;
	  
	@FXML
    private Label lbl_reg;
	
	@FXML
    private BorderPane board_main;
	
	@FXML
    private Label lbl_alert;
	
	@FXML
    private Label lbl_login;
	
	@FXML
    private Label lbl_logout;

    @FXML
    private Label lbl_myinfo;
	
    @FXML
    private Label notice;
    
    @FXML
    private Label free_board;
    
    @FXML
    private Label popular;
    
    @FXML
    private Label total_menu;
    
    @FXML
    void act_totalmenu(MouseEvent event) {
    	loadpage("/view/total_menu");
    }
    
    @FXML
    void act_popular(MouseEvent event) {
    	Carlist.carlist.show("pop");
    }
    @FXML
    void act_freeboard(MouseEvent event) {
    	loadpage("/view/board/main_board");
    }
    
    @FXML
    void act_notice(MouseEvent event) {
    	loadpage("/view/board/admin_board");
    }
    
    @FXML
    void act_alert(MouseEvent event) {
    	if(Login.member != null){
    		try {
    			Stage stage = new Stage();
    			Parent parent = FXMLLoader.load(getClass().getResource("/view/alert.fxml"));
    			Scene scene = new Scene(parent);
    			stage.setScene(scene);
    			stage.show();
    		} catch (IOException e) {
    			System.out.println("Main 알림창 열기 실패"+ e); 
    		}
    	}
    	else {
    		Alert alert2 = new Alert(AlertType.INFORMATION);
    		alert2.setTitle("알림창");
    		alert2.setHeaderText(" 로그인 후 이용 가능합니다. ");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    	}
    }
    @FXML
    void to_home(MouseEvent event) {
    	Main.main.loadpage("/view/home");
    }
    @FXML
    void act_addcar(MouseEvent event) {
    	loadpage("/view/car/Caradd");
    }
    
    @FXML
    void new_car(MouseEvent event) {
    	Carlist.carlist.show("new");
    }
    @FXML
    void reg(MouseEvent event) {
    	Main.main.loadpage("/view/login/registration");
    }

    @FXML
    void act_login(MouseEvent event){
    	Main.main.loadpage("/view/login/login");
    }
    
    @FXML
    void act_logout(MouseEvent event) {
    	if(Login.member != null) {
	    	Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("로그아웃 하시겠습니까?");
			Optional<ButtonType> optional = alert.showAndWait();
			if(optional.get() == ButtonType.OK) { 
				Login.member = null;
	    		Main.main.loadpage("/view/home");
			}
		}
    }

    @FXML
    void info(MouseEvent event) {
    	if(Login.member != null) {
    		loadpage("/view/login/mypage");
    	}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadpage("/view/car/carlist");
		if(Login.member != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String today = sdf.format(new Date());
			if(!Login.member.getM_today().equals(today)) {
				try {
					Stage stage = new Stage();
					Parent parent = FXMLLoader.load(getClass().getResource("/view/alert.fxml"));
					Scene scene = new Scene(parent);
					stage.setScene(scene);
					stage.show();
				} catch (IOException e) {
					System.out.println("Main 알림창 열기 실패"+ e); 
				}
			}
			if(Login.member.getM_gr() == 1 || Login.member.getM_gr() == 3) {
				add_car.setVisible(true);
				new_car.setVisible(false);
			}
			lbl_logout.setVisible(true);
			lbl_myinfo.setVisible(true);
			lbl_login.setVisible(false);
			lbl_reg.setVisible(false);
		}
		else {
			lbl_logout.setVisible(false);
			lbl_myinfo.setVisible(false);
			lbl_login.setVisible(true);
			lbl_reg.setVisible(true);
			add_car.setVisible(false);
			new_car.setVisible(true);
		}
		
		
	}
	public void loadpage( String page ) {
		try {
			Parent parent = FXMLLoader.load( getClass().getResource(page+".fxml"));
			board_main.setCenter(parent);
		}
		catch( Exception e ) {
			System.out.println("Main 컨트롤 페이지 열기 실패"+ e); 
		}
	}
}