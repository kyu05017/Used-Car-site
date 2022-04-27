package control.car;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import DAO.DAO_Board;
import DAO.DAO_Car;
import DTO.DTO_Board;
import DTO.DTO_Car;
import DTO.board;
import control.Home;
import control.login.Login;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class carreviewadd implements Initializable {

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}
	
	
    @FXML
    private Button btback;

    @FXML
    private TextArea txtcontents;

    @FXML
    private Button btwrite1;

    @FXML
    private TextField txttitle;

    @FXML
    private Label lbl_title;

    @FXML
    private ImageView carimg;

    @FXML
    void accback(ActionEvent event) {
		Home.home.loadpage("/view/board/car_review.fxml");
    }

    @FXML
    void addwrite(ActionEvent event) { //후기 등록
    	String title = txttitle.getText();
    	String content = txtcontents.getText();
    	
    	String writer = Login.member.getM_id();
    	//
    	
    	//객체화를 통한 저장이 필요(dto)
    	board board = new board(0, title, content, writer, 0, 0, 0);
    	
    	boolean result = DAO_Board.bdao.write(board);
    	
    	if(result) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    			alert.setHeaderText("게시글이 작성되었습니다.");
    		alert.showAndWait();
    		
    		Home.home.loadpage("/view/board/car_review.fxml");
    	} else {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setHeaderText("게시글 작성 실패.");
    		alert.showAndWait();}
    	
    }


}
