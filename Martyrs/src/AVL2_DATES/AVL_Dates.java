package AVL2_DATES;


public class AVL_Dates extends BST {

	@Override
	public NodeAVL2 insertNode(DateStack data, NodeAVL2 node) {
		node = super.insertNode(data, node);
		updateHeight(node);
		return reBalanced(node);
	}

	private void updateHeight(NodeAVL2 node) {
		int lesftChildHeight = height(node.left);
		int rightChildHeight = height(node.reight);
		node.height = Math.max(lesftChildHeight, rightChildHeight);
	}

	public int height(NodeAVL2 node) {
		if (node != null) {
			return node.height;
		}
		return -1;

	}

	private NodeAVL2 reBalanced(NodeAVL2 node) {
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
			if (balanceFactor(node.left) <= 0) {
				node = rotateLeft(node);
			} else {
				node.reight = rotateRight(node.reight);
				node = rotateLeft(node);
			}

		}
		return node;
	}

	private int balanceFactor(NodeAVL2 node) {
		int bf = height(node.left) - height(node.reight);
		return bf;
	}

	private NodeAVL2 rotateRight(NodeAVL2 node) {
		NodeAVL2 temp = node.left;
		node.left = temp.reight;
		temp.reight = node;
		updateHeight(node);
		updateHeight(temp);
		return temp;
	}

	private NodeAVL2 rotateLeft(NodeAVL2 node) {
		NodeAVL2 temp = node.reight;
		node.reight = temp.left;
		temp.left = node;
		updateHeight(node);
		updateHeight(temp);
		return temp;
	}

	public void printTree(NodeAVL2 t) {
		if (t != null) {
			printTree(t.getLeft());
			System.out.println(t.data + " (" + height(t) + ")");
			printTree(t.getReight());
		}
	}

	public int size() {
		return size(root);
	}

	private int size(NodeAVL2 node) {
		if (node == null) {
			return 0;
		}
		return 1 + size(node.getLeft()) + size(node.getReight());

	}

}
