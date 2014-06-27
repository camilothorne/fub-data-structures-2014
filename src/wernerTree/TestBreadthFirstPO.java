package wernerTree;

public class TestBreadthFirstPO {

	public static void main(String args[]) {

		int[] a = { 5, 2, 1, 3, 7, 6, 8 };

		Tree testTree = new Tree();

		for (int i = 0; i < a.length; i++) {
			System.out.println("Inserting " + a[i]);
			testTree.insert(a[i]);
			System.out.println("Tree has now the following shape: ");
			testTree.breadthFirstTraversal();
			System.out.println();
			System.out.println();
		}
	}
}
