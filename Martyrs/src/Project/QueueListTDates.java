package Project;

import AVL2_DATES.NodeAVL2;

public class QueueListTDates {

	private NodeQueueTDates front;
	private NodeQueueTDates rear;

	public void enQueue(NodeAVL2 nodeTree) {// add to queue at last
		NodeQueueTDates newNode = new NodeQueueTDates(nodeTree);
		if (rear == null) {
			this.front = this.rear = newNode;
		} else {
			this.rear.setNext(newNode);
			this.rear = newNode;
		}
	}

	public NodeQueueTDates deQueue() {// remove from queue at first
		if (front == null) {
			System.out.println("Queue is Empty");
			return null;
		} else {
			NodeQueueTDates temp = this.front;
			if (this.front == this.rear) {
				this.front = this.rear = null;
			} else {
				this.front = front.getNext();
			}
			return temp;
		}

	}

	public boolean isEmpty() {// to check if queue is empty or not
		return this.front == null;
	}

	public NodeQueueTDates getFirst() { // return first node from queue
		return this.front;
	}

	public NodeQueueTDates lest() {
		if (!isEmpty())
			return this.rear;
		else
			return null;
	}

}
