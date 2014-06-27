package wernerSort;
import java.util.Arrays;

public class Heapsort {

	static void heapify(int[] A, int i, int n) {
		int l = left(i);
		int r = l + 1;
		int imax = i;
		if (l <= n && A[l] > A[i]) {
			imax = l;
		}
		;
		if (r <= n && A[r] > A[imax]) {
			imax = r;
		}
		;
		if (imax != i) {
			swap(A,i,imax);
			heapify(A, imax, n);
		}
	}

	static void buildHeap(int[] A) {
		int n = A.length - 1;
		for (int i = n/2; i >= 0; i--) {
			heapify(A, i, n);
		}
	}

	static void swap(int[] A, int i, int j) {
		int value;
		value = A[i];
		A[i] = A[j];
		A[j] = value;
	}

	static int left(int i) {
		return 2 * i + 1;
	}

	static void heapSort(int[] A) {
		buildHeap(A);
		int n = A.length - 1;
		for (int i = n; i >= 1; i--) {
			swap(A, 0, i);
			n--;
			heapify(A, 0, n);
		}
	}

	public static void main(String args[]) {
		int[] testA = { 44, 55, 12, 42, 94, 18, 6, 67, 33, 86, 41, 19, 4, 48, 32, 67 };
		heapSort(testA);
		System.out.println(Arrays.toString(testA));
	}

}
