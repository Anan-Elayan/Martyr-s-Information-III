package Project;

import AVL2_DATES.AVL_Dates;
import AVL_Names.AVL_Names;

public class NodeDoubleLinkedList implements Comparable<NodeDoubleLinkedList> {

	private String location;
	private AVL_Names AVL_Names;
	private AVL_Dates AVL_Dates;
	private NodeDoubleLinkedList next;
	private NodeDoubleLinkedList previous;

	public NodeDoubleLinkedList(String location) {
		super();
		this.location = location;
		this.AVL_Names = new AVL_Names();
		this.AVL_Dates = new AVL_Dates();
	}

	public NodeDoubleLinkedList() {
		super();
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public AVL_Names getAVL_Names() {
		return AVL_Names;
	}

	public void setAVL_Names(AVL_Names aVL_Names) {
		AVL_Names = aVL_Names;
	}

	public AVL_Dates getAVL_Dates() {
		return AVL_Dates;
	}

	public void setAVL_Dates(AVL_Dates aVL_Dates) {
		AVL_Dates = aVL_Dates;
	}

	public NodeDoubleLinkedList getNext() {
		return next;
	}

	public void setNext(NodeDoubleLinkedList next) {
		this.next = next;
	}

	public NodeDoubleLinkedList getPrevious() {
		return previous;
	}

	public void setPrevious(NodeDoubleLinkedList previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return "NodeDoubleLinkedList [location=" + location + "]";
	}

	@Override
	public int compareTo(NodeDoubleLinkedList o) {
		return this.getLocation().compareToIgnoreCase(o.getLocation());

	}

	@Override
	public boolean equals(Object obj) {
		return this.getLocation().equalsIgnoreCase(((NodeDoubleLinkedList) obj).getLocation());
	}

}
