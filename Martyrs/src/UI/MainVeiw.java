package UI;

import Project.Functions;
import Project.NodeDoubleLinkedList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainVeiw extends Pane {
	Pane pkGround;
	Pane lftPane = new Pane();
	VBox vbox = new VBox(15);
	Button btnLocation = new Button("Location");
	Button btnStatistic = new Button("Statsitc");
	Button btnSave = new Button("Save");
	Button btnSammary = new Button("Sammary");

	Label lblLocatione = new Label("Locatione");
	private String btnStyle = "-fx-background-color:black;-fx-text-fill:f2bd12;-fx-border-radius:15;-fx-background-radius:15";

	public MainVeiw() {

		pkGround = this;

		lftPane.setStyle("-fx-background-color:white;-fx-background-radius:0 30 30 0");
		lftPane.setPrefHeight(500);
		lftPane.setPrefWidth(200);
		vbox.setPrefHeight(347);
		vbox.setPrefWidth(159);
		vbox.setLayoutX(14);
		vbox.setLayoutY(8);
		vbox.setAlignment(Pos.CENTER);
		vbox.setSpacing(55);
		vbox.setPadding(new Insets(40, 0, 0, 0));

		btnLocation.setStyle(btnStyle);

		btnLocation.setPrefHeight(50);
		btnLocation.setPrefWidth(110);

		btnStatistic.setStyle(btnStyle);

		btnStatistic.setPrefHeight(50);
		btnStatistic.setPrefWidth(110);
		btnSave.setStyle(btnStyle);
		btnSave.setPrefHeight(50);
		btnSave.setPrefWidth(110);
		
		btnSammary.setPrefHeight(50);
		btnSammary.setPrefWidth(110);
		btnSammary.setStyle(btnStyle);
		btnSammary.setPrefHeight(50);
		btnSammary.setPrefWidth(110);

		vbox.getChildren().addAll(btnLocation, btnStatistic, btnSave,btnSammary);
		lftPane.getChildren().add(vbox);

		this.setStyle("-fx-background-color:black");// background
		Pane p = new Pane();

		p.setMinSize(500, 500);
		p.setLayoutX(200);

		btnLocation.setOnAction(e -> {
			p.getChildren().clear();
			p.getChildren().add(new LocationPane());// return scene location (scene)
		});

		btnStatistic.setOnAction(e -> {
			if (LocationPane.txtLocation.getText().trim().isEmpty()) {// name location is empty
				new Warning("Set location name in location tab");
				return;
			}
			NodeDoubleLinkedList loc = Functions.data.search(LocationPane.txtLocation.getText());
			if (loc == null) { // not exit location
				new Warning(LocationPane.txtLocation.getText() + " not exists");
				return;
			}

			p.getChildren().clear(); // clear pane
			p.getChildren().add(new StaticticsPane(loc)); // Return page (scene) Statistic
		});

		btnSave.setOnAction(e -> {// to save data at file
			p.getChildren().clear();
			p.getChildren().add(new SavePane()); // return scene save to file
		});
		
		btnSammary.setOnAction(e->{
			p.getChildren().clear();
			p.getChildren().add(new SammaryView());

		});

		pkGround.getChildren().addAll(lftPane, p);

	}

}
