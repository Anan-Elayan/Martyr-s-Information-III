package Project;

public interface MethodsDoubleLinkedList {
	public NodeDoubleLinkedList getFirt();
	public NodeDoubleLinkedList getLast();
	public void addFirst(NodeDoubleLinkedList newNode);
	public void addLast(NodeDoubleLinkedList newNode);
	public void add(NodeDoubleLinkedList newNode, int index);
	public boolean removeFirst();
	public boolean removeLast();
	public boolean removeAt(int index);
	public NodeDoubleLinkedList search(String name);
	public void addNodeSorted(NodeDoubleLinkedList newNode);
	public void printList();
	public int size();
	


}
