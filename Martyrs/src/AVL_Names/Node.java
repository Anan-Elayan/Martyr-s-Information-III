package AVL_Names;
import AVL2_DATES.Martyrs;

public class Node {
	
	Martyrs data ;
	Node left,reight;
	int height;
	
	
	public Node (Martyrs data) {
		this.data=data;
		
		
	}


	public Martyrs getData() {
		return data;
	}


	public void setData(Martyrs data) {
		this.data = data;
	}


	public Node getLeft() {
		return left;
	}


	public void setLeft(Node left) {
		this.left = left;
	}


	public Node getReight() {
		return reight;
	}


	public void setReight(Node reight) {
		this.reight = reight;
	}


	@Override
	public String toString() {
		return "Martyrs [data=" + data + "]";
	}
	
	

}
