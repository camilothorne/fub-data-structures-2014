package wernerLists;


// Generic List data structure/type/class 

public class  ListB<E> {
	
	// A. Only feature: a root

	public NodeB<E> root;

	// B. Constructor
	
	public ListB(NodeB<E> root) {
		this.root = root;
	}

	// C. Methods
	
	public boolean isEmpty() {
		return (root == null);
	}

	public void insertFirst(NodeB<E> node) {
		node.next = this.root;
		root = node;
	}

	public void insertFirst(E v) {
		NodeB<E> node = new NodeB<E>(v);
		insertFirst(node);
	}

	public void insertLast(NodeB<E> node) {
		if (root == null) {
			root = node;
		} else {
			NodeB<E> p = root;
			while (p.next != null) {
				p = p.next;
			}
			p.next = node;
		}
	}

	public void insertLast(E v) {
		NodeB<E> node = new NodeB<E>(v);
		insertLast(node);
	}

	public void deleteFirst(E v) {
		if (root == null) {
			return;
		} else if (root.val == v) {
			root = root.next;
		} else {
			NodeB<E> p = root;
			while (p.next != null && p.next.val != v) {
				p = p.next;
			}
			if (p.next != null) {
				p.next = p.next.next;
			}
		}
	}
	
	public NodeB<E> find(E v){
		return findAux(this.root,v);
	}
	
	public NodeB<E> findAux(NodeB<E> node, E v){
		if (node == null){
			return null;
		} else if (node.val == v){
			return node;
		} else {
			return findAux(node.next, v);
		}
	}
	
	public void insertTail(NodeB<E> node){
		if (isEmpty()){
			root = node;
		} else {
			insertTailAux(root,node);
		}
	}
	
	public void insertTailAux(NodeB<E> first, NodeB<E> node){
		if (first.next == null){
			first.next = node;
		} else  {
			insertTailAux(first.next, node);
		}
	}


	public void deleteAll(E v) {
		if (root == null) {
			return;
		} else if (root.val == v) {
			root = root.next;
		} else {
			NodeB<E> p = root;
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
		NodeB<E> p = root;
		while (p != null) {
			System.out.print(p.val.toString() + " ");
			p = p.next;
		}
		System.out.println("\n");
	}

	public ListB<E> buildFromArray(E A[]) {
		NodeB<E> root = null;
		if (A.length > 0) {
			root = new NodeB<E>(A[0]);
			NodeB<E> p = root;
			for (int i = 1; i < A.length; i++) {
			p.next = new NodeB<E>(A[i]);
			p = p.next;
			}
		}
		return new ListB<E>(root);
	}

	public ListB<E> clone() {
		NodeB<E> rootClone = null;
		if (this.root != null) {
			rootClone = new NodeB<E>(this.root.val);
			NodeB<E> p = this.root;
			NodeB<E> pClone = rootClone;
			while (p.next != null) {
				pClone.next = new NodeB<E>(p.next.val);
				p = p.next;
				pClone = pClone.next;
			}
		}
		return new ListB<E>(rootClone);
	}

	public void reverse() {
		NodeB<E> p = this.root;
		this.root = null;
		while (p != null) {
			NodeB<E> q = p.next;
			this.insertFirst(p);
			p = q;
		}
	}
	
	public int length(){
		NodeB<E> p = this.root;
		int count = 0;
		while (p != null){
			p = p.next;
			count++;
		}
		return count;
	}
	
	// C. Sorting:
	//
	// To be instantiated in a subclass
	// where E is set to an existing, comparable type!
	
	public void insertSorted(NodeB<E> node){}
	
	public void insertionSort(){};
	

}

