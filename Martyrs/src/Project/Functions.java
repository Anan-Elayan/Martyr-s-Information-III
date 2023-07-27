package Project;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import AVL2_DATES.DateStack;
import AVL2_DATES.Martyrs;
import AVL2_DATES.NodeAVL2;
import AVL_Names.Node;
import UI.Sammary;
import UI.Warning;
import javafx.scene.control.TextArea;
import javafx.stage.DirectoryChooser;

public class Functions {
	
	

	public static DoublyLinkedList data = new DoublyLinkedList();

	public static void Insert_New_Location(String newLocation) {
		NodeDoubleLinkedList node = new NodeDoubleLinkedList(newLocation);
		data.addNodeSorted(node);
	}

	public static void Delete_Location(String location) {
		NodeDoubleLinkedList locationNode = data.search(location);

		// exit this node
		if (locationNode != null) {
			data.removeObj(locationNode);
		} else {
			// not exit this location
		}
	}

	public static void Update_Location(NodeDoubleLinkedList node, String newNameLocation) {
		NodeDoubleLinkedList locationNode = data.search(node.getLocation());
		// new name = anther old location
		if (locationNode != null) {
			locationNode.setLocation(newNameLocation);
			return;
		}

	}

	public static NodeDoubleLinkedList Search_Location(String location) {

		return data.search(location);
	}

	
	
	
	// *********************************************************** Martyrs Functions **********************************

	public static void Insert_New_Martyrs(String location, Martyrs martyrs) {
		SimpleDateFormat format2 = new SimpleDateFormat("M/d/yyyy");
		NodeDoubleLinkedList nodeLocation = data.search(location);
		if (nodeLocation != null) {
			nodeLocation.getAVL_Names().insert(martyrs);
		} else {
//			nodeLocation = nodeLocation.getNext();
		}

	}

	public static Node Delete_Martyrs(String location, Martyrs martyrs) {
		SimpleDateFormat format2 = new SimpleDateFormat("M/d/yyyy");
		delete_from_stack_AVL2(location, martyrs);
		int count = Functions.data.search(location).getAVL_Names().size();
		data.search(location).getAVL_Names().delete(martyrs);
		int count2 = Functions.data.search(location).getAVL_Names().size();
		System.out.println(count + " " + count2);
		return null;

	}

	
	

	// **************************************************** Statistics Functions *****************************************
	public static int getNoMartyrs(String location) {
		NodeDoubleLinkedList nodeDouble = Functions.data.search(location);
		if (nodeDouble != null) {
			return nodeDouble.getAVL_Names().size();
		} else
			return 0;
	}

	public static QueueList printTree1LevelByLevel(String Location) {
		QueueList returnDatat = new QueueList();
		QueueListT queue = new QueueListT();
		NodeDoubleLinkedList nodeDoyble = data.search(Location);
		Node root = null;
		if (nodeDoyble != null) {
			root = nodeDoyble.getAVL_Names().getRoot();
			if (root == null) {
				return returnDatat;
			}
		}
		queue.enQueue(root);
		while (!queue.isEmpty()) {

			QueueNodeT node = queue.deQueue();
			returnDatat.enQueue(node.getTreeNode().getData());
			if (node.getTreeNode().getLeft() != null) {
				queue.enQueue(node.getTreeNode().getLeft());
			}
			if (node.getTreeNode().getReight() != null) {
				queue.enQueue(node.getTreeNode().getReight());
			}

		}
		return returnDatat;

	}

	public static int getHeightAVL1(Node node) {
		if (node != null) {
			int left = getHeightAVL1(node.getLeft());
			int right = getHeightAVL1(node.getReight());
			if (left >= right) {
				return left + 1;

			} else {
				return right + 1;
			}

		}
		return 0;
	}

	
	
	
	public static StackList printBackWord(String Location) {

		StackList stackList = new StackList();
		QueueListTDates queue = new QueueListTDates();
		NodeDoubleLinkedList node = data.search(Location);
		NodeAVL2 root = null;
		if (node != null) {
			root = node.getAVL_Dates().getRoot();
			if (root == null) {
				return stackList;
			}
		}
		queue.enQueue(root);
		while (!queue.isEmpty()) {
			NodeQueueTDates node2 = queue.deQueue();
			stackList.push(node2.getTreeNode().getData());

			if (node2.getTreeNode().getLeft() != null) {
				queue.enQueue(node2.getTreeNode().getLeft());

			}
			if (node2.getTreeNode().getReight() != null) {
				queue.enQueue(node2.getTreeNode().getReight());
			}
		}
		return stackList;
	}

	public static Date getMaxNumberOfMyrtyrs(NodeDoubleLinkedList nodeDouble, TextArea textArea) {

		StackList tree = printBackWord(nodeDouble.getLocation());
		int max = 0;
		Date date = null;
		NodeStack temp = tree.getTopItem();
		while (temp != null) {
			if (temp.getDateStack().getStack().size() > max) {
				date = temp.getDateStack().getDate();
				max = temp.getDateStack().getStack().size();
			}
			temp = temp.getNext();
		}
		return date;

	}

