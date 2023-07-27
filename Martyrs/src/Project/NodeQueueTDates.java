package Project;

import AVL2_DATES.AVL_Dates;
import AVL2_DATES.NodeAVL2;

public class NodeQueueTDates {
	
	private NodeAVL2 treeNode;
	private NodeQueueTDates next;

	public NodeQueueTDates(NodeAVL2 treeNode) {
		super();
		this.treeNode = treeNode;
	}

	public NodeAVL2 getTreeNode() {
		return treeNode;
	}

	public void setTreeNode(NodeAVL2 treeNode) {
		this.treeNode = treeNode;
	}

	public NodeQueueTDates getNext() {
		return next;
	}

	public void setNext(NodeQueueTDates next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "QueueNode{" + "treeNode=" + treeNode + ", next=" + next + '}';
	}
}
