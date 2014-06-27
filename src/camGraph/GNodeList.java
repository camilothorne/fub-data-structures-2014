package camGraph;


// We use generic lists and nodes, 
// instantiated to
// lists and nodes of strings
import wernerLists.ListB;
import wernerLists.NodeB;


// A vertex list is a kind of list
class GNodeList extends ListB<Vertex>{
	
	
	// pointer to the root
	NodeB<Vertex> root;
	
	
	// constructor 
	// (notice that null is a node list node/element too)
	public GNodeList(NodeB<Vertex> root){
		super(root);
		this.root = root;
	}
	

	// insert a vertex v in vertex list l only if it is new
	public void addNodeB(GNodeList l, Vertex v){
		NodeB<Vertex> n = new NodeB<Vertex>(v);
		if (findAuxB(l.root,v)==false){
			insertB(l,n);
		}
	}
	
	// insert a node n in list l only if it is new
	public void insertB(GNodeList l, NodeB<Vertex> node) {
		if (l.root == null) {
			l.root = node;
		} else {
			NodeB<Vertex> p = l.root;
			while (p.next != null) {
				p = p.next;
			}
			p.next = node;
		}
	}	
	
	
	// insert a vertex at the end of vertex list
	public void addNode(Vertex v){
		NodeB<Vertex> n = new NodeB<Vertex>(v);
		if (findB(v)==false){
			insert(n);
		}
	}
	
	
	// insert a node in the tail of the list
	public void insert(NodeB<Vertex> node) {
		if (this.root == null) {
			this.root = node;
		} else {
			NodeB<Vertex> p = this.root;
			while (p.next != null) {
				p = p.next;
			}
			p.next = node;
		}
	}
	
	
	// check is node list is empty
	public boolean empty() {
		return (root == null);
	}
	
	
	// return size of node/vertex list
	public int size(){
		NodeB<Vertex> p = this.root;
		int count = 0;
		while (p != null){
			p = p.next;
			count++;
		}
		return count;
	}
	
	
	// print list of vertexes
	public void printVertex() {
		System.out.print("vertices: ");
		NodeB<Vertex> p = root;
		while (p != null) {
			System.out.print(p.val.id + " ");
			p = p.next;
		}
		System.out.println("");
	}
	
	
	// find or make node/vertex of id i
	Vertex findOrMake(int i){
		Vertex n = this.findOrMakeAux(this.root,i);
		return n;
	}
	
	
	// find node/vertex V of id i
	Vertex findOrMakeAux(NodeB<Vertex> node, int i){
		NodeB<Vertex> n = node;
		if (node == null){
			node = new NodeB<Vertex>(new Vertex(i));
			return node.val;
		}else{
			while (n!=null){
				if (n.val.id == i){
					return n.val;
				}
				n = n.next;
			}		
			n = new NodeB<Vertex>(new Vertex(i));
			return n.val;
		}
	}
	
	
	// reverse
	public void reverseV() {
		NodeB<Vertex> p = root;
		root = null;
		while (p != null) {
			NodeB<Vertex> q = p.next;
			this.insertFirstV(p);
			p = q;
		}
	}
	
	
	// insert first
	public void insertFirstV(NodeB<Vertex> node) {
		node.next = this.root;
		root = node;
	}
	
	
	// check if node/vertex of id i is already in graph
	boolean find(int i){
		return  this.findAux(this.root,i);
	}
	
	
	// check if node/vertex V of id i is in node list
	boolean findAux(NodeB<Vertex> node, int i){
		NodeB<Vertex> n = node;
		while (n!=null){
			if (node.val.id == i){
				return true;
			}
			n = n.next;
		}
		return false;
	}	
	
	
	// check if node/vertex v is already in graph
	boolean findB(Vertex v){
		return  this.findAuxB(root,v);
	}
	
	
	// check if node/vertex v is in node list
	boolean findAuxB(NodeB<Vertex> node, Vertex v){
		NodeB<Vertex> n = node;
		while (n!=null){
			if (n.val.id == v.id){
				return true;
			}
			n = n.next;
		}
		return false;
	}		
	
		
	// add edge to adjacency list of
	// vertexes, even when it is empty;
	// it operates in O(n^3) time as it:
	// 
	// (i)   checks if vertex i is in the list 
	// (ii)  checks if vertex j is in the list
	// (iii) checks if j is already a succ of i
	//
	void addEdge(int i, int j){		
		// if empty, add both
		if(root == null){
			Vertex v1 = new Vertex(i);
			Vertex v2 = new Vertex(j);		
			this.addNode(v1);
			v1.succ.addNode(v2);
			this.addNode(v2);
		// otherwise, check if i is in the list
		// and add j to its successors if it
		// wasn't there already;
		// if i was not in the list, add it
		}else{
			// iterate thru list:
			NodeB<Vertex> n = root; // iterator
			while (n.next!=null & n.val.id != i){
				n = n.next;
			}
			// vertex i might be in the list
			if (n.val.id == i){
				// check if j is already in the adjacency list
				Vertex v2 = findOrMake(j);	
				// add an element to the list only if
				// it is "fresh"
				addNodeB(n.val.succ,v2);						
				this.addNode(v2);
			// if not, we add it	
			}else{
				// create vertex
				Vertex v1 = new Vertex(i);
				// check if j is already in the adjacency list
				Vertex v2 = findOrMake(j);	
				// again, add avoiding repetitions
				addNodeB(v1.succ,v2);
				this.addNode(v1);
				this.addNode(v2);
			}
		}
	}
	
	
}
