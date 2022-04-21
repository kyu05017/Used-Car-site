package control.car;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import dao.DAO_Car;
import dto.DTO_Car;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Carlist implements Initializable{
	
	public static DTO_Car select ;
	
	@FXML
    private ScrollPane scrollpane;

    @FXML
    private VBox vbox;
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		show();
	}
	
    void show() {
    	
    	ArrayList<DTO_Car> carlist = DAO_Car.dao_Car.list();
    	
    	if( vbox.getChildren().isEmpty() == false) { //isEmpty()  비어있을 경우를 확인 [ vbox내 비어있느지 확인 ]
    		// vbox 내 객체가 비어있지 않으면
    		vbox.getChildren().remove(0); // vbox
    	}
    	// 1. 모든 제품 가져오기
		
		
		for(DTO_Car car : carlist) {
			System.out.println("중고차 불러오기");
			System.out.println(car.getC_title());
		}
		// 2. 그리드 클래스 [ 행/열 ]
		GridPane gridPane = new GridPane();
			// * 그리드 여백
			gridPane.setPadding( new Insets(10) );
			// * 그리드내 셀 여백 
			gridPane.setHgap(20); // 세로여백 
			gridPane.setVgap(20); // 가로여백

		int i = 0 ; // 인덱스용 변수
		for( int row = 0 ; row < carlist.size(); row++ ) { // 행
				// 1. 이미지
				ImageView imageView = new ImageView( new Image( carlist.get(i).getC_img()) );
					// *이미지 사이즈 
					imageView.setFitWidth(100);		// 이미지 가로길이 
					imageView.setFitHeight(100); 	// 이미지 세로길이
				// 2. 버튼 생성 ( 버튼에 이미지 넣기 )
				Button button = new Button( null , imageView );
					// *버튼 배경제거 [ transparent : 투명색 ]
					button.setStyle("-fx-background-color:transparent");
					// *버튼 id값넣기 [ 제품 식별 = index ]
					button.setId( i+"");
					// *버튼 클릭이벤트
						//	button.setOnAction( e -> { } ); // 람다식 : 인수 -> { 실행코드 }
					button.setOnAction( e -> { 
						// 1. 클릭한 버튼의 id 가져오기
						int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2] );
						// 2. 클릭한 제품 번호 저장 
						select = carlist.get(id);
					} );	
				gridPane.add( button  , 0, row); // 그리드내  해당 열번호 , 행번호 에 버튼 추가
				i++; //인덱스 증가
		}
		// 4. vbox에 그리도 넣기 
		vbox.getChildren().add(gridPane);
    		
    }
    
}