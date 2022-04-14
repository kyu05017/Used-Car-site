package Controller.login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;

public class login implements Initializable {

	public static login instance;
	//해당 클래스의 메모리를 반환해주는 메소드
	
	
	public login() { instance=this; }
//	본인객체 = this; //super : 슈퍼클래스(상속) this : 현클래스
//	// this : 현재 클래스 자체 메모리 호출
	
	
	//메인페이지 로드
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
