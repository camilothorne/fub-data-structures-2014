package camilo;


// A. List implementation


// 1. nodes
class Node {

	
	// fields
	int val;
	Node next;
	
	
	// N.B. implicit constructor
	
	
	void myprint(){
		System.out.println(this.val);
	}
		
	
}


// 2. single-linked lists
class List {

	
	// root of the linked list
	Node head;
	
	
	// N.B. implicit constructor
	
	
	// Methods:
	
	
	// checks if a list is empty
	boolean isEmpty(){
		if (this.head == null){
			return true;
		}else{
			return false;
		}
	}
	
	
	// inserts value i on the head of the list
	void insertFirst(int i){
		Node p = new Node();
		p.val = i;
		p.next = this.head;
		this.head = p;
	}
	

	// inserts value i on the last node of the list
	void insertLast(int i){
		if (this.head == null){
			this.head = new Node();
			this.head.val = i;
			this.head.next = null;
		}else{
			Node q = this.head;
			while(q.next!=null){
				q = q.next;
			}
			q.next = new Node();
			q.next.val = i;
			q.next.next = null;
		}
	}	
	

	// inserts value i everywhere (replacing the existing ones)
	void insertAll(int i){
		if (this.head == null){
			this.head.val = i;
			this.head.next = new Node();
		}else{
			Node q = this.head;
			while(q!=null){
				q.val = i;			
				q = q.next;
			}
		}
	}		
	
	
	// removes all occurrences of value i in the list
	void removeAll(int i){
			Node q = this.head;// root
			while(q.next.next!=null){
				if (q.val == i){
					Node tmp = q.next;
					q.next = tmp.next;
					q.val = tmp.val;
				}else{			
					q = q.next;
				}
			}
			// we need to consider the
			// two possible tails of our list
			if (q.next.val == i){
				q.next.val = q.val;
				q.next = null;
			}
			if (q.val == i){
				Node tmp = q.next;
				q.next = tmp.next;
				q.val = tmp.val;
			}			
	}

		
	// removes the first occurence of value i in the list
	void removeFirst(int i){
		Node p = this.head;
		if (p.val == i){
			this.head = p.next;
		}else{
			while(p.next !=null && p.next.val != i){
				p = p.next;
			}
			Node tmp = p.next;
			p.next = tmp.next;
		}
	}

	
	// prints to stout/walks the list
	void myprint(){
		Node p = this.head;
		System.out.printf("[ ");
		while (p != null){
			System.out.printf("%d, ",p.val);
			p = p.next;
		}
		System.out.printf(" ]\n");
	}

	
	// returns the number of nodes of the list
	int mysize(){
		Node p = this.head;
		int count = 0;
		while (p != null){
			p = p.next;
			count = count + 1;
		}
		return count;
	}
	
	
	// reverses the list
	void reverse(){
		Node p = this.head;
		List rev = new List();
		while (p != null){
			rev.insertFirst(p.val);
			p = p.next;
		}
		this.head = rev.head;
	}
	
		
	// returns the node n containing value i
	Node find(int i){
		Node p = this.head;
		Node res = new Node();
		while (p != null){
			if (p.val == i){
				res.val = p.val;
				res.next = p.next;
				break;
			}
				p = p.next;
			}
		if (res.val != 0){
			return res;
		}else{
			return p; // returns the null/empty node
		}
	}
	
	
	// inserts a node n at the head of the list
	void addHead(Node n){
		Node p = this.head;
		n.next = p;
		this.head = n;
	}
	
	
	// returns the i-eth node of the list
	Node getNode(int pos){
		if (this.head == null){
			return null;
		}else{
			Node p = this.head;
			int j = 0;
			while(j < pos){
				p = p.next;
				j = j+1;
			}
			return p;
		}
	}
	

