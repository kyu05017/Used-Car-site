package control;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import dao.DAO_Car;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;

public class Record_view implements Initializable {

	@FXML
	private BarChart total_barchart;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		XYChart.Series series = new XYChart.Series<>();
		
		Map<String, Integer> map = DAO_Car.dao_Car.datetotal("car", "c_date");
		
		for(String key : map.keySet()) {
			XYChart.Data data = new XYChart.Data<>(key, map.get(key));
			series.getData().add(data);
			
		}
		total_barchart.getData().add(series);
	}
	
}
