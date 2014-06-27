package wernerLists;


public class ListOrd extends ListB<Integer>{
	
	public ListOrd(NodeB<Integer> root) {
		super(root);
	}

	public void insertionSort() {
		NodeB<Integer> p = this.root;
		//NodeB<Integer> n = new NodeB<Integer>(p.val);
		this.root = null;
		while (p != null) {
			NodeB<Integer> q = p.next;
			this.insertSorted(p);
			//System.out.println(p.val.toString());
			p = q;
			this.printAll();
		}
	}
		
	public void insertSorted(NodeB<Integer> node) {
		if (root == null) {
			root = node;
			node.next = null;
		} else if (node.val.intValue() <  root.val.intValue()) {
			node.next = root;
			root = node;
		} else {
			NodeB<Integer> p = root;
			Integer v = node.val;
			while (p.next != null && (p.next.val.intValue() >= v.intValue())) {
				p = p.next;
			}
			// insert new node after p
			node.next = p.next;
			p.next = node;
		}
	}	
	
	public static ListOrd buildFromArrayB(Integer A[]) {
		NodeB<Integer> root = null;
		if (A.length > 0) {
			root = new NodeB<Integer>(A[0]);
			NodeB<Integer> p = root;
			for (int i = 1; i < A.length; i++) {
				p.next = new NodeB<Integer>(A[i]);
				p = p.next;
			}
		}
		return new ListOrd(root);
	}
	
	
	public static void main(String[] args){
		
		Integer[] test = {5,4,77,86,12,6,22,89,15,4};
		
		ListOrd list1 =  buildFromArrayB(test);

		list1.printAll();
		
		list1.insertionSort();

		list1.reverse();		
		
		list1.printAll();
		
	}

}
