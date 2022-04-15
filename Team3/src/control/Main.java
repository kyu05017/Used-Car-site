package control;

<<<<<<< HEAD
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class Main implements Initializable{
	
	@FXML
    private Label lbl_login;
	
	@FXML
    private Label lblsignup;

    @FXML
    void accsignup(MouseEvent event) {
    	loadpage("/view/signup");
    }

    @FXML
    void act_login(MouseEvent event) {
    	System.out.println("로그인 페이지 이동");
    	
    }
    @FXML
    private BorderPane board_main;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
	public void loadpage( String page ) { // loadpage ( 파일경로 )
		
		try {
			// 페이지(fxml) 객체화 
			Parent parent = FXMLLoader.load( getClass().getResource(page+".fxml") ); // 무조건 예외처리
			board_main.setCenter(parent); // 컨테이너(fxml) 가운데에 페이지 넣기 
		}
		catch( Exception e ) { // 파일이 존재하지 않을 경우 예외처리
			System.out.println("홈 페이지 연결 실패 "+ e); 
		}
	}
}
=======
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import control.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main implements Initializable{
	
	public static Main main;
	public Main(){main = this;}
	
	@FXML
    private BorderPane boarderPane;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		loadpage("/view/home");
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
	public void loadpage( String page ) {
		try {
			Parent parent = FXMLLoader.load( getClass().getResource(page+".fxml"));
			boarderPane.setCenter(parent);
		}
		catch( Exception e ) {
			System.out.println("Main 컨트롤 페이지 열기 실패"+ e); 
		}
	}
}
>>>>>>> refs/remotes/origin/master
