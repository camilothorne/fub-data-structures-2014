package wernerSort;
import java.util.Arrays;

public class SsortPrint {

	static void ssort(int[] A) {
		int n = A.length;
		int j, i;
		int min, ptr;
		for (j = 0; j < n - 1; j++) {
			min = A[j];
			ptr = j;
			for (i = j; i < n; i++) {
				if (A[i] < min) {
					min = A[i];
					ptr = i;
				}
			};
			A[ptr] = A[j];
			A[j] = min;
		}
	}

	public static void main(String args[]) {
		int[] testA = { 44, 55, 12, 42, 94, 18, 6, 67 };
		ssort(testA);
		System.out.println(Arrays.toString(testA));
	}

}
