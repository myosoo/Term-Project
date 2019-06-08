package application;
 
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class Selcontroller implements Initializable {
	@FXML
	private Button sel;
	@FXML
	private ComboBox<String> com1;
	@FXML
	private ComboBox<String> com2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// 다음 화면 이동  화면전환 
		sel.setOnAction(event -> selectcontroller(event));
	}

	public void selectcontroller(ActionEvent event) {
		int player, count;
		Boardgame playgame = new Boardgame();
		try {
			player = Integer.parseInt(com1.getValue());
			count = Integer.parseInt(com2.getValue());
			playgame.setnumber(player, count);
			Parent game = FXMLLoader.load(getClass().getResource("boardgame.fxml"));
			Scene scene = new Scene(game);
			Stage primaryStage = (Stage) sel.getScene().getWindow();
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}