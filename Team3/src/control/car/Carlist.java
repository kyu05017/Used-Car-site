package control.car;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

import control.Home;
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
	
	public static Carlist carlist;

	public Carlist(){carlist = this;}
	
	@FXML
    private ScrollPane scrollpane;

    @FXML
    private VBox vbox;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		show(null);
	}
	
    public void show(String search) {
    	
    	ArrayList<DTO_Car> carlist = DAO_Car.dao_Car.list(search);
    	
    	if( vbox.getChildren().isEmpty() == false) { 
    	
    		vbox.getChildren().remove(0);
    	}

		for(DTO_Car car : carlist) {
			System.out.println("중고차 불러오기");
			System.out.println(car.getC_title());
		}
		GridPane gridPane = new GridPane();
			gridPane.setPadding( new Insets(20) );
			gridPane.setHgap(200); 
			gridPane.setVgap(20); 
		int i = 0 ;
		for( int row = 0 ; row < carlist.size(); row++ ) {
			ImageView imageView = new ImageView( new Image( carlist.get(i).getC_img()) );
			imageView.setFitWidth(200);
			imageView.setFitHeight(100); 
			DecimalFormat df = new DecimalFormat("#,##0원");
			String new_price = df.format(carlist.get(i).getC_price());
			Button button = new Button("차량명 : "+ carlist.get(i).getC_title() + "               가격 : "+ new_price + " | 주행거리 : " + carlist.get(i).getC_km() + "km |  연식 : "+ carlist.get(i).getC_year()+"년", imageView );
			button.setStyle("-fx-background-color:transparent");
			button.setId( i+"");
			button.setOnAction( e -> { 
				
				int id = Integer.parseInt(e.toString().split(",")[0].split("=")[2] );
				select = carlist.get(id);
				DAO_Car.dao_Car.view(select.getC_number(), select.getC_view());
				Home.home.loadpage("/view/car/carview");
			} );	
			gridPane.add( button  , 0, row); 
			i++;
		}
		vbox.getChildren().add(gridPane);
    		
    }
    
}