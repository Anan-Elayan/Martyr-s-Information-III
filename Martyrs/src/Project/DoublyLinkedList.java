package Project;

public class DoublyLinkedList implements MethodsDoubleLinkedList {

	private NodeDoubleLinkedList first;
	private NodeDoubleLinkedList last;
	private int count = 0;

	@Override
	public NodeDoubleLinkedList getFirt() {
		return this.first;
	}

	@Override
	public NodeDoubleLinkedList getLast() {
		return this.last;
	}

	@Override
	public void addFirst(NodeDoubleLinkedList newNode) {
		if (this.count == 0) {
			this.first = this.last = newNode;
		} else {
			newNode.setNext(this.first);
			this.last.setNext(newNode);
			newNode.setPrevious(this.last);
			this.first.setPrevious(newNode);
			this.first = newNode;
		}
		count++;
	}

	// in this method we need to add need at last double linked list
	@Override
	public void addLast(NodeDoubleLinkedList newNode) {
		if (count == 0) {
			this.first = this.last = newNode;
		} else {
			newNode.setPrevious(this.last);
			newNode.setNext(this.first);
			this.last.setNext(newNode);
			this.first.setPrevious(newNode);
			this.last = newNode;
		}
		count++;
	}

	// in this method we need to add node in double linked list
	@Override
	public void add(NodeDoubleLinkedList newNode, int index) {
		NodeDoubleLinkedList curent;
		if (index >= count) {
			addLast(newNode);
		} else if (index <= 0) {
			addFirst(newNode);
		} else {
			curent = this.first;
			for (int i = 0; i < index; i++) {
				curent = curent.getNext();

			}
			newNode.setNext(curent.getNext());
			newNode.setPrevious(curent);
			curent.getNext().setPrevious(newNode);
			curent.setNext(newNode);
			count++;
		}

	}

	public boolean removeObj(NodeDoubleLinkedList location) {

		NodeDoubleLinkedList curent = this.first;
		NodeDoubleLinkedList Previous = null;
		if (count == 0) {
			return false;
		} else {
			while (!(curent.equals(location))) {
				Previous = curent;
				curent = curent.getNext();

			}
			if (curent.equals(last)) {
				Previous.setNext(this.first);
				this.last = Previous;
			} else if (curent.equals(first)) {
				this.last.setNext(curent.getNext());
				first = curent.getNext();
				first.setPrevious(this.last);

			} else {
				Previous.setNext(curent.getNext());
				curent.getNext().setPrevious(Previous);
				curent.setNext(null);
				curent.setPrevious(null);
			}

			count--;
		}

		return true;
	}

	// in this method we need to remove first node in double linked list
	@Override
	public boolean removeFirst() {

		NodeDoubleLinkedList temp = this.first;
		if (count == 0) {
			return false;
		} else if (count == 1) {
			this.first = this.last = null;

		} else {
			this.first = this.first.getNext();
			this.last.setNext(this.first);
			this.first.setPrevious(last);
			temp.setNext(null);
		}
		count--;
		return true;
	}

	// in this method we need to remove last node in double linked list
	@Override
	public boolean removeLast() {
		NodeDoubleLinkedList temp = this.first;
		if (this.count == 0) {
			return false;
		} else {
			for (int i = 0; i < count; i++) {
				temp = temp.getNext();
			}

			temp.setNext(this.first);
			this.first.setPrevious(temp);
			temp = this.last;
			this.last.setNext(null);

		}
		count--;
		return true;
	}

	// in this method we need to remove last node in double linked list
	@Override
	public boolean removeAt(int index) {

		NodeDoubleLinkedList temp = this.first;
		NodeDoubleLinkedList prev = null;

		if (index == 0) {
			return removeFirst();
		} else if (index == count) {
			return removeLast();

		} else if (index > count) {
			return false;
		} else if (index < 0) {
			return false;
		} else {
			for (int i = 0; i < index; i++) {
				temp = temp.getNext();
				prev = temp;
			}

			temp.setPrevious(prev.getPrevious());
			prev.getPrevious().setNext(prev.getNext());
			prev.setPrevious(null);
			prev.setNext(null);
			count--;
			return true;
		}
	}

	
	// in this method to search for specific node by location
	@Override
	public NodeDoubleLinkedList search(String name) {
		NodeDoubleLinkedList temp = this.first;
		for (int i = 0; i < count; i++) {
			if (temp.getLocation().equalsIgnoreCase(name)) {
				return temp;
			}
			temp = temp.getNext();
		}
		return null;
	}
	

	// in this method to store info from file in double linkedList sorted
	@Override
	public void addNodeSorted(NodeDoubleLinkedList newNode) { // O(n)
		if (count == 0 && newNode != null) { //nothing any node and new node not empty
			addFirst(newNode);
		} else {
			if (newNode != null) { //not empty
				NodeDoubleLinkedList current = this.first;
				NodeDoubleLinkedList previous = null;
				if (newNode.compareTo(current) < 0) {
					addFirst(newNode);
				} else {
					int count = 0;
					while ((count != this.count) && (newNode.compareTo(current) > 0)) {
						previous = current;
						current = current.getNext();
						count++;
					}
					if (count == this.count) { //at the end list
						this.addLast(newNode);
					} else {
						newNode.setNext(current);
						newNode.setPrevious(previous);
						current.setPrevious(newNode);
						previous.setNext(newNode);
						this.count++;
					}
				}
			}
		}
	}

	
	
	// print list
	@Override
	public void printList() {
		NodeDoubleLinkedList temp = this.first;
		if (count == 0) {
			return;
		}
		for (int i = 0; i < count; i++) {
			System.out.println(temp.toString());
			temp = temp.getNext();
		}
	}
	

	// to return who many node;
	@Override
	public int size() {
		return count;

	}

	@Override
	public String toString() {
		return "DoublyLinkedList [first=" + first + ", last=" + last + ", count=" + count + "]";
	}

}
