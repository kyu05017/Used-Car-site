package app;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Start extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("/View/testmain.fxml"));
		
		Scene scene = new Scene(parent);
		stage.setScene(scene);
		
//		stage.setOnCloseRequest(e ->{
//			if(login.member != null) { 
//				roomDao.roomDao.roomlivedelete(login.member.getMid());
//											//로그인된 멤버의 아이디 가져오기
//				
//				//2. 방 삭제
//				if(Chatting.selectroom != null) {
//					//만약에 방에 접속 되어 있는 상태이면
//					roomDao.roomDao.roomdelete(Chatting.selectroom.getRonum());
//				}							//채팅에 내가 선택한 방의 방 번호 넣어주기
//				
//				//3. 선택 방 초기화
//				Chatting.selectroom = null;
//				
//			}
			
		//});
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
