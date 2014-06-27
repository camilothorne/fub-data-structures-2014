package camGraph;


import wernerLists.NodeB;


// queue for BFT
public class NodeQueue extends GNodeList{
	
	
	// field already in superclass!!!

	
	// constructor	
	public NodeQueue(NodeB<Vertex> root) {
		super(root);
	}
	
	
	// enqueue:
	// adds vertex to queue
	public void enqueue(Vertex v){
		//this.printVertex();
		// add vertex to the end of the queue
		this.insertLast(v);
		//this.printVertex();
	}
	

	// pop:
	// removes and returns the *top* element
	public Vertex dequeueRet(){
		NodeB<Vertex> tmp = new NodeB<Vertex>(null);
		if (root != null){
			NodeB<Vertex> p = this.root;
			tmp.val = p.val;
			this.root = p.next;
		}
		return tmp.val;
	}		
	
	
	// dequeue:
	// removes the *first* element that was put 
	// in the queue
	public void dequeue(){
		//NodeB<Vertex> tmp = new NodeB<Vertex>(null);
		if (root != null){
			NodeB<Vertex> p = this.root;
			//tmp.val = p.val;
			this.root = p.next;
		}
		//return tmp.val;
	}
	
	
	// returns the head of the queue
	public Vertex popHead(){
		if (root != null){
				return root.val;
		}else{
			return null;
		}
	}
	
	// insert last
	public void insertLast(NodeB<Vertex> node) {
		if (root == null) {
			root = node;
		} else {
			NodeB<Vertex> p = root;
			while (p.next != null) {
				p = p.next;
			}
			p.next = node;
		}
	}

}
