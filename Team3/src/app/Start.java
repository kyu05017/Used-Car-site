package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Start extends Application{
	@Override
	public void start(Stage stage) throws Exception {
		Parent parent = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
		Scene scene = new Scene(parent);
		Image image = new Image("img/logo2.png"); 
		stage.getIcons().add(image);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
