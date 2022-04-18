package control.login;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import control.Main;
import dao.DAO_Member;
import dto.DTO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class Registration implements Initializable{
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@FXML
    private TextField txtid;

    @FXML
    private PasswordField  txtpw;

    @FXML
    private PasswordField  txtpwconfirm;

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
    private RadioButton otp_normal;

    @FXML
    private RadioButton otp_diller;

    @FXML
    private ToggleGroup member_class;
    
    @FXML
    private Button bt_check;
    
    static boolean pass = true;
    
    @FXML
    void back(ActionEvent event) {
    	Main.main.loadpage("/view/home");
    	pass = false;
    }
    static boolean id_check = false;
	public static String id;
	
	@FXML
    void id_check(ActionEvent event) {
    	Alert alert2 = new Alert(AlertType.INFORMATION);
    	id = txtid.getText();
    	if(txtid.getText().equals("")) {
    		alert2.setTitle("회원가입");
    		alert2.setHeaderText(" 아이디를 입력해 주세요.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		return;
    	}
    	Boolean result1 = DAO_Member.mdao.id_duplicat(id);
    	if(result1) {
    		try {
    			Stage stage = new Stage();
    			Parent parent = FXMLLoader.load(getClass().getResource("/view/login/duplicat.fxml"));
    			Scene scene = new Scene(parent);
    			stage.setScene(scene);
    			stage.show();
    		} catch (IOException e) {
    			System.out.println("Main 알림창 열기 실패"+ e); 
    		}
    		return;
    	}
    	else {
    		Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setHeaderText(id+" 를 사용하시겠습니다?");
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
    	txtid.setText(Duplicat.id2);
    }
    @FXML
    void signup(ActionEvent event) {
    	
    	Alert alert2 = new Alert(AlertType.INFORMATION);
    	
    	System.out.println("회원가입");
    	id = txtid.getText();
    	String pw = txtpw.getText();
    	String pwcheck = txtpwconfirm.getText();
    	String name = txtname.getText();
    	String email = txtemail.getText();
    	String phone = txtphone.getText();
    	String address = txtaddress.getText();
    	int member_grade = 0;
    	
    	Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$");
		Matcher passMatcher1 = passPattern1.matcher(pw);
		Pattern passPattern2 = Pattern.compile("(\\w)\\1\\1\\1");
		Matcher passMatcher2 = passPattern2.matcher(pw);
		
		if(id_check == false) {
			alert2.setTitle("회원가입");
    		alert2.setHeaderText("아이디 중복체크를 하세요.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtid.requestFocus();
    		return;
		}
		
		if (pw.equals("")) {
			alert2.setTitle("회원가입");
    		alert2.setHeaderText("비밀번호를 입력하세요");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtpw.requestFocus();
    		return;
		}
		if(!passMatcher1.find()){
			alert2.setTitle("회원가입");
    		alert2.setHeaderText("비밀번호는 영문과 특수문자 숫자를 포함하며 8자 이상이어야 합니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtpw.requestFocus();
			return;
		}
		if(passMatcher2.find()){
			alert2.setTitle("회원가입");
    		alert2.setHeaderText("비밀번호에 동일한 문자를 과도하게 연속해서 사용할 수 없습니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtpw.requestFocus();
			return;
		}
		if(pw.contains(id)){
		    alert2.setTitle("회원가입");
    		alert2.setHeaderText("비밀번호에 아이디가 포함되어있습니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtpw.requestFocus();
		    return;
		}
		if(pw.contains(" ")){
		    alert2.setTitle("회원가입");
    		alert2.setHeaderText("비밀번호에 공란이 포함되어있습니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtpw.requestFocus();
		    return;
		}
		
		if(pwcheck.equals("")) {
			alert2.setTitle("회원가입");
    		alert2.setHeaderText("비밀번호를 재입력해주세요.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtpwconfirm.requestFocus();
		}
		if(!pw.equals(pwcheck)) {
			alert2.setTitle("회원가입");
    		alert2.setHeaderText("비밀번호가 다릅니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtpw.requestFocus();
		    return;
		}
		
		String regExp_symbol = "(.*[!,@,#,^,&,*,(,)])|([!,@,#,^,&,*,(,)].*)";
		Pattern pattern_symbol = Pattern.compile(regExp_symbol);
		Matcher matcher_symbol = pattern_symbol.matcher(name);
		
		if(name.equals("")) {
			alert2.setTitle("회원가입");
    		alert2.setHeaderText("이름을 입력해주세요.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtname.requestFocus();
    		return;
		}
		if(matcher_symbol.find()){
			alert2.setTitle("회원가입");
    		alert2.setHeaderText("이름에 특수문자를 포함할수 없습니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtname.requestFocus();
    		return;
		}
		if(name.contains(" ")){
		    alert2.setTitle("회원가입");
    		alert2.setHeaderText("이름에 공란이 포함되어있습니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtname.requestFocus();
    		return;
		}
		
		Pattern pattern = Pattern.compile("\\d{3}-\\d{4}-\\d{4}");
		Matcher matcher = pattern.matcher(phone);
		
		if(phone.contains("-")) {
			if(phone.length() == 13) {}
			else {
				alert2.setTitle("회원가입");
	    		alert2.setHeaderText("올바르지 않은 전화번호 형식입니다.");
	    		alert2.setContentText("확인");
	    		alert2.showAndWait();
	    		txtphone.requestFocus();
	    		return;
			}
		}
		else {
			if(phone.length() == 11) {}
			else {
				alert2.setTitle("회원가입");
	    		alert2.setHeaderText("올바르지 않은 전화번호 형식입니다.");
	    		alert2.setContentText("확인");
	    		alert2.showAndWait();
	    		txtphone.requestFocus();
	    		return;
			}
		}
		if (matcher.matches()) {
	    } 
	    else if(!matcher.matches() &&  phone.length() == 11){
	    	String str1 = phone.substring(0, 3);
            String str2 = phone.substring(3, 7);
            String str3 = phone.substring(7, 11);
            phone = str1+"-"+str2+"-"+str3;
            txtphone.setText(phone);
	    }
    	
		boolean p_result = DAO_Member.mdao.phone_duplicat(phone);
		if(p_result) {
			alert2.setTitle("회원가입");
    		alert2.setHeaderText(" 이미 등록된 전화번호 입니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtphone.requestFocus();
    		return;
		}
		
		if(email.equals("")) {
			alert2.setTitle("회원가입");
    		alert2.setHeaderText("이메일을 입력해주세요.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtemail.requestFocus();
    		return;
		}
		if(email.indexOf("@") == -1) {
			alert2.setTitle("회원가입");
    		alert2.setHeaderText("올바르지 않는 이메일 형식입니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtemail.requestFocus();
    		return;
    	}
		boolean e_result = DAO_Member.mdao.email_duplicat(email);
		if(e_result) {
			alert2.setTitle("회원가입");
    		alert2.setHeaderText(" 이미 등록된 이메일 입니다.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtemail.requestFocus();
    		return;
		}
		if(address.equals("")) {
			alert2.setTitle("회원가입");
    		alert2.setHeaderText("주소를 입력해주세요.");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtaddress.requestFocus();
    		return;
		}
		if(!address.contains("시") && ( address.contains("동") || address.contains("로"))) {
			alert2.setTitle("회원가입");
    		alert2.setHeaderText("시와 동을 입력해주세요 ( 도로명은 \'로\'를 포함시켜주세요");
    		alert2.setContentText("확인");
    		alert2.showAndWait();
    		txtaddress.requestFocus();
    		return;
    	}
		
		String since = sdf.format(new Date());
		
		if(otp_normal.isSelected()) {
			member_grade = 0;
    	}
    	else if(otp_diller.isSelected()){
    		member_grade = 1;
    	}
		
		DTO_Member member = new DTO_Member(0, id, pw, name, email,since, phone, address, "yyyy-MM-dd",member_grade);
		boolean result =  DAO_Member.mdao.registration(member);
		if(result) {
			if(member_grade == 0) {
				alert2.setTitle("회원가입");
	    		alert2.setHeaderText("회원가입이 완료 되었습니다.");
	    		alert2.setContentText("확인");
	    		alert2.showAndWait();
	    		Main.main.loadpage("/view/login/login");
	    		pass = false;
			}
			else if (member_grade == 1) {
				alert2.setTitle("회원가입");
	    		alert2.setHeaderText("딜러 회원가입이 완료 되었습니다.");
	    		alert2.setContentText("확인");
	    		alert2.showAndWait();
	    		Main.main.loadpage("/view/login/login");
	    		pass = false;
			}
		}
    }
	public void input() {
		if(Duplicat.id2 != null) {
			txtid.setText(Duplicat.id2);
			id_check = true;
			txtid.setDisable(true);
		}
		System.out.println(1);
    	
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {	
		Thread thread = new Thread() { // 채팅방 목록 실시간 화면 처리
			@Override
			public void run() {
				while( pass ) { 
					try {
						 input();
						Thread.sleep(1000);
					}catch( Exception e ) {} 
				}
			}
		}; 
		thread.start();
		
	}
}
