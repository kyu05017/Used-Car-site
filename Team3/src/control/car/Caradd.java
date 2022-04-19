package control.car;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.cj.protocol.FullReadInputStream;

import control.Home;
import control.Main;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;


public class Caradd implements Initializable{
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
    @FXML
    private TextField txtcnumber;

    @FXML
    private Button btnimg;

    @FXML
    private Button btnadd;

    @FXML
    private Button btnback;

    @FXML
    private ImageView img;

    @FXML
    private RadioButton optcarcate1;

    @FXML
    private ToggleGroup category;

    @FXML
    private RadioButton optcarcate2;

    @FXML
    private RadioButton optcarcate3;

    @FXML
    private RadioButton optcarcate4;

    @FXML
    private RadioButton optcarcate5;

    @FXML
    private RadioButton optcarcate6;

    @FXML
    private RadioButton optcarcate7;

    @FXML
    private RadioButton optcarcate8;

    @FXML
    private TextField txtcompany;

    @FXML
    private TextField txtcaryear;

    @FXML
    private TextField txtkm;

    @FXML
    private RadioButton optcondition1;

    @FXML
    private ToggleGroup condition;

    @FXML
    private RadioButton optcondition2;

    @FXML
    private RadioButton optmission1;

    @FXML
    private ToggleGroup mission;

    @FXML
    private TextField txtprice;

    @FXML
    private RadioButton optfuel1;

    @FXML
    private ToggleGroup fuel;

    @FXML
    private RadioButton optfuel2;

    @FXML
    private RadioButton optfuel3;

    @FXML
    private RadioButton optfuel4;

    @FXML
    private RadioButton optfuel5;

    @FXML
    private TextField txttitle;

    @FXML
    private TextArea txtcontent;

    @FXML
    void accadd(ActionEvent event) {
    	
    	//1.컨트롤에 입력된 데이터 가져오기
    	String c_title = txttitle.getText();
    	String c_content = txtcontent.getText();
    	String c_img;
    	int c_category;
    	int c_price;
    	String c_cnumber = txtcnumber.getText();
    	int c_view; 
    	int c_condition;
    	int c_km;
    	int c_fuel;
    	int c_mission;
    	String c_com = txtcompany.getText();
    	String c_year = txtcaryear.getText();
    	int m_number;
    	//2.객체화
    	
    	//3.DB처리
    }

    @FXML
    void accback(ActionEvent event) {
    	Main.main.loadpage("/view/home");
    }

    @FXML
    void accimgadd(ActionEvent event) {
    	//파일 선택
    	FileChooser chooser = new FileChooser();
    	
    	chooser.getExtensionFilters().add(new ExtensionFilter("이미지파일:image file", "*png", "*jpg", "*gif"));
    	//새로운 스테이지
    	File file = chooser.showOpenDialog(new Stage());
    	
    	c_img = file.toURI().toString();
    	//이미지 미리보기
    	Image image = new Image(c_img);
    	img.setImage(image);
    	//선택함 파일 현재 프로젝트 폴더로 복사해오기
    	
    }
	
}
