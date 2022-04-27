package control.car;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DAO.DAO_Car;
import DTO.DTO_Board;
import DTO.DTO_Car;
import control.board.Admin_board;
import control.board.Main_board;
import control.login.Login;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class Carreveiw implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btnwrite.setVisible(false);
		
		if(board_check == 1) {
			board_name.setText("후기 게시판");
			if(Login.member != null) {
				if(Login.member.getM_gr() == 4) {
					btnwrite.setVisible(true);
				}
			}
		} else if(board_check == 2) {		
			board_name.setText("후기 게시판");
			if(Login.member != null) {
				if(Login.member.getM_gr() != 4) {
		      	Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("알림창");
		    	alert.setHeaderText(" 이용 가능한 등급이 아닙니다. ");
		    	alert.setContentText("확인");
		    	alert.showAndWait(); 
				}
			}				
 		}		
	}
	

	@FXML
	private TableView<DTO_Car> table; //테이블에 넣을 자료형 선택

	public static DTO_Board board; //임시 저장?
	
	@FXML
	private Label board_name;

    @FXML
    private Button btnwrite;

    @FXML
    private Button btnsearch;

    @FXML
    private TextField txtsearch;

    @FXML
    void accsearch(ActionEvent event) { //후기 검색

    }

    public static int board_check = 0;
    
    @FXML
    void accwrite(ActionEvent event) { //후기 작성
    	if(Login.member == null) {
       		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("알림창");
    		alert.setHeaderText(" 로그인 후 이용 가능합니다. ");
    		alert.setContentText("확인");
    		alert.showAndWait();
    	}
    	else {
    		if(board_check == 1) {
    			Admin_board.admin_board.loadpage("/view/car/carreviewadd");
    			} else if (board_check == 2) {
        		Admin_board.admin_board.loadpage("/view/car/carreview");   				
    			}
    		
    		}
    //추가	
    	
    	
    	
    }
    





}
