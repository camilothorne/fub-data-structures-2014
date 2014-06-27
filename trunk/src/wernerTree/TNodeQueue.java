package wernerTree;

public class TNodeQueue {

	QNode head, tail;

	public boolean isEmpty() {
		return (head == null);
	}

	public void enqueue(Node tNode, int pos) {
		QNode qNode = new QNode();
		qNode.content = tNode;
		qNode.pos = pos;
		qNode.next = null;
		if (isEmpty()) {
			head = qNode;
			tail = qNode;
		} else {
			tail.next = qNode;
			tail = tail.next;
		}
	}

	public Node frontNode() {
		if (this.isEmpty()) {
			return null;
		} else {
			return head.content;
		}
	}

	public int frontPos() {
		if (this.isEmpty()) {
			return 0;
		} else {
			return head.pos;
		}
	}

	public void pop() {
		if (!this.isEmpty()) {
			head = head.next;
			if (head == null) {
				tail = null;
			}
		}
	}

}
