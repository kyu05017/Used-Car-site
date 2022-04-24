package Controller.letter;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import control.Main;
import control.car.Carlist;
import control.login.Login;
import dao.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Lettersend implements Initializable {
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

    @FXML
    private Button btnback;

    @FXML
    private Button btnsend;

    @FXML
    private Label content;

    @FXML
    private Label letter;

    @FXML
    private TextArea textsend;

    @FXML
    void accback(ActionEvent event) {
    	Main.main.loadpage("/view/home");
    }
    
    ////////////////////
    
    Socket socket; //소켓
    
    public Lettersend(Socket socket) { this.socket = socket; receive(); }
    //반복적으로 메시지를 전달받을 수 있도록 receive 만들기
    
    public void receive() {
    	while(true) {
    		try {
    			InputStream in = socket.getInputStream(); //전달 받기
    			byte[] bytes = new byte[1000];
    			in.read(bytes);
    			String msg = new String(bytes);
    			textsend.appendText(msg); //메시지 창에 띄우기
    		} catch (Exception e) { }
    	}
    }
    
    public void send(String msg) { //서버에게 메세지 보내기
    	Thread thread = new Thread() {
    		@Override
    		public void run() {
    			try {
    				OutputStream outputStream = socket.getOutputStream(); //출력 스트림
    				outputStream.write(msg.getBytes()); //내보내기
    				outputStream.flush(); //초기화(스트림 내 바이트 삭제)
    			} catch (Exception e) { }
    		}
    	}; //멀티스레드 구현 끝
    	thread.start();
    }
    
    
    public static Carlist selectcar; //carlist에서 선택한 차
  

    

    @FXML
    void accsend(ActionEvent event) { //보내기 버튼을 눌렀을 때
    	String msg = Login.member.getM_id()+" : "+ textsend.getText()+"\n";
    	send(msg);
    	textsend.setText("");
    	textsend.requestFocus();
    	}

    
    
    
}
