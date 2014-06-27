package camGraph;


// Simple nodes
import camList.Node;


//Vertexes are an extension of simple nodes
class Vertex extends Node{

	
	int id; // id
	char color; // w,g,b (white/grey,black)
	GNodeList succ; // O^+(v)
	Vertex pred; // pred in spanning tree
	int start; // init time (for DFS)
	int end; // end time (for DFS) 
	int dist = Integer.MAX_VALUE; // dist (init to infty)

	
	// constructor
	public Vertex(int id){
		super.val=this.id;
		this.id = id;
		this.succ = new GNodeList(null);
	}
	
	
}
