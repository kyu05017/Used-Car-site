package control.login;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Mypage implements Initializable{
	
	public static Mypage mypage;

	public Mypage(){mypage = this;}
	
	@FXML
    private BorderPane info_board;

    @FXML
    private Label myinfo;

    @FXML
    private Label bt_change;
    
    @FXML
    private Label bt_letter;

    @FXML
    private Label bt_signout;
    
    @FXML
    private Label bt_chpw;
    
    public static int check;
    
    @FXML
    void change_pw(MouseEvent event) {
    	try {
			Stage stage = new Stage();
			Parent parent = FXMLLoader.load(getClass().getResource("/view/login/pwcheck.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();
			Pwcheck.check = 3;
		} catch (IOException e) {
			System.out.println("Main 알림창 열기 실패"+ e); 
		}
    }
    @FXML
    void bt_signout(MouseEvent event) {
    	try {
			Stage stage = new Stage();
			Parent parent = FXMLLoader.load(getClass().getResource("/view/login/pwcheck.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();
			Pwcheck.check = 1;
		} catch (IOException e) {
			System.out.println("Main 알림창 열기 실패"+ e); 
		}
    }

    @FXML
    void change(MouseEvent event) {
    	try {
			Stage stage = new Stage();
			Parent parent = FXMLLoader.load(getClass().getResource("/view/login/pwcheck.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();
			Pwcheck.check = 2;
		} catch (IOException e) {
			System.out.println("Main 알림창 열기 실패"+ e); 
		}
    }

    @FXML
    void info(MouseEvent event) {
    	loadpage("/view/login/info");
    }

    @FXML
    void letter(MouseEvent event) {
    	loadpage("/view/letter/letter1");
    }
	
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
    	if(check ==1) {
    		loadpage("/view/login/info");
    	}
    	else if(check ==2) {
    		loadpage("/view/letter/letter1");
    	}
    }
    public void loadpage( String page ) {
		try {
			Parent parent = FXMLLoader.load( getClass().getResource(page+".fxml"));
			info_board.setCenter(parent);
		}
		catch( Exception e ) {
			System.out.println("Main 컨트롤 페이지 열기 실패"+ e); 
		}
	}
}