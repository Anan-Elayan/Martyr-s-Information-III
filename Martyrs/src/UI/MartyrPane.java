package UI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import AVL2_DATES.DateStack;
import AVL2_DATES.Martyrs;
import AVL_Names.AVL_Names;
import AVL_Names.Node;
import Project.Functions;
import Project.NodeDoubleLinkedList;
import Project.QueueList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;

public class MartyrPane extends Pane {

	private Label lblName = new Label("Name");
	private Label lblAge = new Label("Age");
	private Label lblDate = new Label("Date deth");
	private Label lblGender = new Label("Gender");
	private Label lblstatus = new Label("Status");
	private Label lblLocatione = new Label("Locatione");
	private Label lblWelcome = new Label("Welcome to  martyrs Info");

	private TextField txtName = new TextField();
	private TextField txtAge = new TextField();
	private TextField txtDate = new TextField();

	private RadioButton femal = new RadioButton("Femal");
	private RadioButton Male = new RadioButton("Male");
	private RadioButton singel = new RadioButton("Singel");
	private RadioButton maread = new RadioButton("Mared");
	private ToggleGroup group = new ToggleGroup();
	private ToggleGroup group2 = new ToggleGroup();

	private TextField txtLocation = new TextField();
	private TextField searchName = new TextField();

	private String lblStyle = "-fx-text-fill:cd9b05;-fx-font-size:15";
	private String btnStyle = "-fx-background-color:black;" + "-fx-border-color:white;"
			+ "-fx-background-radius:10 50 10 50;" + "-fx-border-radius:10 50 10 50;" + "-fx-text-fill:f2bd12";

	private Button btnInsert = new Button("Insert");
	private Button btnDelete = new Button("Delete");
	private Button btnUpdate = new Button("Update ");
	private Button btnSearch = new Button("Search ");
	private Button btnEdit = new Button("Edit ");

	private TableView<Martyrs> tableView = new TableView<Martyrs>();
	private TableColumn<Martyrs, String> name = new TableColumn<Martyrs, String>("Name");
	private TableColumn<Martyrs, String> age = new TableColumn<Martyrs, String>("Age");
	private TableColumn<Martyrs, Date> dateOfDeath = new TableColumn<Martyrs, Date>("Date Of Death");
	private TableColumn<Martyrs, Character> gender = new TableColumn<Martyrs, Character>("Gender");
	private TableColumn<Martyrs, String> personalStatus = new TableColumn<Martyrs, String>("Status");
	private Font font = Font.font("Bernard MT Condensed", FontPosture.REGULAR, 29);

	private Pane tablePane = new Pane();
	private Pane fildesPane = new Pane();
	NodeDoubleLinkedList locationNode;

