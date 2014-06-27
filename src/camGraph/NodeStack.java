package camGraph;


import wernerLists.NodeB;


// queue for BFT
public class NodeStack extends GNodeList{
	
	
	// field already in superclass!!!

	
	// constructor	
	public NodeStack(NodeB<Vertex> root) {
		super(root);
	}
	
	
	// push:
	// adds vertex to top of the queue
	public void push(Vertex v){
		// add vertex to the top of the stack
		NodeB<Vertex> node = new NodeB<Vertex>(v);
		//this.printVertex();
		insertTop(node);
		//this.printVertex();
	}
	
	
	// auxiliary function
	public void insertTop(NodeB<Vertex> node) {
		node.next = this.root;
		root = node;
	}	

	
	// pop:
	// removes the *top* element
	public void pop(){
		//NodeB<Vertex> tmp = new NodeB<Vertex>(null);
		if (root != null){
			NodeB<Vertex> p = this.root;
			//tmp.val = p.val;
			if (p.val.color == 'b'){
				this.root = p.next;
			}
		}
		//return tmp.val;
	}
	
	
	// pop:
	// removes and returns the *top* element
	public Vertex popRet(){
		NodeB<Vertex> tmp = new NodeB<Vertex>(null);
		if (root != null){
			NodeB<Vertex> p = this.root;
			tmp.val = p.val;
			this.root = p.next;
		}
		return tmp.val;
	}	
	
	
	// returns the head of the queue
	public Vertex popHead(){
		if (root != null){
				return root.val;
		}else{
			return null;
		}
	}
	
	/*
	// pop head:
	// returns the *top* element
	public Vertex popHead(){
		NodeB<Vertex> tmp = new NodeB<Vertex>(null);
		if (root != null){
			NodeB<Vertex> p = this.root;
			tmp.val = p.val;
		//	this.root = p.next;
		}
		return tmp.val;
	}*/
	
	
}

