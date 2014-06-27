package wernerSort;
public class BinSearchIter {

	static int searchIter(int A[], int q) {
		int l = 0, r = A.length;
		int m = (l + r) / 2;
		while (l <= r && A[m] != q) {
			if (q < A[m]) {
				r = m - 1;
			} else {
				l = m + 1;
			}
			;
			m = (l + r) / 2;
		}
		if (A[m] == q) {
			return m;
		} else {
			return -1;
		}
	}

	static int binSearch(int A[], int q) {
		return searchIter(A, q);

	}

	public static void main(String args[]) {
		int[] testA = { 4, 6, 12, 18, 19, 33, 41, 42, 44, 48, 55, 67, 86, 94 };
		int q = 41;
		int pos = binSearch(testA, q);
		System.out.println("The position of " + q + " is " + (pos + 1));
	}

}
