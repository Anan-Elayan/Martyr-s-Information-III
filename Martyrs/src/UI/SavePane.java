package UI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import AVL_Names.Node;
import Project.Functions;
import Project.NodeDoubleLinkedList;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.DirectoryChooser;

public class SavePane extends Pane {

	private TextField txtpath = new TextField();
	private Button btnActionSave = new Button("Save");

	public SavePane() {
		txtpath.setPromptText("File Name");
		if (btnActionSave.isVisible() == false || txtpath.isVisible() == false) {
			btnActionSave.setVisible(true);
			txtpath.setVisible(true);
		}

		btnActionSave.setLayoutX(120);
		btnActionSave.setPrefWidth(280);
		btnActionSave.setLayoutY(200);
		btnActionSave.setStyle(
				"-fx-background-color:black;-fx-border-color:white;-fx-text-fill:f2bd12;-fx-border-radius:15;-fx-background-radius:15");
		txtpath.setLayoutX(80);
		txtpath.setLayoutY(150);
		txtpath.setPrefWidth(370);

		btnActionSave.setOnAction(e -> {
			if (txtpath.getText().trim().isEmpty()) {
				new Warning("Set file name before save it");
				return;
			}
			Functions.Save_to_File(txtpath.getText());

		});

		this.getChildren().addAll(txtpath, btnActionSave);
	}
}
