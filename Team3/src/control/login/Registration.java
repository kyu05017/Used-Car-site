package control.login;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import control.Main;
import dao.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Registration implements Initializable{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String since = sdf.format(new Date());
	
	@FXML
    private TextField txtid;

    @FXML
    private TextField txtpw;

    @FXML
    private TextField txtpwconfirm;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtphone;

    @FXML
    private TextField txtaddress;

    @FXML
    private Label lblconfirm;

    @FXML
    private Button btnsignup;

    @FXML
    private Button bt_back;
    
    @FXML
    private Button bt_check;

    @FXML
    void back(ActionEvent event) {
    	Main.main.loadpage("/view/home");
    }
    
    static boolean id_check = false;
    
    @FXML
    void id_check(ActionEvent event) {
    	Alert alert2 = new Alert(AlertType.INFORMATION);
    	String id = txtid.getText();
    	if(txtid.getText().equals("")) {
    		alert2.setTitle("회원가입");
    		alert2.setHeaderText(" 아이디를 입력해 주세요.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		return;
    	}
    	Boolean result1 = DAO_Member.mdao.id_duplicat(id);
    	if(result1) {
    		alert2.setTitle("아이디 중복 체크");
    		alert2.setHeaderText(" 중복된 아이디 입니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		id_check = false;
    		return;
    	}
    	else {
    		Alert alert = new Alert(AlertType.CONFIRMATION); // 확인,취소 버튼 타입
    		alert.setHeaderText(txtid+" 를 사용하시겠습니다?");
    		// 2. 버튼 확인 [ Optional 클래스 ]
    		Optional<ButtonType> optional = alert.showAndWait();
    		if(optional.get() == ButtonType.OK) { 
    			txtid.setText(id);
    			id_check = true;
    			txtid.setDisable(true);
    		}
    		else {
    			txtid.setText("");
    			id_check = false;
    			txtid.setDisable(false);
    			return;
    		}
    	}
    }
    @FXML
    void signup(ActionEvent event) {
    	Alert alert2 = new Alert(AlertType.INFORMATION);
    	
    	System.out.println("회원가입");
    	String id = txtid.getText();
    	String pw = txtpw.getText();
    	String pwcheck = txtpwconfirm.getText();
    	String name = txtname.getText();
    	String email = txtemail.getText();
    	String phone = txtphone.getText();
    	
    	Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$");
		Matcher passMatcher1 = passPattern1.matcher(pw);
		Pattern passPattern2 = Pattern.compile("(\\w)\\1\\1\\1");
		Matcher passMatcher2 = passPattern2.matcher(pw);
		
//		if(txtid.equals("") || txtpw.equals("") || txtpwconfirm.equals("") || txtname.equals("") || txtemail.equals("") || txtphone.equals("")) {
//			alert2.setTitle("회원가입");
//    		alert2.setHeaderText("회원가입이 모두 작성되지 않았습니다.");
//    		alert2.setContentText("확인");
//    		alert2.showAndWait();
//			return;
//		}
		if (pw.equals("")) {
			alert2.setTitle("회원가입");
    		alert2.setHeaderText("비밀번호를 입력하세요");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		return;
		}
		if(!passMatcher1.find()){
			alert2.setTitle("회원가입");
    		alert2.setHeaderText("비밀번호는 영문과 특수문자 숫자를 포함하며 8자 이상이어야 합니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
			return;
		}
		if(passMatcher2.find()){
			alert2.setTitle("회원가입");
    		alert2.setHeaderText("비밀번호에 동일한 문자를 과도하게 연속해서 사용할 수 없습니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
			return;
		}
		if(pw.contains(id)){
		    alert2.setTitle("회원가입");
    		alert2.setHeaderText("비밀번호에 아이디가 포함되어있습니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
		    return;
		}
		if(pw.contains(" ")){
		    alert2.setTitle("회원가입");
    		alert2.setHeaderText("비밀번호에 공란이 포함되어있습니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
		    return;
		}
    	
    	
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		
	}
}
