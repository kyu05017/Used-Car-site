package control.car;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.Optional;
import java.util.ResourceBundle;

import control.Main;
import dao.DAO_Car;
import dto.DTO_Car;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;


public class Carview implements Initializable {
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		//선택된 객체 호출
		DTO_Car car = Carlist.select;
		
		//각 컨트롤에 값 넣기
		img.setImage(new Image(car.getC_img())); //자동차 이미지 가져와서 넣기
		txttitle.setText(car.getC_title()); //등록한 제목 가져오기
		txtcontent.setText(car.getC_content()); //등록한 내용 가져오기
		
		//입력값 불러오기
//		txtprice.setText(car.getC_price()); int값 가져오기
//		txtkm.set(car.getC_km());

		txtcnumber.setText(car.getC_cnumber());
		txtcompany.setText(car.getC_com());
		txtcaryear.setText(car.getC_year());
		
		
		
		//라디오 버튼 눌린 상태로 만들기	
		if(optcarcate1.isSelected()) { //첫번째 번튼 선택 시 해당 값 호출
			optcarcate1.setSelected(true);
			} else if(optcarcate2.isSelected()) { //두번째 버튼 선택 시 해당 값 호출
				optcarcate2.setSelected(true);
			} else if(optcarcate3.isSelected()) { 
				optcarcate3.setSelected(true);
			} else if(optcarcate4.isSelected()) { 
				optcarcate4.setSelected(true);
			} else if(optcarcate5.isSelected()) { 
				optcarcate5.setSelected(true);
			} else if(optcarcate6.isSelected()) { 
				optcarcate6.setSelected(true);
			} else if(optcarcate7.isSelected()) { 
				optcarcate7.setSelected(true);
			} else { optcarcate8.setSelected(true);}
		//이 코드가 맞는지 확인필요
		//토글그룹안에넣기
		
	} //initialize end
	

    @FXML
    private TextField txtcnumber;

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
    private RadioButton optmission2;

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
    private Button btnupdate;

    @FXML
    private Button btndelete;

	    
	@FXML
	private Button btnsend;


	@FXML
	void accsend(ActionEvent event) { //문의

	}


    @FXML
    void accback(ActionEvent event) {
    	Main.main.loadpage("/view/car/carlist");
    }
 
    
    @FXML
    void accdelete(ActionEvent event) { //삭제
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    		alert.setHeaderText("제품을 삭제하시겠습니까?");
    	Optional<ButtonType> optional = alert.showAndWait();
    	
    	if(optional.get() == ButtonType.OK) { //만일 ok를 누르면
    	}
    	
    }


    @FXML
    void accupdate(ActionEvent event) { //수정

    }


}