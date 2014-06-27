package wernerSort;
public class BinSearchRec {

	static int searchRec(int A[], int q, int l, int r) {
		int m = (l + r) / 2;
		if (l > r) {
			return -1;
		} else if (A[m] == q) {
			return m;
		} else if (q < A[m]) {
			return searchRec(A, q, l, m - 1);
		} else {
			return searchRec(A, q, l + 1, r);
		}
	}

	static int binSearch(int A[], int q) {
		return searchRec(A, q, 0, A.length);

	}

	public static void main(String args[]) {
		int[] testA = { 4, 6, 12, 18, 19, 33, 41, 42, 44, 48, 55, 67, 86, 94};
		int q = 41;
		int pos = binSearch(testA, q);
		System.out.println("The position of " + q + " is " + (pos+1) );
	}

}