	// removes the i-eth node of the list
	void removeNode(int pos){
		if (this.head != null){
			Node p = this.head;
			int j = 0;
			while(j < pos){
				p = p.next;
				j = j+1;
			}
			Node tmp = p.next;
			p.next = tmp.next;
		}
	}	
	
		
	// inserts a node n at the tail of the list
	void addTail(Node n){
		if (this.head==null){
			this.head = n;
		}else{
			Node q = this.head;
			while(q.next!=null){
				q = q.next;
			}
			q.next = new Node();
			q.next.val = n.val;
			q.next.next = n.next;
		}
	}
		
	
	// inserts a node n w.r.t. value ordering
	void addSorted(Node n){
		if (this.head==null){
			this.head = n;
		}else{
			Node q = this.head;
			List rest = new List();
			while(q!=null && q.val <= n.val){
				rest.insertLast(q.val);
				q = q.next;
			}
			n.next = q;
			rest.addTail(n);
			this.head = rest.head;
		}
	}	
	
	
	// pops out the head of the current list
	Node popHead(){
		Node tmp = new Node();
		if (this.head != null){
			Node p = this.head;
			tmp.val = p.val;
			this.head = p.next;
		}
		return tmp;
	}
	
	
	// appends a list l to the current list
	void addAll(List l){
		Node q = new Node();
		q.val = l.head.val;
		q.next = l.head.next;
		if (this.head == null){
			this.head.val = q.val;
			this.head.next = q.next; 
		}else{
			Node p = this.head;
			while (p.next !=null){
				p = p.next;
			}
			p.next = q;
		}
	}		
		
	
	// Sorting:
	
	
	// swapping (single-liked list)
	void swap(Node current, Node innerCurrent) {
		// we swap values, not pointers, in lists
		Node temp = new Node();
		temp.val = current.val;
		current.val = innerCurrent.val;
		innerCurrent.val = temp.val;
	}
	
	
	// insertion sorting (single-liked list)
	void insertSort() {
		  Node current = this.head;
		  while(current!= null) {
		    Node innerCurrent = current.next;
		       while(innerCurrent != null) {
		          if(innerCurrent.val < current.val) {
		              swap(current, innerCurrent);
		          }
		          innerCurrent = innerCurrent.next;
		       }
		       current = current.next;
		  }
	}

	
	// partitioning 	(single-liked list)
	int partition(int i, int j){
		Node a = this.getNode(j);
		int k = a.val;
		int l = i-1;
		for (int n=i;n<j;n++){
			Node b = this.getNode(n);
			if (b.val <= k){
				l = l+1;
				Node c = this.getNode(l);
				this.swap(b,c);
			}
		}
		Node d = this.getNode(l+1);
		swap(a,d);
		return l+1;
	}	
	
	
	// quicksort from i to j (single-liked list)
	void quickSort(int i, int j){
		if (i < j){
			int k = partition(i,j);
			quickSort(i,k-1);
			quickSort(k+1,j);
		}		
	}
	
	
	// quicksort the whole list (single-liked list)
	void quickSort(){
		quickSort(0,this.mysize()-1);
	}
	
	
}


// 3. double-linked lists
class HTList{
	
	Node head;
	Node tail;
	
}


//A. Top-level class for execution


public class MyList {

	
	// main method
	public static void main(String[] args){
	
		
		Node p;
		
		List list1 = new List();
		
		System.out.println(list1.isEmpty());
		
		List list2 = new List();
		
		list2.head = new Node();
		list2.head.val = 52;
		list2.head.next = new Node();

		p = list2.head.next;
		p.val = 52;
		p.next = new Node();
		
		p = p.next;
		p.val = 88;
		p.next = null;
		
		Node m = new Node();
		m.val = 66;
		
		System.out.println(list2.isEmpty());		
		
		list2.myprint();
		
		list2.removeFirst(88);
		list2.myprint();
		
		list2.insertLast(77);
		list2.myprint();

		list2.insertLast(87);
		list2.myprint();		

		list2.insertLast(11);
		list2.myprint();			
		
		list2.insertFirst(12);		
		list2.myprint();		
		
		list2.removeAll(77);		
		list2.myprint();

		list2.reverse();		
		list2.myprint();
		
		list2.addTail(m);
		list2.myprint();			
		
		list2.addHead(m);
		list2.myprint();	
	
		Node s = list2.getNode(3);		
		list2.myprint();
		
		list2.swap(list2.head,s);
		list2.myprint();	
		
		
		System.out.println(list2.partition(2,5));
		list2.quickSort();
		list2.myprint();
		
		
		list1.insertFirst(22);
		list1.insertFirst(15);
		list1.insertFirst(10);		
		
		list2.addAll(list1);
		list2.myprint();		
		
		list2.popHead().myprint();
		list2.myprint();		
		
		list1.myprint();
		s.myprint();
		list1.addSorted(s);
		list1.myprint();	
		
	}
	
}
