package UI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import AVL2_DATES.Martyrs;
import AVL2_DATES.NodeStack;
import AVL_Names.AVL_Names;
import AVL_Names.Node;
import Project.Functions;
import Project.NodeDoubleLinkedList;
import Project.QueueList;
import Project.QueueListT;
import Project.QueueNodeT;
import Project.StackList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class StaticticsPane extends Pane {

	private TextArea txtArea = new TextArea();
	private Label lblLocatione = new Label("Locatione");
	private Button btnNext = new Button("Next");
	private Button btnPev = new Button("Privious");
	private Button btnPrintAVL1 = new Button("Print AVL 1");
	private Button btnPrintAVL2 = new Button("Print AVL 2");

	Pane orderPane = new Pane();
	private String btnStyle = "-fx-background-color:black;" + "-fx-border-color:white;"
			+ "-fx-background-radius:10 50 10 50;" + "-fx-border-radius:10 50 10 50;" + "-fx-text-fill:f2bd12";

	public StaticticsPane(NodeDoubleLinkedList nameLocation) {

		this.orderPane.setLayoutY(0);
		this.orderPane.setPrefWidth(600);
		this.orderPane.setPrefHeight(500);

		txtArea.clear();
		lblLocatione.setStyle("-fx-text-fill:cd9b05;-fx-font-size:15");

		lblLocatione.setText("Location: " + nameLocation.getLocation());

		NodeDoubleLinkedList[] locNode = { nameLocation };

		btnNext.setStyle(btnStyle);
		btnPev.setStyle(btnStyle);
		btnPrintAVL1.setStyle(btnStyle);
		btnPrintAVL2.setStyle(btnStyle);

		Font font = Font.font("Arial Black", FontPosture.REGULAR, 10);
		btnNext.setFont(font);
		btnPev.setFont(font);
		btnPrintAVL1.setFont(font);
		btnPrintAVL2.setFont(font);

		if (locNode[0].getAVL_Names().size() > 0) {
			NumberOfMartyrs(locNode[0], txtArea, null);
			getHeight(locNode[0], txtArea, null);

		} else {
			txtArea.appendText("\n No Martyrs: No Date was Found");
			txtArea.appendText("\n The height AVL tree 1 is : No Date was Found ");
		}
		if (locNode[0].getAVL_Dates().size() > 0) {
			getHeightTree2(locNode[0], txtArea, null);
		} else {
			txtArea.appendText("\n The height AVL tree 2 is : No Date was Found");
		}
		maxMartyrs(locNode[0], txtArea, null);

		btnNext.setOnAction(t -> {
			txtArea.clear();
			locNode[0] = locNode[0].getNext();
			lblLocatione.setText("Location: " + locNode[0].getLocation());
			if (locNode[0].getAVL_Names().size() > 0) {
				NumberOfMartyrs(locNode[0], txtArea, null);
				getHeight(locNode[0], txtArea, null);

			} else {
				txtArea.appendText("\n No Martyrs: No Date was Found");
				txtArea.appendText("\n The height AVL tree 1 is : No Date was Found ");
			}
			if (locNode[0].getAVL_Dates().size() > 0) {
				getHeightTree2(locNode[0], txtArea, null);
			} else {
				txtArea.appendText("\n The height AVL tree 2 is : No Date was Found");
			}
			maxMartyrs(locNode[0], txtArea, null);

		});

		btnPev.setOnAction(f -> {
			txtArea.clear();
			locNode[0] = locNode[0].getPrevious();
			lblLocatione.setText("Location: " + locNode[0].getLocation());
			if (locNode[0].getAVL_Names().size() > 0) {
				NumberOfMartyrs(locNode[0], txtArea, null);
				getHeight(locNode[0], txtArea, null);

			} else {
				txtArea.appendText("\n No Martyrs: No Date was Found");
				txtArea.appendText("\n The height AVL tree 1 is : No Date was Found ");
			}
			if (locNode[0].getAVL_Dates().size() > 0) {
				getHeightTree2(locNode[0], txtArea, null);
			} else {
				txtArea.appendText("\n The height AVL tree 2 is : No Date was Found");
			}
			maxMartyrs(locNode[0], txtArea, null);

		});

		btnPrintAVL1.setOnAction(e -> {
			txtArea.clear();
			QueueList queueListResule = Functions.printTree1LevelByLevel(locNode[0].getLocation());
			while (!queueListResule.isEmpty()) {
				txtArea.appendText(queueListResule.getFirst().getmartyrs().toString() + "\n \n");
				queueListResule.deQueue();
			}

		});
		btnPrintAVL2.setOnAction(e -> {
			txtArea.clear();
			StackList stackResule = Functions.printBackWord(locNode[0].getLocation());
			while (!stackResule.isEmpty()) {
				DateFormat format = new SimpleDateFormat("M/d/yyyy");
				txtArea.appendText("---" + format.format(stackResule.getTopItem().getDateStack().getDate()) + "---\n");

				NodeStack top = stackResule.getTopItem().getDateStack().getStack().getTopItem();
				while (top != null) {
					txtArea.appendText(top.getOrder().toString() + "\n");

					top = top.getNext();

				}
				stackResule.pop();
			}
		});

		lblLocatione.setLayoutX(27);
		lblLocatione.setLayoutY(30);

		btnPev.setPrefHeight(27);
		btnPev.setPrefWidth(102);
		btnPev.setLayoutX(23);
		btnPev.setLayoutY(90);

		btnNext.setPrefHeight(27);
		btnNext.setPrefWidth(102);
		btnNext.setLayoutX(420);
		btnNext.setLayoutY(90);

		btnPrintAVL1.setPrefHeight(27);
		btnPrintAVL1.setPrefWidth(102);
		btnPrintAVL1.setLayoutX(23);
		btnPrintAVL1.setLayoutY(460);

		btnPrintAVL2.setPrefHeight(27);
		btnPrintAVL2.setPrefWidth(102);
		btnPrintAVL2.setLayoutX(420);
		btnPrintAVL2.setLayoutY(460);

		txtArea.setPrefHeight(320);
		txtArea.setPrefWidth(490);
		txtArea.setLayoutY(130);
		txtArea.setLayoutX(27);
		txtArea.setEditable(false);

		this.orderPane.getChildren().addAll(txtArea, btnNext, btnPev, btnPrintAVL1, btnPrintAVL2, lblLocatione);
		this.getChildren().add(this.orderPane);// txtArea, btnNext, btnPev
	}

	public static void NumberOfMartyrs(NodeDoubleLinkedList nodeDouble, TextArea txtArea, Sammary sammary) {

		int count = Functions.getNoMartyrs(nodeDouble.getLocation());
		if (txtArea != null) {
			txtArea.appendText("\n No Martyrs " + count);
		}
	}

	public static void TraverseLevelByLevel(NodeDoubleLinkedList nodeDouble, TextArea txtArea, Sammary sammary) {
		if (txtArea != null) {
			txtArea.appendText(
					"\n Traverse tree level by level " + Functions.printTree1LevelByLevel(nodeDouble.getLocation()));
		}
	}

	public static void getHeight(NodeDoubleLinkedList nodeDouble, TextArea txtArea, Sammary sammary) {
		int temp = Functions.getHeightAVL1(nodeDouble.getAVL_Names().getRoot());
		if (txtArea != null) {
			txtArea.appendText("\n The height AVL tree 1 is : " + temp);
		}
	}

	public static void traverseBackword(NodeDoubleLinkedList nodeDouble, TextArea txtArea, Sammary sammary) {
		if (txtArea != null) {
//			txtArea.appendText("\n The height AVL tree 2 is : " + Functions.printBackWord());
		}

	}

	public static void maxMartyrs(NodeDoubleLinkedList nodeDouble, TextArea txtArea, Sammary sammary) {
		Date date = Functions.getMaxNumberOfMyrtyrs(nodeDouble, txtArea);
		DateFormat format = new SimpleDateFormat("M/d/yyyy");
		if (date == null) {
			txtArea.appendText(" \n The date that had the maximum number of martyrs : No Date was Found");
		} else {
			txtArea.appendText(" \n The date that had the maximum number of martyrs : " + format.format(date));

		}
	}

	public static void getHeightTree2(NodeDoubleLinkedList nodeDouble, TextArea txtArea, Sammary sammary) {
		int temp = Functions.getHeightAVL2(nodeDouble.getAVL_Dates().getRoot());
		if (txtArea != null) {
			txtArea.appendText("\n The height AVL tree 2 is : " + temp);
		}
	}
}
