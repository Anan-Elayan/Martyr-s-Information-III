package AVL_Names;

public class BinaryBaseTree implements BinaryTree {

	Node root;

	@Override
	public Node getRoot() {
		return root;
	}

	public String toStirng() {
		StringBuilder builder = new StringBuilder();
		appedStringTree(builder, getRoot());
		return builder.toString();
	}

	public void appedStringTree(StringBuilder builder, Node node) {
		if (node.left != null) {
			appedStringTree(builder, node.left);
			appendNode(builder, node);
			if (node.reight != null) {
				appedStringTree(builder, node.reight);
			}
		}
	}

	public void inOrder(Node root) {
		if (root != null) {
			inOrder(root.getLeft());
			System.out.println(root.data + " ");
			inOrder(root.getReight());
		}
	}

	public void appendNode(StringBuilder builder, Node node) {
		builder.append(node.data);
	}

	@Override
	public String toString() {
		return "BinaryBaseTree [root=" + root + "]";
	}

}