	public MartyrPane(NodeDoubleLinkedList locNode) {
		this.locationNode = locNode;
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		age.setCellValueFactory(new PropertyValueFactory<>("age"));
		dateOfDeath.setCellValueFactory(new PropertyValueFactory<>("dateOfDeath"));
		dateOfDeath.setCellFactory(col -> {
			TableCell<Martyrs, Date> cell = new TableCell<Martyrs, Date>() {
				private SimpleDateFormat format = new SimpleDateFormat("M/d/yyyy");

				@Override
				protected void updateItem(Date item, boolean empty) {
					super.updateItem(item, empty);
					if (empty) {
						setText(null);
					} else {
						setText(format.format(item));
					}
				}
			};
			return cell;
		});

		gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
		personalStatus.setCellValueFactory(new PropertyValueFactory<>("personalStatus"));
		tableView.getColumns().addAll(name, age, dateOfDeath, gender, personalStatus);
		this.tablePane.getChildren().addAll(lblLocatione, searchName, tableView);
		this.tableView.setLayoutY(100);
		this.tableView.setPrefWidth(500);
		this.tableView.setPrefHeight(330);

		QueueList queueListResule = Functions.printTree1LevelByLevel(locNode.getLocation());
		while (!queueListResule.isEmpty()) {
			tableView.getItems().add(queueListResule.getFirst().getmartyrs());
			queueListResule.deQueue();
		}

		lblLocatione.setText("Welcome to  martyrs " + locNode.getLocation() + " Records");
		lblLocatione.setStyle("-fx-text-fill:white");
		lblLocatione.setFont(font);
		lblLocatione.setLayoutX(25);
		lblLocatione.setLayoutY(15);

		searchName.setPromptText("Part of name");
		searchName.setPrefHeight(25);
		searchName.setPrefWidth(370);
		searchName.setLayoutX(25);
		searchName.setLayoutY(55);

		lblName.setStyle(lblStyle);
		lblName.setLayoutX(25);
		lblName.setLayoutY(100);
		txtName.setPrefHeight(25);
		txtName.setPrefWidth(330);
		txtName.setLayoutX(100);
		txtName.setLayoutY(100);

		lblAge.setStyle(lblStyle);
		lblAge.setLayoutX(25);
		lblAge.setLayoutY(150);
		txtAge.setPrefHeight(25);
		txtAge.setPrefWidth(330);
		txtAge.setLayoutX(100);
		txtAge.setLayoutY(150);

		lblDate.setStyle(lblStyle);
		lblDate.setLayoutX(25);
		lblDate.setLayoutY(200);
		txtDate.setPrefHeight(25);
		txtDate.setPrefWidth(330);
		txtDate.setLayoutX(100);
		txtDate.setLayoutY(200);

		lblGender.setStyle(lblStyle);
		lblGender.setLayoutX(25);
		lblGender.setLayoutY(250);

		lblstatus.setStyle(lblStyle);
		lblstatus.setLayoutX(25);
		lblstatus.setLayoutY(300);

		femal.setLayoutX(80);
		femal.setLayoutY(250);
		femal.setStyle("-fx-text-fill:white");

		Male.setLayoutX(150);
		Male.setLayoutY(250);
		Male.setStyle("-fx-text-fill:white");

		femal.setToggleGroup(group);
		Male.setToggleGroup(group);

		singel.setLayoutX(80);
		singel.setLayoutY(300);
		singel.setStyle("-fx-text-fill:white");

		maread.setLayoutX(150);
		maread.setLayoutY(300);
		maread.setStyle("-fx-text-fill:white");
		singel.setToggleGroup(group2);
		maread.setToggleGroup(group2);

		Font font = Font.font("Arial Black", FontPosture.REGULAR, 10);

		btnInsert.setStyle(btnStyle);
		btnInsert.setFont(font);
		btnInsert.setPrefHeight(27);
		btnInsert.setPrefWidth(102);
		btnInsert.setLayoutX(400);
		btnInsert.setLayoutY(465);

		btnDelete.setStyle(btnStyle);
		btnDelete.setFont(font);
		btnDelete.setPrefHeight(27);
		btnDelete.setPrefWidth(102);
		btnDelete.setLayoutX(270);
		btnDelete.setLayoutY(465);

		btnUpdate.setStyle(btnStyle);
		btnUpdate.setFont(font);
		btnUpdate.setPrefHeight(27);
		btnUpdate.setPrefWidth(102);
		btnUpdate.setLayoutX(10);
		btnUpdate.setLayoutY(465);

		btnSearch.setStyle(btnStyle);
		btnSearch.setFont(font);
		btnSearch.setPrefHeight(27);
		btnSearch.setPrefWidth(102);
		btnSearch.setLayoutX(137);
		btnSearch.setLayoutY(465);

		btnEdit.setStyle(btnStyle);
		btnEdit.setFont(font);
		btnEdit.setPrefHeight(27);
		btnEdit.setPrefWidth(102);
		btnEdit.setLayoutX(10);
		btnEdit.setLayoutY(465);

		tablePane.setVisible(true);
		fildesPane.setVisible(false);
		lblLocatione.setVisible(true);

		setActions();

		btnUpdate.setVisible(false);

		this.fildesPane.getChildren().addAll(lblName, txtName, lblAge, txtAge, lblDate, txtDate, lblGender, femal, Male,
				lblstatus, singel, maread);

		this.getChildren().addAll(lblLocatione, this.fildesPane, this.tablePane, btnInsert, btnDelete, btnSearch,
				btnEdit, btnUpdate);

	}

