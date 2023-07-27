package AVL_Names;

import AVL2_DATES.Martyrs;
import Project.NodeDoubleLinkedList;
import Project.QueueList;
import Project.QueueListT;
import Project.QueueNodeT;

public class AVL_Names extends BST {

	@Override
	public Node insertNode(Martyrs data, Node node) {
		node = super.insertNode(data, node);
		updateHeight(node);
		return reBalanced(node);
	}

	private void updateHeight(Node node) {
		int lesftChildHeight = height(node.left);
		int rightChildHeight = height(node.reight);
		node.height = Math.max(lesftChildHeight, rightChildHeight);
	}

	public int height(Node node) {
		if (node != null) {
			return node.height;
		}
		return -1;

	}

	private int balanceFactor(Node node) {
		int bf = height(node.left) - height(node.reight);
		return bf;
	}

	private Node reBalanced(Node node) {
		int bf = balanceFactor(node);
		if (bf > 1) {
			if (balanceFactor(node.left) >= 0) {
				node = rotateRight(node);
			} else {
				node.left = rotateLeft(node.left);
				node = rotateRight(node);
			}
		}
		if (bf < -1) {
			if (balanceFactor(node.reight) <= 0) {
				node = rotateLeft(node.reight);
			} else {
				node.reight = rotateRight(node.reight);
				node = rotateLeft(node);
			}

		}
		return node;
	}

	private Node rotateRight(Node node) {
		Node temp = node.left;
		node.left = temp.reight;
		temp.reight = node;
		updateHeight(node);
		updateHeight(temp);
		return temp;
	}

	private Node rotateLeft(Node node) {
		Node temp = node.reight;
		node.reight = temp.left;
		temp.left = node;
		updateHeight(node);
		updateHeight(temp);
		return temp;
	}

	public void printTree(Node t) {
		if (t != null) {
			printTree(t.getLeft());
			System.out.println(t.data + " (" + height(t) + ")");
			printTree(t.getReight());
		}
	}

	public int size() {
		if(root==null) {
			return 0;
		}
		QueueListT queue = new QueueListT();
		Node root = this.root;
		queue.enQueue(root);
		  int size = 0;
		while (!queue.isEmpty()) {

			QueueNodeT node = queue.deQueue();
			size++;
			
			if (node.getTreeNode().getLeft() != null) {
				queue.enQueue(node.getTreeNode().getLeft());
			}
			if (node.getTreeNode().getReight() != null) {
				queue.enQueue(node.getTreeNode().getReight());
			}
		}
		return size;
	}


}
