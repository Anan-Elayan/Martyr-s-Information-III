package UI;

import AVL_Names.Node;
import Project.Functions;
import Project.NodeDoubleLinkedList;
import Project.QueueList;
import Project.QueueListT;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SammaryView extends Pane {

	TableView<Sammary> table = new TableView<>();
	TableColumn<Sammary, String> location = new TableColumn<>("Location");
	TableColumn<Sammary, Integer> noMartary = new TableColumn<>("No Martyrs");
	TableColumn<Sammary, Integer> numF = new TableColumn<>("No Femal");
	TableColumn<Sammary, Integer> numM = new TableColumn<>("No Male");
	TableColumn<Sammary, Integer> numSingel = new TableColumn<>("No Singel");
	TableColumn<Sammary, Integer> numMareed = new TableColumn<>("NO Mared");
	TableColumn<Sammary, Integer> avgAge = new TableColumn<>("Avg Age");

	@SuppressWarnings("unchecked")
	public SammaryView() {
		location.setCellValueFactory(new PropertyValueFactory<>("location"));
		noMartary.setCellValueFactory(new PropertyValueFactory<>("noMartary"));
		numF.setCellValueFactory(new PropertyValueFactory<>("numF"));
		numM.setCellValueFactory(new PropertyValueFactory<>("numM"));
		numSingel.setCellValueFactory(new PropertyValueFactory<>("numSingel"));
		numMareed.setCellValueFactory(new PropertyValueFactory<>("numMareed"));
		avgAge.setCellValueFactory(new PropertyValueFactory<>("avgAge"));

		table.getColumns().addAll(location, noMartary, numF, numM, numSingel, numMareed, avgAge);
		NodeDoubleLinkedList nodeDouble = Functions.data.getFirt();

		// to find the total in each colume
		int countnoMartary = 0;
		int countnumF = 0;
		int countnumM = 0;
		int countnumSingel = 0;
		int countnumMareed = 0;
		int avgAvg = 0;
		for (int i = 0; i < Functions.data.size(); i++) {
			Sammary sammary = new Sammary();
			sammary.setLocation(nodeDouble.getLocation());
			sammary.setNoMartary(nodeDouble.getAVL_Names().size());
			countnoMartary += nodeDouble.getAVL_Names().size();

			Functions.getNoMartyrs(nodeDouble.getLocation());
			Functions.countStatus(nodeDouble, sammary);
			Functions.countGender(nodeDouble, sammary);
			Functions.countAVG(nodeDouble, sammary);

			countnumF += sammary.getNumF();
			countnumM += sammary.getNumM();
			countnumSingel += sammary.getNumSingel();
			countnumMareed += sammary.getNumMareed();
			avgAvg += sammary.getAvgAge();
			table.getItems().add(sammary);
			nodeDouble = nodeDouble.getNext();
		}

		Sammary total = new Sammary("Total", countnoMartary, countnumF, countnumM, countnumSingel, countnumMareed,
				(int) (avgAvg / Functions.data.size()));
		table.getItems().add(total);
		Scene scene = new Scene(this.table, 700, 500);
		Stage newStage = new Stage();
		newStage.setScene(scene);
		newStage.setTitle("Sammary");
		newStage.getIcons().add(new Image("map.png"));
		newStage.show();
	}

}
