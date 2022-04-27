package control.car;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import control.Main;
import control.login.Login;
import dao.DAO_Car;
import dto.DTO_Car;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private RadioButton optmission2;

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
    	int c_category = 0;
    		if(optcarcate1.isSelected()) { c_category = 1; }
    		if(optcarcate2.isSelected()) { c_category = 2; }
    		if(optcarcate3.isSelected()) { c_category = 3; }
    		if(optcarcate4.isSelected()) { c_category = 4; }
    		if(optcarcate5.isSelected()) { c_category = 5; }
    		if(optcarcate6.isSelected()) { c_category = 6; }
    		if(optcarcate7.isSelected()) { c_category = 7; }
    		if(optcarcate8.isSelected()) { c_category = 8; }
    	int c_price = Integer.parseInt( txtprice.getText());
    	String c_cnumber = txtcnumber.getText();
    	int c_view = 0 ; 
    	int c_condition = 0;
    		if (optcondition1.isSelected()) { c_condition = 1; }
    		if (optcondition2.isSelected()) { c_condition = 2; }
    	int c_km = Integer.parseInt( txtkm.getText());
    	int c_fuel = 0;
    		if (optfuel1.isSelected()) { c_fuel = 1; }
    		if (optfuel2.isSelected()) { c_fuel = 2; }
    		if (optfuel3.isSelected()) { c_fuel = 3; }
    		if (optfuel4.isSelected()) { c_fuel = 4; }
    		if (optfuel5.isSelected()) { c_fuel = 5; }
    	int c_mission = 0;
    		if (optmission1.isSelected()) { c_mission = 1; }
    		if (optmission2.isSelected()) { c_mission = 2; }
    	String c_com = txtcompany.getText();
    	String c_year = txtcaryear.getText();
    	int m_number = Login.member.getM_number();
    	
    	//2.객체화 
    	DTO_Car car = new DTO_Car(0, c_title, c_content, null, c_img, c_category, c_price, c_cnumber, c_view, c_condition, c_km, c_fuel, c_mission, c_com, c_year, m_number);
    	//3.DB처리
    	boolean result = DAO_Car.dao_Car.add(car);
    	if (result) {
			Alert alert = new Alert(AlertType.INFORMATION);
				alert.setHeaderText("등록 완료");
				alert.showAndWait();
				Main.main.loadpage("/view/home");
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("등록 실패");
			alert.showAndWait();
		}
    }

    @FXML
    void accback(ActionEvent event) {
    	Main.main.loadpage("/view/home");
    }
    
    private String c_img = null;
    
    @FXML
    void accimgadd(ActionEvent event) {

    	FileChooser chooser = new FileChooser();
    	
    	chooser.getExtensionFilters().add(new ExtensionFilter("이미지파일:image file", "*png", "*jpg", "*gif","*jpeg"));

    	File file = chooser.showOpenDialog(new Stage());
    	
    	c_img = file.toURI().toString();

    	Image image = new Image( c_img );
    	img.setImage(image);

    	try {

    		FileInputStream inputStream = new FileInputStream(file);
    		//C:\Users\504\git\Team3_04-13\Team3\src
    		File copyfile = new File("C:/a/" +file.getName() );
    		FileOutputStream outputStream = new FileOutputStream(copyfile);
    		
    		byte[] bytes = new byte[1024*1024*1024];

    		int size;
    		while ((size = inputStream.read(bytes)) > 0) {
				outputStream.write(bytes, 0, size);
			}

    		inputStream.close();
    		outputStream.close();

    		c_img = copyfile.toURI().toString();
		} catch (Exception e) {
			System.out.println("파일 오류 "+ e);
		}
    	
    }
	
}