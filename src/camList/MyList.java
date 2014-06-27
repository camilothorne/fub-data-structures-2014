package camList;


// Class for execution


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
		//list2.quickSort();
		
		System.out.println("rec insertion sort:");
		
		list2.insertSortRec();
		
		list2.myprint();
		
		
		list1.insertFirst(22);
		list1.insertFirst(15);
		list1.insertFirst(10);		
		
		list2.addAll(list1);
		list2.myprint();		
		
		System.out.println("rec insertion sort:");
		
		list2.insertSortRec();		

		list2.myprint();		
		
		list2.popHead().myprint();
		list2.myprint();		
		
		list1.myprint();
		s.myprint();
		list1.addSorted(s);
		list1.myprint();	
		
	}
	
}
