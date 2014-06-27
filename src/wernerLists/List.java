package wernerLists;


public class List{
	
	Node root;

	public List(Node root) {
		this.root = root;
	}

	public boolean isEmpty() {
		return (root == null);
	}

	public void insertFirst(Node node) {
		node.next = root;
		root = node;
	}

	public void insertFirst(int v) {
		Node node = new Node(v);
		insertFirst(node);
	}

	public void insertLast(Node node) {
		if (root == null) {
			root = node;
		} else {
			Node p = root;
			while (p.next != null) {
				p = p.next;
			}
			p.next = node;
		}
	}

	public void insertLast(int v) {
		Node node = new Node(v);
		insertLast(node);
	}

	public void insertSorted(Node node) {
		if (root == null) {
			root = node;
			node.next = null;
		} else if (node.val < root.val) {
			node.next = root;
			root = node;
		} else {
			Node p = root;
			int v = node.val;
			while (p.next != null && p.next.val <= v) {
				p = p.next;
			}
			// insert new node after p
			node.next = p.next;
			p.next = node;
		}
	}

	public void deleteFirst(int v) {
		if (root == null) {
			return;
		} else if (root.val == v) {
			root = root.next;
		} else {
			Node p = root;
			while (p.next != null && p.next.val != v) {
				p = p.next;
			}
			if (p.next != null) {
				p.next = p.next.next;
			}
		}
	}
	
	public Node find(int v){
		return findAux(this.root,v);
	}
	
	public static Node findAux(Node node, int v){
		if (node == null){
			return null;
		} else if (node.val == v){
			return node;
		} else {
			return findAux(node.next, v);
		}
	}
	
	public void insertTail(Node node){
		if (isEmpty()){
			root = node;
		} else {
			insertTailAux(root,node);
		}
	}
	
	public static void insertTailAux(Node first, Node node){
		if (first.next == null){
			first.next = node;
		} else  {
			insertTailAux(first.next, node);
		}
	}


	public void deleteAll(int v) {
		if (root == null) {
			return;
		} else if (root.val == v) {
			root = root.next;
		} else {
			Node p = root;
			while (p.next != null) {
				while (p.next != null && p.next.val != v) {
					p = p.next;
				}
				if (p.next != null) {
					p.next = p.next.next;
				}
			}
		}
	}

	public void printAll() {
		System.out.print("List values: ");
		Node p = root;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.flush();
	}

	public static List buildFromArray(int A[]) {
		Node root = null;
		if (A.length > 0) {
			root = new Node(A[0]);
			Node p = root;
			for (int i = 1; i < A.length; i++) {
				p.next = new Node(A[i]);
				p = p.next;
			}
		}
		return new List(root);
	}

	public List clone() {
		Node rootClone = null;
		if (this.root != null) {
			rootClone = new Node(this.root.val);
			Node p = this.root;
			Node pClone = rootClone;
			while (p.next != null) {
				pClone.next = new Node(p.next.val);
				p = p.next;
				pClone = pClone.next;
			}
		}
		return new List(rootClone);
	}

	public void reverse() {
		Node p = this.root;
		this.root = null;
		while (p != null) {
			Node q = p.next;
			this.insertFirst(p);
			p = q;
		}
	}

	public void insertionSort() {
		Node p = this.root;
		this.root = null;
		while (p != null) {
			Node q = p.next;
			this.insertSorted(p);
			p = q;
		}
	}
	
	public int length(){
		Node p = this.root;
		int count = 0;
		while (p != null){
			p = p.next;
			count++;
		}
		return count;
	}
	

}
