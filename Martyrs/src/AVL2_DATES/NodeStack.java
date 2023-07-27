package AVL2_DATES;
/*
 * Name :Anan Elayan
 * ID : 1211529
 
 * */

public class NodeStack {

	private Martyrs martyrs;
	private NodeStack next;

	public NodeStack(Martyrs order) {
		this.martyrs = order;
		this.next = null;
	}

	public Martyrs getOrder() {
		return martyrs;
	}

	public void setOrder(Martyrs order) {
		this.martyrs = order;
	}

	public NodeStack getNext() {
		return next;
	}

	public void setNext(NodeStack next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "NodeStack{" + ", order=" + martyrs + ", next=" + next + '}';
	}
}
