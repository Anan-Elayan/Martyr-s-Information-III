package Project;

import AVL_Names.Node;

/*
 * Name :Anan Elayan
 * ID : 1211529
 *
 * */
public class QueueNodeT {
    private AVL_Names.Node treeNode;
    private QueueNodeT next;

    public QueueNodeT(Node treeNode) {
		super();
		this.treeNode = treeNode;
	}

	public  AVL_Names.Node getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(AVL_Names.Node treeNode) {
        this.treeNode = treeNode;
    }

    public QueueNodeT getNext() {
        return next;
    }

    public void setNext(QueueNodeT next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "QueueNode{" +
                "treeNode=" + treeNode +
                ", next=" + next +
                '}';
    }
}
