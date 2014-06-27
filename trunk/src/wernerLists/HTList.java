package wernerLists;


public class HTList {
	Node head;
	Node tail;

	public HTList(Node node) {
		this.head = node;
		this.tail = node;
	}

	public HTList(Node head, Node tail) {
		this.head = head;
		this.tail = tail;
	}

	public boolean isEmpty() {
		return (head == null);
	}

	public void insertHead(Node node) {
		boolean wasEmpty = this.isEmpty();
		node.next = head;
		head = node;
		if (wasEmpty) {
			tail = node;
		}
	}

	public void insertHead(int v) {
		Node node = new Node(v);
		insertHead(node);
	}

	public void insertTail(Node node) {
		if (isEmpty()) {
			insertHead(node);
		} else {
			node.next = null;
			tail.next = node;
			tail = node;
		}
	}

	public void insertTail(int v) {
		Node node = new Node(v);
		insertTail(node);
	}

	public void insertSorted(Node node) {
		if (isEmpty()) {
			insertHead(node);
		} else if (node.val < head.val) {
			node.next = head;
			head = node;
		} else {
			Node p = head;
			int v = node.val;
			while (p != tail && p.next.val <= v) {
				p = p.next;
			}
			// insert new node after p
			node.next = p.next;
			p.next = node;
			if (p == tail) {
				tail = node;
			}
		}
	}

	public void deleteFirst(int v) {
		if (isEmpty()) {
			return;
		} else if (head.val == v) {
			if (head == tail) {
				tail = null;
			}
			head = head.next;
		} else {
			Node p = head;
			while (p != tail && p.next.val != v) {
				p = p.next;
			}
			if (p != tail) {
				if (p.next == tail) { // delete p.next
					tail = p;
				}
				p.next = p.next.next; /*
									 * results in p.next = null if p.next ==
									 * tail was true
									 */
			}
		}
	}

	public void deleteAll(int v) { // is currently wrong, code for linked lists
		if (head == null) {
			return;
		} else if (head.val == v) {
			head = head.next;
		} else {
			Node p = head;
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
//		System.out.print("List values: ");
		Node p = head;
		while (p != null) {
			System.out.print(p.val + " ");
			p = p.next;
		}
		System.out.flush();
		System.out.println();
	}

	public static HTList buildFromArray(int A[]) {
		Node head = null;
		Node tail = null;
		if (A.length > 0) {
			head = new Node(A[0]);
			Node p = head;
			for (int i = 1; i < A.length; i++) {
				p.next = new Node(A[i]);
				p = p.next;
			}
			tail = p;
		}
		return new HTList(head, tail);
	}

	public HTList clone() {
		Node headClone = null;
		Node tailClone = null;
		if (this.head != null) {
			headClone = new Node(this.head.val);
			Node p = this.head;
			Node pClone = headClone;
			while (p.next != null) {
				pClone.next = new Node(p.next.val);
				p = p.next;
				pClone = pClone.next;
			}
			tailClone = pClone;
		}
		return new HTList(headClone, tailClone);
	}

	public void reverse() {
		Node p = this.head;
		this.head = null;
		while (p != null) {
			Node q = p.next;
			this.insertHead(p);
			p = q;
		}
	}

	public void insertionSort() {
		Node p = this.head;
		this.head = null;
		while (p != null) {
			Node q = p.next;
			this.insertSorted(p);
			p = q;
		}
	}

	public int length() {
		Node p = this.head;
		int count = 0;
		while (p != null) {
			p = p.next;
			count++;
		}
		return count;
	}

	public Node popHead() {
		if (this.isEmpty()) {
			return null;
		}
		Node node = head;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		node.next = null;
		return node;
	}

	public void append(HTList htList) {
		if (this.isEmpty()) {
			this.head = htList.head;
			this.tail = htList.tail;
		} else if (!htList.isEmpty()) {
			this.tail.next = htList.head;
			this.tail = htList.tail;
		}
	}

	public HTList quickSort() {
		if (this.length() <= 1) {
			return this;
		} else {
			HTList Ls = new HTList(null);
			HTList Bs = new HTList(null);
			Node pivot = this.popHead();
			int pivotVal = pivot.val;
			Node p = this.head;
			Node pNext = null;
			while (p != null) {
				pNext = p.next;
				if (p.val < pivotVal) {
					Ls.insertHead(p);
				} else {
					Bs.insertHead(p);
				}
				p = pNext;
			}
			Ls = Ls.quickSort();
			Bs = Bs.quickSort();
			Bs.insertHead(pivot);
			Ls.append(Bs);
			this.head = Ls.head;
			this.tail = Ls.tail;
			
			return Ls;
		}
	}

}
