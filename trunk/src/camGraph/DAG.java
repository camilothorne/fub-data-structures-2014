package camGraph;


// We use Java I/O functions to
// manipulate files
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.IOException;


// We use generic lists and nodes, 
// instantiated to
// lists and nodes of strings
import wernerLists.NodeB;


// Custom file writer
import rw.Append;


// We use array sorting methods
import camSort.ArrayUtility;


// Directed graphs


public class DAG {
	
	
	// a DAG is an adjacency list of vertexes
	//
	// N.B. in this case, succ and pred
	// need to be initialized
	GNodeList nodes;	
	
	// measuring time (search)
	int t;
	
	// Topological sort 
	// (works if G is acyclic)
	GNodeList sorted;
	
	// A. Constructors
	
	
	// empty graph
	public DAG(){
		nodes = new GNodeList(null);
	}
	
	
	// graph built from file
	public DAG(String path){
		nodes = new GNodeList(null);
		readFromFile(path);
		// print size of V
		System.out.println("size = " + this.nodes.size());				
		// print V
		nodes.printVertex();
	}
	
	
	// graph built from adjacency list
	public DAG(GNodeList nodes){
		this.nodes = nodes;
	}
	
	
	// B. Methods
	
	
	// return out degree of vertex v
	static int outDegree(Vertex v){
		return v.succ.length();
	}

		
	// order ot degrees
	static int[] sortDeg(GNodeList V){
		int[] deg = new int[V.length()];
		NodeB<Vertex> n = V.root;
		for (int i = 0; i< deg.length; i++){
			deg[i] = outDegree(n.val);
			n = n.next;
		}
		// we use quicksort to sort degrees
		// (to sort the vertexes directly we
		// need to reimplement quicksort)
		int[] sor = ArrayUtility.quickSort(deg);
		return sor;
	}
	
	
	// graph max out degree
	static int maxDegree(GNodeList V){
		int[] sor = sortDeg(V);
		return sor[V.length()-1];
	}
	
	
	// graph min out degree
	static int minDegree(GNodeList V){
		int[] sor = sortDeg(V);
		return sor[0];
	}	
	
	
	// add an edge in the graph among id's i and j
	void addEdgeG(int i, int j){
		nodes.addEdge(i,j);
	}

	
	// add a vertex with id i to the graph 
	void addNodeG(int i){
		nodes.addNode(new Vertex(i));
	}	
	
	
	// add a vertex v in the graphi
	void addNodeG(Vertex v){
		nodes.addNode(v);
	}
	
	
	// read a graph from a file
	void readFromFile(String path){
		FileInputStream file; // file byte stream/channel 
		String data; // line of string buffer
		try{
			// open channel and create buffer
			file = new FileInputStream(path);
			BufferedReader reader = new BufferedReader(new FileReader(path));
			// add edge (i,j) to current graph
			while((data = reader.readLine()) != null){
				//System.out.println(data);
				String[] nodes = data.split(",");
				int i = Integer.parseInt(nodes[0]);
				int j = Integer.parseInt(nodes[1]);	
				addEdgeG(i,j);
			}
			// close channel and destroy buffer
			file.close();
		}
		// catch IO Exception
		catch(IOException ex){
			 ex.printStackTrace();
		}
	}
	
	
	// print graph to file
	void printToFile(String path){
		// adjacency list
		NodeB<Vertex> n = nodes.root;
		// to save graph
		String data1 = "";	
		System.out.println();
		// loop over graph nodes
		while(n!=null){			
			// retrieve node id
			int i = n.val.id;
			// retrieve successors
			NodeB<Vertex> m = n.val.succ.root;
			data1 = data1+ i+":";// nodes
			String data2 = "";// successors
			// loop over edges if successors not empty
			while(m!=null){
				// retrieve node id
				int j = m.val.id;
				// write succs on file
				data2 = data2 + j + ",";
				// move on
				m = m.next;
			}
			data1 = data1 + data2 + "\n";				
			// move on
			n = n.next;
		}
		System.out.print(data1);
		//new Append(path,data1);
	}
	
	
	// C. Traversals

		
	// C1. DFT (all nodes)
	
	
	// depth-first graph traversal
	void depthFirst(){
		sorted	= new GNodeList(null);
		NodeB<Vertex> l = this.nodes.root;
		while (l!=null){
			l.val.color = 'w';
			l.val.pred = null;
			l = l.next;
		}
		t = 0;
		NodeB<Vertex> m = this.nodes.root;		
		while (m!=null){
			if(m.val.color == 'w'){
				depthFirst(m.val);
			}
			m = m.next;
		}
		spanningTree(nodes,"DFT");
	}
	
	
	// depth-first graph traversal rooted at vertex v	
	void depthFirst(Vertex v){
		v.color = 'g';
		t = t + 1;
		v.start = t;
		NodeB<Vertex> l = v.succ.root;
		while (l!=null){
			Vertex u = l.val;
				if (u.color == 'w'){
					u.pred = v;
					depthFirst(u);
				}
			l = l.next;
		}
		v.color = 'b';
		sorted.addNode(v);
		t = t+1;
		v.end = t;
	}

					
	// C2. BFT (from first node)
	
	
	void breadthFirst(){
		NodeB<Vertex> m = this.nodes.root;
		breadthFirst(m.val);
		spanningTree(this.nodes,"BFT");
	}
	
	
	// breadth-first graph traversal rooted at vertex v of id i	
	void breadthFirst(Vertex s){
		NodeB<Vertex> l = this.nodes.root;
		while (l!=null){
			l.val.color = 'w';
			l.val.pred = null;
			l = l.next;
		}
		s.color = 'g';
		s.dist = 0;
		NodeQueue q = new NodeQueue(new NodeB<Vertex>(s));
		while (!q.empty()){
				Vertex v = q.dequeueRet();
				NodeB<Vertex> m = v.succ.root;			
				while (m!=null){
					Vertex u = m.val;
					if (u.color == 'w'){
							u.color = 'g';
							u.dist = u.dist + 1;
							u.pred = v;
							q.enqueue(u);
					}
					m = m.next;
				}
				v.color = 'b';
		}
	}
	
	
	// C3. Iterative DFT (all nodes)
	
	
	// iterative DFT
	void depthFirstIter(){
		sorted	= new GNodeList(null);
		NodeB<Vertex> l = this.nodes.root;
		while (l!=null){
			l.val.color = 'w';
			l.val.pred = null;
			l = l.next;
		}
		t = 0;
		NodeB<Vertex> m = this.nodes.root;		
		while (m!=null){
			if(m.val.color == 'w'){
				depthFirst(m.val);
			}
			m = m.next;
		}
		spanningTree(this.nodes,"iterativeDFT");
	}
	
	
	// depth-first graph traversal with explicit stack	
	void depthFirstIter(Vertex s){
		s.color = 'g';
		t = t + 1;
		s.start = t;
		NodeStack q = new NodeStack(new NodeB<Vertex>(s));
		while (!q.empty()){
				Vertex v = q.popRet();
				NodeB<Vertex> m = v.succ.root;			
				while (m!=null){
					Vertex u = m.val;
					if (u.color == 'w'){
						u.color = 'g';
						u.pred = v;						
						q.push(u);
					}
					m = m.next;
				}
				v.color = 'b';
				sorted.addNode(v);
				t = t+1;
				v.end = t;
		}
	}		
	
	
	// C.4 Spanning tree
	
	
	// Compute and save spanning tree
	public void spanningTree(GNodeList nodes, String type){
		NodeB<Vertex> n = nodes.root;
		DAG tree = new DAG();
		while(n!=null){
			if (n.val.pred != null){
				tree.addEdgeG(n.val.pred.id,n.val.id);
				System.out.println(n.val.pred.id+","+n.val.id);
			}
			n = n.next;
		}
		tree.printToFile("/home/camilo/graphs-dsa-2014/tree"+type+".txt");
	}
	
	
	// C.5 Topological sort (if graph is acyclic)	
	
	
	// topological sort
	void topologicalSort(){
			sorted.reverseV();
			System.out.println("\ntopological sort:");
			sorted.printVertex();		
	}	
	
	
	
}

