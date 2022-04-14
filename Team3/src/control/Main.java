package control;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Main implements Initializable{
	
	@FXML
    private Label lbl_login;

    @FXML
    void act_login(MouseEvent event) {
    	System.out.println("로그인 페이지 이동");
    	
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}
//	public void loadpage( String page ) { // loadpage ( 파일경로 )
//		
//		try {
//			// 페이지(fxml) 객체화 
//			Parent parent = FXMLLoader.load( getClass().getResource(page+".fxml") ); // 무조건 예외처리
//			boarderPane.setCenter(parent); // 컨테이너(fxml) 가운데에 페이지 넣기 
//		}
//		catch( Exception e ) { // 파일이 존재하지 않을 경우 예외처리
//			System.out.println("홈 페이지 연결 실패 "+ e); 
//		}
//	}
}
