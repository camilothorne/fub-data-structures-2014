package wernerTree;


public class Tree {

	Node root;

	public boolean isEmpty() {
		return (root == null);
	}

	public void insert(int key) {

		// create new node to be inserted
		Node node = new Node();
		node.key = key;

		if (root == null) {
			root = node;
			return;
		}

		// Standard case: root is not null
		// Traverse tree to find position where to insert new node
		// Use pair of pointers, with front pointer for testing for null
		Node front = root;
		Node rear = root;

		// new nodes are inserted on the left if the tree is balanced,
		// on the right otherwise;
		// on the way, adjust counts
		while (front != null) {
			rear = front;
			if (key < rear.key) {
				front = rear.left;
			} else {
				front = rear.right;
			}
		}

		// when the loop terminates, the new node
		// has to be inserted as a child of rear;
		// counts have already been updated earlier
		node.parent = rear;
		if (key < rear.key) {
			rear.left = node;
		} else {
			rear.right = node;
		}

	}

	void breadthFirstTraversal() {
		if (isEmpty()) {
			return;
		}

		TNodeQueue tNodeQueue = new TNodeQueue();
		tNodeQueue.enqueue(root, 1);

		Node currentNode, tNodeLeft, tNodeRight;
		// tNodeToProcess is the next TreeNode to be processed

		int currentPos;

		while (!tNodeQueue.isEmpty()) {
			// process nextNode
			currentNode = tNodeQueue.frontNode();
			currentPos = tNodeQueue.frontPos();
			tNodeQueue.pop();
			tNodeLeft = currentNode.left;
			if (tNodeLeft != null) {
				tNodeQueue.enqueue(tNodeLeft, 2 * currentPos);
			}
			tNodeRight = currentNode.right;
			if (tNodeRight != null) {
				tNodeQueue.enqueue(tNodeRight, 2 * currentPos + 1);
			}
			System.out.print(currentPos + ": " + currentNode.key + "  ");
		}
	}

}
