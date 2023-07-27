package Project;

import AVL2_DATES.DateStack;

/*
 * Name :Anan Elayan
 * ID : 1211529
 *
 * */
public class NodeStack {

	private DateStack dateStack;
	private NodeStack next;

	public NodeStack() {
		super();
	}
	

	public NodeStack(DateStack dateStack) {
		super();
		this.dateStack = dateStack;
	}


	public NodeStack(DateStack dateStack, NodeStack next) {
		super();
		this.dateStack = dateStack;
		this.next = next;
	}

	public DateStack getDateStack() {
		return dateStack;
	}

	public void setDateStack(DateStack dateStack) {
		this.dateStack = dateStack;
	}

	public NodeStack getNext() {
		return next;
	}

	public void setNext(NodeStack next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "NodeStack [dateStack=" + dateStack + ", next=" + next + "]";
	}

}