	private void setActions() { // method action

		btnInsert.setOnAction(e2 -> { // action insert to add new martyrs

			if (!fildesPane.isVisible()) {
				tablePane.setVisible(false);
				fildesPane.setVisible(true);
				btnUpdate.setVisible(false);
				txtDate.clear();
				maread.setSelected(false);
				singel.setSelected(true);
				Male.setSelected(false);
				femal.setSelected(true);
				txtName.clear();
				txtAge.clear();
				return;
			}
			if (lblDate.isVisible() == false || lblGender.isVisible() == false || lblstatus.isVisible() == false
					|| txtDate.isVisible() == false || singel.isVisible() == false || maread.isVisible() == false
					|| Male.isVisible() == false || femal.isVisible() == false) {
				lblDate.setVisible(true);
				lblGender.setVisible(true);
				lblstatus.setVisible(true);
				txtDate.setVisible(true);
				singel.setVisible(true);
				maread.setVisible(true);
				Male.setVisible(true);
				femal.setVisible(true);

			}
			if (this.locationNode.getAVL_Names().getRoot() == null) { // not empty single list
				if (txtName.getText().isEmpty() || txtAge.getText().isEmpty() || txtDate.getText().isEmpty()) {
					new Warning("Please set your info");
				} else {
					Martyrs mar = new Martyrs();
					int age = 0;
					try {
						age = Integer.parseInt(txtAge.getText().trim());
						mar.setAge(age);
					} catch (NumberFormatException et) {
						new Warning("Invalid age");
						return;
					}
					SimpleDateFormat format2 = new SimpleDateFormat("M/d/yyyy");
					mar.setName(txtName.getText().trim());
					try {
						Date dod = format2.parse(txtDate.getText().trim());
						mar.setDateOfDeath(dod);
					} catch (Exception ex) {
						new Warning("Invalid Date of Death");
						return;
					}
					if (Male.isSelected()) {
						mar.setGender('M');
					} else {
						mar.setGender('F');
					}

					if (singel.isSelected()) {
						mar.setPersonalStatus("single");
					} else {
						mar.setPersonalStatus("married");
					}
					locationNode.getAVL_Names().insert(mar);
					locationNode.getAVL_Dates().insert(new DateStack(mar.getDateOfDeath(),mar));
					tableView.refresh();

					// to double list
					tableView.refresh();
					new Warning("Added successfully");
					txtName.clear();
					txtAge.clear();
					txtDate.clear();
					femal.setSelected(true);
					singel.setSelected(true);
				}
			} else {
				new Warning("Not found this location");
			}
		});

		btnDelete.setOnAction(e2 -> { // to delete a martyrs record in martyrs scene ( name and age)

			Martyrs martyrs = tableView.getSelectionModel().getSelectedItem();
			if (martyrs != null) {
				Martyrs selectionModel = tableView.getSelectionModel().getSelectedItem();
				Functions.Delete_Martyrs(locationNode.getLocation(), martyrs);

			}
		});

		btnSearch.setOnAction(e2 -> { // to search a record in martyrs scene ( by part name)
			btnUpdate.setVisible(false);
			tablePane.setVisible(true);
			fildesPane.setVisible(false);
			lblLocatione.setVisible(true);
			txtDate.setVisible(true);
			lblDate.setVisible(true);
			Male.setVisible(true);
			femal.setVisible(true);
			lblGender.setVisible(true);
			maread.setVisible(true);
			singel.setVisible(true);
			lblstatus.setVisible(true);
			lblLocatione.setLayoutX(25);
			lblLocatione.setLayoutY(15);
		});

		searchName.setOnAction(e -> {
			String name = searchName.getText().trim(); // save target in variable name
			QueueList queue = Functions.printTree1LevelByLevel(locationNode.getLocation());
			this.tableView.getItems().clear();// clear table view

			if (!searchName.getText().isEmpty()) {
				while (!queue.isEmpty()) {
					if (queue.getFirst().getmartyrs().getName().contains(searchName.getText())) {
						tableView.getItems().add(queue.getFirst().getmartyrs());
					}
					queue.deQueue();
				}
			} else {

				while (!queue.isEmpty()) {
					tableView.getItems().add(queue.getFirst().getmartyrs());
					queue.deQueue();
				}

			}
			searchName.clear();
		});

		btnEdit.setOnAction(e -> {
			System.out.println("asdfa");
			int index = tableView.getSelectionModel().getSelectedIndex();
			if (index <= -1)
				return;
			if (tableView.getSelectionModel().getSelectedItem() != null) {
				btnEdit.setVisible(false);
				Martyrs selectionModel = tableView.getSelectionModel().getSelectedItem();
				DateFormat format = new SimpleDateFormat("M/d/yyyy");
				String d = format.format(selectionModel.getDateOfDeath());
				fildesPane.setVisible(true);
				tablePane.setVisible(false);
				btnUpdate.setVisible(true);
				txtName.setText(selectionModel.getName());
				txtAge.setText(String.valueOf(selectionModel.getAge()));
				txtDate.setText(d);
				if (selectionModel.getGender() == 'F') {
					femal.setSelected(true);
				} else {
					Male.setSelected(true);
				}

				if (selectionModel.getPersonalStatus().equals("single")) {
					singel.setSelected(true);
				} else {
					maread.setSelected(true);
				}

				btnUpdate.setOnAction(e2 -> { // action update in scene martyrs
					int age = 0;
					try {
						age = Integer.parseInt(txtAge.getText().trim());
						selectionModel.setAge(age);
					} catch (NumberFormatException et) {
						new Warning("Invalid age");
						return;
					}
					SimpleDateFormat format2 = new SimpleDateFormat("M/d/yyyy");
					selectionModel.setName(txtName.getText().trim());
					try {
						Date dod = format2.parse(txtDate.getText().trim());
						selectionModel.setDateOfDeath(dod);
					} catch (Exception ex) {
						new Warning("Invalid DOD");
						return;
					}
					if (Male.isSelected()) {
						selectionModel.setGender('M');
					} else {
						selectionModel.setGender('F');
					}

					if (singel.isSelected()) {
						selectionModel.setPersonalStatus("single");
					} else {
						selectionModel.setPersonalStatus("married");
					}
					tableView.refresh();
					new Warning("Updated Successfuly");
					txtName.clear();
					txtAge.clear();
					txtDate.clear();
					femal.setSelected(true);
					singel.setSelected(true);
					if (!btnEdit.isVisible()) {
						btnEdit.setVisible(true);
						btnUpdate.setVisible(false);
					}
					btnEdit.setVisible(true);

				});

			} else {
				new Warning("Please Cliked Row For Edit");
			}
		});

	}

}
