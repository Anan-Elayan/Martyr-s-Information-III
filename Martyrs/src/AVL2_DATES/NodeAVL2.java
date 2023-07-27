package AVL2_DATES;

public class NodeAVL2 {
	
	DateStack data ;
	NodeAVL2 left,reight;
	int height;
	
	
	public NodeAVL2 (DateStack data) {
		this.data=data;
		
	}


	public DateStack getData() {
		return data;
	}


	public void setData(DateStack data) {
		this.data = data;
	}


	public NodeAVL2 getLeft() {
		return left;
	}


	public void setLeft(NodeAVL2 left) {
		this.left = left;
	}


	public NodeAVL2 getReight() {
		return reight;
	}


	public void setReight(NodeAVL2 reight) {
		this.reight = reight;
	}


	@Override
	public String toString() {
		return "Martyrs [data=" + data + "]";
	}
	
	

}
