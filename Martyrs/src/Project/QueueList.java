package Project;

import AVL2_DATES.Martyrs;
import AVL_Names.Node;

/*
 * Name :Anan Elayan
 * ID : 1211529
 *
 * */
public class QueueList {

	private QueueNode front;
	private QueueNode rear;

	public void enQueue(Martyrs order) {// add to queue at last
		QueueNode newNode = new QueueNode(order);
		if (rear == null) {
			this.front = this.rear = newNode;
		} else {
			this.rear.setNext(newNode);
			this.rear = newNode;
		}
	}

	public QueueNode deQueue() {// remove from queue at first
		if (front == null) {
			System.out.println("Queue is Empty");
			return null;
		} else {
			QueueNode temp = this.front;
			if (this.front == this.rear) {
				 this.front = this.rear = null;
			} else {
				 this.front = front.getNext();
			}
			return temp;
		}
		
	
	}

	public void printQueue() {
		QueueNode temp;
		if (this.front == null && this.rear == null) {
			System.out.println("Queue is Empty");
			return;
		}
		temp = this.front;
		do {
			System.out.println(temp.getmartyrs());
			temp = temp.getNext();
		} while (temp != null);
		System.out.println();
	}

	public boolean isEmpty() {// to check if queue is empty or not
		return this.front == null;
	}

	public QueueNode getFirst() { // return first node from queue
		return this.front;
	}

	public QueueNode lest() {
		if (!isEmpty())
			return this.rear;
		else
			return null;
	}



}
