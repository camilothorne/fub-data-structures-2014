package camGraph;


public class DAGTest{
	
	
	// contains only a main method for testing
	public static void main(String[] args){
		
		
		//=============================//
		// (my graph)
		//=============================//		
		
		
		System.out.println("============");
		System.out.println("============\n");
		
		// start from empty graph
		DAG f = new DAG();
		
		// add edges and vertexes
		// to graph (note that for topological sorting
		// to work, digraphs must be acyclic, i.e.,
		// the edge 8--> 8 must be removed from
		// the graph
		
		f.addEdgeG(10,8);
		f.addEdgeG(7,5);
		f.addEdgeG(7,8);
		f.addEdgeG(8,9);
		f.addEdgeG(10,1);
		f.addEdgeG(1,8);
		f.addEdgeG(11,15);
		
		// print size of V
		System.out.println("size = " + f.nodes.size());				
		// print V
		f.nodes.printVertex();
		
		// print edges of graph
		f.printToFile("/home/camilo/graphs-dsa-2014/graph-adj.txt");
		
		//=============================//
		
		System.out.println("\n====BFT=====\n");
		
		// BST
		f.breadthFirst();
		
		//=============================//		
		
		// (works!)
		
		System.out.println("\n====DFT=====\n");
		
		// DFT of graph
		f.depthFirst();	

		// topological sort
		f.topologicalSort();	
		
		//=============================//
		
		System.out.println("\n====IDFT====\n");
		
		// Iterative DFT of graph
		f.depthFirstIter();

		
		//=============================//
		// (graph from file)
		//=============================//		
		
		
		System.out.println("\n============");
		System.out.println("============\n");
		
		// load another graph from a file
		DAG g = new DAG("/home/camilo/graphs-dsa-2014/graph.txt");
		
		// print edges of graph
		g.printToFile("/home/camilo/graphs-dsa-2014/graph-adj.txt");
		
		//=============================//		
		
		System.out.println("\n====DFT=====\n");
		
		// (works!)
		
		// DFT of graph
		//g.depthFirst();
		
		// topological sort
		//g.topologicalSort();
		
		//=============================//
		
		System.out.println("\n====IDFT====\n");
		
		// Iterative DFT of graph
		g.depthFirstIter();	
		
		// topological sort
		g.topologicalSort();
		
		//=============================//
		
		System.out.println("\n====BFT=====\n");
		
		// BFT
		g.breadthFirst();	
		
	}
	

}
