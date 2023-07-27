package AVL2_DATES;

public class BinaryBaseTree  implements BinaryTree{

	
	NodeAVL2 root ;
	
	@Override
	public NodeAVL2 getRoot() {
		return root;
	}
	
	public String toStirng() {
		StringBuilder builder = new StringBuilder();
		appedStringTree(builder,getRoot());
		return builder.toString();
	}
	
	
	public void appedStringTree (StringBuilder builder , NodeAVL2 node) {
		if(node.left!=null) {
			appedStringTree(builder, node.left);
			appendNode(builder, node);
			if(node.reight!=null) {
				appedStringTree(builder, node.reight);
			}
		}
	}
	
	public void inOrder(NodeAVL2 root) {
		if(root!=null) {
			inOrder(root.getLeft());
			System.out.println(root.data + " ");
			inOrder(root.getReight());
		}
	}
	
	public void appendNode(StringBuilder builder , NodeAVL2 node) {
		builder.append(node.data);
	}

	@Override
	public String toString() {
		return "BinaryBaseTree [root=" + root + "]";
	}
	
	

}
