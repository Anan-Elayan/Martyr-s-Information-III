package UI;

import javafx.application.Application;
import javafx.stage.Stage;

public class DriverUI extends Application {
	WindowLoadFile objGUI;

	@Override
	public void start(Stage MainStage) throws Exception {
		// First Window
		objGUI = new WindowLoadFile(MainStage);
		MainStage.setResizable(false);
		MainStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
