package AVL2_DATES;

public class BST extends BinaryBaseTree implements BSTIF {

	
	
	@Override
	public NodeAVL2 findNode(DateStack data) {
		return FindNode(data,root);
	}

	
	
	
	@Override
	public void insert(DateStack data) {
		root = insertNode(data, root);
	}

	
	
	@Override
	public void delete(DateStack data) {
		root = deleteNode(data, root);
	}
	
	
	
	
	

	public NodeAVL2 FindNode(DateStack data, NodeAVL2 node) {
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

	
	
	
	public NodeAVL2 insertNode(DateStack data, NodeAVL2 node) { 
		if (node == null) {
			node = new NodeAVL2(data);
		} else if (data.compareTo(node.data) > 0) {
			node.reight = insertNode(data, node.reight);
		} else if (data.compareTo(node.data) <= 0) {
			node.left = insertNode(data, node.left);

		}
		return node;
	}
	
	
	
	

	public NodeAVL2 deleteNode(DateStack data, NodeAVL2 node) {
		if (node == null) {
			return null;
		} else if (data.compareTo(node.data) > 0) {
			node.reight = deleteNode(data, node.reight);
		}

		else if (data.compareTo(node.data) < 0) {
			node.left = deleteNode(data, node.reight);

		} else if (node.left == null && node.reight == null) { // no child
			node = null;
		} else if (node.left == null) { // one child
			node = node.reight;
		}

		else if (node.reight == null) { // one child
			node = node.left;
		} else {
			deletWithToChildren(node); // two child 
		}
		return node;
	}

	
	
	
	private void deletWithToChildren(NodeAVL2 node) {
		NodeAVL2 inOrder = findMin(node.reight);
		node.data = inOrder.data;
		node.reight = deleteNode(inOrder.data, inOrder);
	}

	
	
	
	private NodeAVL2 findMin(NodeAVL2 node) {
		
		if(node==null) {
			return null;
		}
		else if(node.left==null) {
			return node;
		}
		else {
			return findMin(node.left);
		}
		
	}
	
	public void traverseInOrder(NodeAVL2 node) {
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
	
	public void traverseTree(NodeAVL2 node) {
        if (node != null) {
            traverseTree(node.getLeft());
            System.out.println("Name: " + node.data.getDate() + ", Date of Death: " + node.getData());
            traverseTree(node.getReight());
        }
    }
	


	
	

}
