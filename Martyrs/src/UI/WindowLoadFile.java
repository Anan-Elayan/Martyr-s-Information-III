package UI;

import Project.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import AVL2_DATES.Martyrs;
import AVL_Names.AVL_Names;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class WindowLoadFile extends Pane {

	static File chooser;
	Pane leftPane = new Pane();
	Label lbl1;
	Label lbl2;
	Label lbl3;
	Label lbl4;
	Button btnLoadFile;
	Font font = Font.font("Arial Black", FontPosture.REGULAR, 33);
	FileChooser fileChooser = new FileChooser();
	Scene newScene;
	Stage mainStage;
	Scene scene;

	public WindowLoadFile(Stage primaryStage) {

		// first window
		this.setStyle("-fx-background-color:black");

		// left side
		leftPane.setStyle("-fx-background-color:white;-fx-background-radius:0 30 30 0");
		leftPane.setLayoutX(1);
		leftPane.setLayoutY(-1);
		leftPane.setPrefHeight(500);
		leftPane.setPrefWidth(211);
		Image image = new Image("map.png");
		ImageView imgView = new ImageView(image);
		imgView.setFitHeight(201);
		imgView.setFitWidth(194);
		imgView.setLayoutX(9);
		imgView.setLayoutY(100);
		leftPane.getChildren().add(imgView);

		// Right side
		Image palMap = new Image("PalMap.png");
		ImageView palMapView = new ImageView(palMap);
		palMapView.setFitHeight(300);
		palMapView.setFitWidth(164);
		palMapView.setLayoutX(525);
		palMapView.setLayoutY(90);

		// Labels
		lbl1 = new Label("How Many");
		lbl1.setStyle("-fx-text-fill:white");
		lbl1.setFont(font);
		lbl1.setPrefHeight(53);
		lbl1.setPrefWidth(280);
		lbl1.setLayoutX(250);
		lbl1.setLayoutY(90);

		lbl2 = new Label("Palestinians");
		lbl2.setStyle("-fx-text-fill:white");
		lbl2.setFont(font);
		lbl2.setPrefHeight(39);
		lbl2.setPrefWidth(280);
		lbl2.setLayoutX(250);
		lbl2.setLayoutY(131);

		lbl3 = new Label("who were killed");
		lbl3.setStyle("-fx-text-fill:white");
		lbl3.setFont(font);
		lbl3.setPrefHeight(36);
		lbl3.setPrefWidth(300);
		lbl3.setLayoutX(250);
		lbl3.setLayoutY(162);

		lbl4 = new Label("because Israel?");
		lbl4.setStyle("-fx-text-fill:white");
		lbl4.setFont(font);
		lbl4.setPrefHeight(37);
		lbl4.setPrefWidth(300);
		lbl4.setLayoutX(250);
		lbl4.setLayoutY(200);

		btnLoadFile = new Button("Load File Martyrs");
		btnLoadFile.setStyle(
				"-fx-background-color:black;-fx-border-color:white;-fx-background-radius:10 50 10 50;-fx-border-radius:10 50 10 50;-fx-text-fill:f2bd12");
		font = Font.font("Arial Black", FontPosture.REGULAR, 17);
		btnLoadFile.setFont(font);
		btnLoadFile.setPrefHeight(37);
		btnLoadFile.setPrefWidth(202);
		btnLoadFile.setLayoutX(250);
		btnLoadFile.setLayoutY(250);
		MainWindow mainScene = new MainWindow();
		newScene = new Scene(mainScene, 700, 500);

		// action to load file martyrs
		btnLoadFile.setOnAction(e -> {
			chooser = fileChooser.showOpenDialog(primaryStage);
			Scanner input;
			SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");
			try {
				input = new Scanner(chooser);
				int count = 1;
//				NodeDoubleLinkedList node = null;
				while (input.hasNextLine()) {

					try {
						String line = input.nextLine();
						String[] info = line.split(",");
						int age = 0;
						if (!info[1].isEmpty()) {
							age = Integer.parseInt(info[1]);// Because their is some name without age
						}
						String name = info[0].trim();
						String location = info[2].trim();
						Date date = format.parse(info[3]);
						char gender = info[4].charAt(0);
						String status = info[5];
						Martyrs martyrs = new Martyrs(name, age, date, gender, status);

						NodeDoubleLinkedList nodee = Functions.data.search(location);

						if (nodee == null) {
							Functions.Insert_New_Location(location);

						}

					} catch (Exception X) {
						new Warning("Invalid Record formats in line" + count);
					}
					count++;
				}
			}

			catch (FileNotFoundException e1) {
			}
			mainStage = new Stage();
			this.mainStage = primaryStage;
			mainStage.setScene(newScene);

		});

		getChildren().addAll(leftPane, palMapView, lbl1, lbl2, lbl3, lbl4, btnLoadFile);
		scene = new Scene(this, 700, 500);
		primaryStage.setTitle("Martyrs Info");
		primaryStage.setScene(scene);
		primaryStage.getIcons().add(new Image("map.png"));
		/// Name,Age,Event location - District,Date of death,Gender
		primaryStage.show();

	}

}
