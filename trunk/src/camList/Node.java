package camList;

// nodes
public class Node {

	// fields
	public int val;
	public Node next;
	
	// Constructors
	public Node(){}

	public Node(int i){
		this.val = i;
	}
	
	void myprint(){
		System.out.println(this.val);
	}
			
}
