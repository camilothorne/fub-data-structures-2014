package camTree;


public class BinTree {

	
	// fields
	NodeTree root;
	
	
	// constructor
	public BinTree(NodeTree n){
		this.root = n;
	}
	
	
	// 1. Methods
	
	
	void  InorderTreeWalk(){
		 InorderTreeWalk(this.root);
	}	
	
	void InorderTreeWalk(NodeTree n){
		if (n != null) {
			InorderTreeWalk(n.left);
			System.out.print(n.key + " ");
			InorderTreeWalk(n.right);
		}
	}
	
	
	NodeTree Search(int k){
		return Search(this.root, k);
	}
	
	
	NodeTree Search(NodeTree n, int k){
		if (n == null){
			return null;
		}
		if (k == n.key){
			return n;
		}
		if (k < n.key){
			return Search(n.left,k);
		}else{
			return Search(n.right,k);
		}
	}
	
	
	NodeTree TreeMin(){
		return TreeMin(this.root);
	}

	
	NodeTree TreeMin(NodeTree n){
		while(n.left != null){
			n = n.left;
		}
		return n;
	}

	
	NodeTree TreeMax(){
		return TreeMax(this.root);
	}	
	
	
	NodeTree TreeMax(NodeTree n){
		while(n.right != null){
			n = n.right;
		}
		return n;
	}	
	
	
	NodeTree TreeSuccessor(NodeTree n){
		if (n.right != null){
			return TreeMin(n.right);
		}
		NodeTree m = n;
		while (m.parent != null && m == m.parent.right){
			m = m.parent;
		}
		return m;
	}
	
	
	void TreeInsert(NodeTree n){
		TreeInsert(this.root,n);
	}
	
	
	void TreeInsert(NodeTree root, NodeTree n){
		NodeTree x = root;
		NodeTree y = null;
		while (x != null){
			y = x;
			if (x.key < n.key){
				x = x.right;
			}else{
				x = x.left;
			}
		}
		if (y == null){
			root = n;
			n.parent = null;
		}else{
			if(y.key < n.key){
				y.right = n;
			}else{
				y.left = n;
			}
		}
		n.parent = y;
	}
	
	
	void TreeSort(int[] A){
		NodeTree t = null;
		for (int i=0;i<A.length;i++){
			TreeInsert(t, new NodeTree(A[i]));
		}
		InorderTreeWalk(t);
	}

	
	NodeTree delete(NodeTree n){
		return delete(this.root, n);
	}
	
	
	NodeTree delete(NodeTree root, NodeTree n){
		
		NodeTree front = root;
		NodeTree rear 	= null;
		
		while(front != null){
			if (n.key < front.key) front = front.left;
			else front = front.right;
		}
		
		if (n.right == null){
			if (rear == null) root = n.left;
			else if(rear.left == n) rear.left = n.left;
			else rear.right = n.left;
		}
		else if(n.left == null){
			if (rear == null) root = n.right;
			else if (rear.left == n) rear.left = n.right;
			else rear.right = n.right;  
		}
		else{
			
			NodeTree succ = n.right;
			NodeTree srear = succ;
			
			while(succ.left !=null){
				srear = succ; succ = succ.left;
			}
			
			if (rear == null) root = succ;
			else if (rear.left == n) rear.left = succ;
			else rear.right = succ;
			
			succ.left = n.left;
			if (srear != succ) {
				srear.left = succ.right; 
				succ.right = n.right;
			}
		}
		
	return root;
	
	}
	
	
	public static BinTree buildSorted(int A[]){
		BinTree t = new BinTree(new NodeTree());
		for (int i=0;i<A.length;i++){
			t.TreeInsert(new NodeTree(A[i]));
		}
		return t;
	}
	
	
	// 2. Lab 7
	
	
	// recursive successor (with parent) - OK
	NodeTree succRec(NodeTree n){
		if (n.right != null){
			return minRec(n.right);
		}else{
			if(n.parent != null && n == n.parent.right){
				return succRec(n.parent);
			}else{
				return null;
			}
		}
	}	
	

	// recursive min - OK
	NodeTree minRec(NodeTree n){
		if (n.left == null){
			return n;
		}else{
			return minRec(n.left); 
		}
	}
	
	
	// min of the complete tree - OK
	NodeTree minRec(){
		return minRec(this.root);
	}
	
	
	// recursive successor (without parent) - OK
	NodeTree succRecB(NodeTree n){
		if (n.right != null){
			return minRec(n.right);
		}else{
			NodeTree m = new NodeTree();
			TreeWalk(this.root,n,m);
			return m;
		}
	}		
	
	
	// auxiliary path function - OK
	void TreeWalk(NodeTree n, NodeTree m, NodeTree res){
		if (n!=null) {		
			TreeWalk(n.left,m,res);
			if (n.key > m.key && res.key == 0){
					res.key = n.key;
					res.right = n.right;
					res.left = n.left;
			}
			TreeWalk(n.right,m,res);
		}
	}
	
	
	// 2. Lab 7 : Breadth-first traversal
	
	
	void breadthFirst(){
		Queue qe = new Queue();
		qe.enqueue(this.root);	
		while(!qe.isEmpty()){
			qe.dequeue();
		}
	}
	
	
	// 2. Lab 8 : Balanced binary trees
	
	
	int balanced(){
		return balanced(this.root);
	}
	
	
	int balanced(NodeTree n){
		if (n.right == null && n.left == null){
			return n.key;
		}else if (n.right == null){
			return balanced(n.left);
		}else if (n.left == null){
			return balanced(n.right);
		}else{
			return Math.abs(balanced(n.right) - balanced(n.left));
		}
	}
	
	
	// 3. Testing
	
	
	// main method for testing
	public static void main(String[] args){
		
		int[] testArray = { 44, 55, 12, 33, 42, 94, 44, 18, 6, 67, 86, 41, 19, 4, 48, 32, 68 };
		
		BinTree sort = buildSorted(testArray);	
		NodeTree n = new NodeTree(7);	
		sort.TreeInsert(n);
		
		System.out.print("inorder (depth-first) walk: ");
		sort. InorderTreeWalk();
		System.out.println();		
		
		NodeTree max = sort.TreeMax();		
		System.out.println("max: "+max.key);		
		NodeTree min = sort.TreeMin();
		System.out.println("min: "+min.key);
		NodeTree minr = sort.minRec();
		System.out.println("min (rec): "+minr.key);		
		
		NodeTree m = sort.Search(12);
				
		NodeTree s3 = sort.TreeMin(m);
		System.out.println("min of node 12: "+s3.key);
		
		NodeTree s4 = sort.minRec(m);
		System.out.println("min of node 12 (rec): "+s4.key);
		
		NodeTree s1 = sort.TreeSuccessor(m);
		System.out.println("succ of node 12: "+s1.key);
		
		NodeTree s2 = sort.succRec(m);
		System.out.println("succ of node 12 (rec): "+s2.key);		
		
		NodeTree s5 = sort.succRecB(m);
		System.out.println("succ of node 12 (no parent): "+s5.key);		
	
		System.out.print("breadth-first walk: ");
		sort.breadthFirst();

		System.out.print("\nbalance: ");
		System.out.print(sort.balanced());		
		
	}
	
	
}
