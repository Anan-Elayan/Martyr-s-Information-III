package Project;

import AVL2_DATES.DateStack;

/*
 * Name :Anan Elayan
 * ID : 1211529
 *
 * */
public class StackList {
	private NodeStack topItem;

	public void push(DateStack data) {
		NodeStack newNode = new NodeStack(data);
		if (topItem != null) {
			newNode.setNext(topItem);
		}
		this.topItem = newNode;
	}

	public void pop() {
		if (topItem == null) {
			System.out.println("Stack is Empty");
		} else {
			topItem = topItem.getNext();
		}
	}

	public NodeStack getTopItem() {
		return topItem;
	}

	public void setTopItem(NodeStack topItem) {
		this.topItem = topItem;
	}

	public boolean isEmpty() {
		return this.topItem == null;
	}


	
	public int size() {
		int size = 0;
		NodeStack temp = topItem;
		while (temp != null) {
			size++;
			temp = temp.getNext();
		}
		return size;
	}

}
