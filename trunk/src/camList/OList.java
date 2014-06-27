package camList;


// An ordered list is a list where
// nodes are inserted always in order
public class OList extends List{

	Node root;
	
	public OList(Node root){
		super(root);
	}
	
	void insert(Node n){
		this.addSorted(n);
	}
	
}
