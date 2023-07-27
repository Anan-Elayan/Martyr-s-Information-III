package UI;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Warning extends VBox {
	
	//Data Filed
	private Button ok;
	private Stage primaryStage;

	
	public Warning(String msg) {

		setAlignment(Pos.CENTER);
		Label label = new Label(msg);
		Font font = Font.font(20);
		label.setFont(font);
		ok = new Button("ok");
		ok.setStyle("-fx-font-size:15");
		ok.setMinWidth(30);
		ok.setMinHeight(30);
		getChildren().addAll(label, ok);

		ok.setOnAction(e->{
			primaryStage.close();
		});

		primaryStage = new Stage();
		primaryStage.setScene(new Scene(this, 400, 150));
		primaryStage.setTitle("warning");
		primaryStage.show();

	}
}
