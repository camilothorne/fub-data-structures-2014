package camTree;

// Queues

public class Queue{
	
	QNode root;
	
	// constructors
	
	public Queue(){}
	
	public Queue(QNode root) {
		this.root = root;
	}

	
	public boolean isEmpty() {
		return (root == null);
	}

	// enqueue
	
	void enqueue(NodeTree n){
		this.insertLast(new QNode(n));
		System.out.print(n.key + " ");
	}
	
	// dequeue
	
	void dequeue(){
		NodeTree n = this.root.data;
		this.deleteTop(n);
		if (n.left != null){
			this.enqueue(n.left);
		}
		if (n.right != null){
			this.enqueue(n.right);
		}
	}

	// auxilary functions
	
	public void insertLast(QNode node) {
		if (root == null) {
			root = node;
		} else {
			QNode p = root;
			while (p.next != null) {
				p = p.next;
			}
			p.next = node;
		}
	}
	
	public void deleteTop(NodeTree v) {
		if (root == null) {
			return;
		} else if (root.data == v) {
			root = root.next;
		} 
	}	
	
}

// Nodes

class QNode{
	
	NodeTree data;
	QNode next;
	
	public QNode(){}
	
	public QNode(NodeTree n){
		this.data = n;
	}
	
}