	public static int getHeightAVL2(NodeAVL2 node) {
		if (node != null) {
			int left = getHeightAVL2(node.getLeft());
			int right = getHeightAVL2(node.getReight());
			if (left >= right) {
				return left+1 ;

			} else {
				return right +1;
			}

		}
		return 0;

	}

	
	
	
	
	
	// ******************************************************** Save Functions **********************************

	public static void Save_to_File(String path) {
		DirectoryChooser directory = new DirectoryChooser();
		File file2 = directory.showDialog(null);
		File file = new File(file2.getAbsolutePath() + "\\" + path.trim() + ".txt");
		FileWriter write;
		try {
			DateFormat format = new SimpleDateFormat("M/d/yyyy");
			write = new FileWriter(file);

			NodeDoubleLinkedList temp = Functions.data.getFirt();
			for (int i = 0; i < data.size(); i++) {
				QueueList queue = printTree1LevelByLevel(temp.getLocation());
				while (!queue.isEmpty()) {
					String date = format.format(queue.getFirst().getmartyrs().getDateOfDeath());
					write.append(queue.getFirst().getmartyrs().getName() + "," + queue.getFirst().getmartyrs().getAge()
							+ "," + temp.getLocation() + "," + date + "," + queue.getFirst().getmartyrs().getGender()
							+ "," + queue.getFirst().getmartyrs().getPersonalStatus() + "\n");
					queue.deQueue();
				}
				temp = temp.getNext();

			}

			write.close();
			new Warning("Success save");

		} catch (IOException e2) {
			new Warning(e2.getMessage());
		}
	}

	
	
	
	
	// ****************************** 2AVL
	public static void insert_new_date(String location, Date date, Martyrs martyrs) {
		NodeDoubleLinkedList nodeDouble = data.search(location);
		if (nodeDouble != null) {
			NodeAVL2 node = nodeDouble.getAVL_Dates().findNode(new DateStack(date));
			if (node != null) {
				node.getData().getStack().push(martyrs);
			} else {
				nodeDouble.getAVL_Dates().insert(new DateStack(date, martyrs));

			}
		}
	}

	public static boolean delete_from_stack_AVL2(String location, Martyrs martyrs) {

		StackList satck = printBackWord(location);
		while (!satck.isEmpty()) {
			NodeStack node = satck.getTopItem();
			satck.pop();
			AVL2_DATES.StackList Stack = node.getDateStack().getStack();
			AVL2_DATES.NodeStack node2;
			AVL2_DATES.StackList temp = new AVL2_DATES.StackList();

			while (!Stack.isEmpty()) {
				node2 = Stack.getTopItem();
				temp.push(node2.getOrder());

				Stack.pop();
				if (node2.getOrder() == martyrs) {
					temp.pop();
					while (!Stack.isEmpty()) {
						node2 = Stack.getTopItem();
						temp.push(node2.getOrder());

						Stack.pop();
					}
					node.getDateStack().setStack(temp);
					return true;
				}
			}
		}
		return false;
	}

	
	
	
	
	
	
	
	// * summary view method
	public static void countStatus(NodeDoubleLinkedList nodeDouble, Sammary sammary) {
		int countS = 0;
		int countM = 0;
		QueueList queue = Functions.printTree1LevelByLevel(nodeDouble.getLocation());
		while (!queue.isEmpty()) {
			if (queue.getFirst().getmartyrs().getPersonalStatus().equals("single")) {
				countS++;
			} else {
				countM++;
			}
			queue.deQueue();
		}
		if (sammary != null) {
			sammary.setNumMareed(countM);
			sammary.setNumSingel(countS);
		}
	}

	public static void countGender(NodeDoubleLinkedList nodeDouble, Sammary sammary) {
		int countF = 0;
		int countM = 0;
		QueueList queue = Functions.printTree1LevelByLevel(nodeDouble.getLocation());
		while (!queue.isEmpty()) {
			if (queue.getFirst().getmartyrs().getGender() == 'F') {
				countF++;
			} else {
				countM++;
			}
			queue.deQueue();
		}
		if (sammary != null) {
			sammary.setNumF(countF);
			sammary.setNumM(countM);
		}
	}

	public static void countAVG(NodeDoubleLinkedList nodeDouble, Sammary sammary) {
		int count = 0;
		float AVG = 0;
		int size = 0;
		QueueList queue = Functions.printTree1LevelByLevel(nodeDouble.getLocation());
		while (!queue.isEmpty()) {
			count += queue.getFirst().getmartyrs().getAge();
			size++;
			AVG = count / size;
			queue.deQueue();
		}
		if (sammary != null) {
			sammary.setAvgAge((int) AVG);
		}

	}

}
