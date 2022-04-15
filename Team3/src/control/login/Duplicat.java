package control.login;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import dao.DAO_Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class Duplicat implements Initializable{
	
	@FXML
	private TextField txt_newid;
	
	@FXML
	private Button bt_newid;
	
	public TextField new_id = txt_newid;

	@FXML
	void use_id(ActionEvent event) {
		Alert alert2 = new Alert(AlertType.INFORMATION);
    	String id = txt_newid.getText();
    	if(txt_newid.getText().equals("")) {
    		alert2.setTitle("ȸ������");
    		alert2.setHeaderText(" ���̵� �Է��� �ּ���.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		return;
    	}
    	Boolean result1 = DAO_Member.mdao.id_duplicat(id);
    	if(result1) {
    		alert2.setTitle("ȸ������");
    		alert2.setHeaderText("�ߺ��� ���̵� �Դϴ�.");
    		alert2.setContentText("Ȯ��");
    		alert2.showAndWait();
    		return;
    	}
    	else {
    		Alert alert = new Alert(AlertType.CONFIRMATION); // Ȯ��,��� ��ư Ÿ��
    		alert.setHeaderText(id+" �� ����Ͻðڽ��ϴ�?");
    		// 2. ��ư Ȯ�� [ Optional Ŭ���� ]
    		Optional<ButtonType> optional = alert.showAndWait();
    		if(optional.get() == ButtonType.OK) { 
    			txt_newid.setText(id);
    			new_id.setText(id);
    		}
    		else {
    			txt_newid.setText("");
    			return;
    		}
    	}
    }
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
	}
}