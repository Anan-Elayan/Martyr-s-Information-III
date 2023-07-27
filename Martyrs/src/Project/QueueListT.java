package Project;

import AVL2_DATES.Martyrs;
import AVL_Names.Node;

/*
 * Name :Anan Elayan
 * ID : 1211529
 *
 * */
public class QueueListT {

	private QueueNodeT front;
	private QueueNodeT rear;

	public void enQueue(Node nodeTree) {// add to queue at last
		QueueNodeT newNode = new QueueNodeT(nodeTree);
		if (rear == null) {
			this.front = this.rear = newNode;
		} else {
			this.rear.setNext(newNode);
			this.rear = newNode;
		}
	}

	public QueueNodeT deQueue() {// remove from queue at first
		if (front == null) {
			System.out.println("Queue is Empty");
			return null;
		} else {
			QueueNodeT temp = this.front;
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

	public QueueNodeT getFirst() { // return first node from queue
		return this.front;
	}

	public QueueNodeT lest() {
		if (!isEmpty())
			return this.rear;
		else
			return null;
	}

	
}
