package control;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import control.car.Caradd;
import dao.DAO_Car;
import dto.DTO_Car;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

public class Record_view implements Initializable {

	@FXML
	private BarChart total_barchart;
	
	@FXML
    private BarChart category_view_barchart;
	
	  @FXML
	    private PieChart piecahrt;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		//날짜별 등록매물수? 막대차트
		XYChart.Series series = new XYChart.Series<>();
		
		Map<String, Integer> map = DAO_Car.dao_Car.datetotal("car", "c_date");
		
		for(String key : map.keySet()) {
			XYChart.Data data = new XYChart.Data<>(key, map.get(key));
			series.getData().add(data);
			
		}
		total_barchart.getData().add(series);
		
		//카테고리별 조회수 막대차트
		XYChart.Series series2 = new XYChart.Series<>();
		
	
		Map<String, Integer> map2 = DAO_Car.dao_Car.datetotal2();
		
		for(String key : map2.keySet()) {
			XYChart.Data data = new XYChart.Data<>(key, map2.get(key));
			series2.getData().add(data);
			
		}
		
		category_view_barchart.getData().add(series2);
		
		//카테고리별 조회수 원형차트
		ObservableList<PieChart.Data> list = FXCollections.observableArrayList();
		
		Map<String, Integer> map3 = DAO_Car.dao_Car.category_view_piechart();
		
		for(String key : map3.keySet()) {
			
			PieChart.Data temp = new PieChart.Data(key, map3.get(key));
			
			list.add(temp);
			
		}
		
		piecahrt.setData(list);
		
		
	}
	
}
