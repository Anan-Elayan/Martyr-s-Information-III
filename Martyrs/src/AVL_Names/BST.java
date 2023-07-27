package AVL_Names;

import AVL2_DATES.Martyrs;

public class BST extends BinaryBaseTree implements BSTIF {

	@Override
	public Node findNode(Martyrs data) {
		return FindNode(data, root);
	}

	@Override
	public void insert(Martyrs data) {
		root = insertNode(data, root);
	}

	@Override
	public Node delete(Martyrs data) {
		return root = deleteNode(data, root);
	}

	public Node FindNode(Martyrs data, Node node) {
		if (node == null) {
			return null;
		} else {
			if (node.data.compareTo(data) < 0) {
				node = FindNode(data, node.reight);
			} else if (node.data.compareTo(data) > 0) {
				node = FindNode(data, node.left);
			}
		}
		return node;
	}

	public Node insertNode(Martyrs data, Node node) {
		if (node == null) {
			node = new Node(data);
		} else if (data.compareTo(node.data) > 0) {
			node.reight = insertNode(data, node.reight);
		} else if (data.compareTo(node.data) <= 0) {
			node.left = insertNode(data, node.left);
		}
		return node;
	}

	public Node deleteNode(Martyrs data, Node node) {
	
		if (node == null) {
			return null;
		} else if (data.getName().compareTo(node.getData().getName()) > 0) {
			node.reight = deleteNode(data, node.reight);
		}

		else if (data.getName().compareTo(node.getData().getName()) < 0) {
			node.left = deleteNode(data, node.reight);

		} else {
			if (node.getData() == data) {
				System.out.println("dafad");
				if (node.left == null && node.reight == null) { // no child

					node = null;
				} else if (node.left == null) { // one child
					node = node.reight;
				}

				else if (node.reight == null) { // one child
					node = node.left;
				} else {
					deletWithToChildren(node); // two child
				}
			}

		}
		return node;
	}

	private void deletWithToChildren(Node node) {
		Node inOrder = findMin(node.reight);
		node.data = inOrder.data;
		node.reight = deleteNode(inOrder.data, inOrder);
	}

	private Node findMin(Node node) {

		if (node == null) {
			return null;
		} else if (node.left == null) {
			return node;
		} else {
			return findMin(node.left);
		}

	}

	public void traverseInOrder(Node node) {
		String s = "";
		if (node != null) {
			if (node.getLeft() != null) {
				traverseInOrder(node.getLeft());
			}
			s += node.getData() + "\n";
			System.out.println(node.getData() + " ");
			if (node.getReight() != null) {
				traverseInOrder(node.getReight());
			}
		}
	}

	public void traverseTree(Node node) {
		if (node != null) {
			traverseTree(node.getLeft());
			System.out.println("Name: " + node.data.getName() + ", Date of Death: " + node.getData().getDateOfDeath());
			traverseTree(node.getReight());
		}
	}

}
