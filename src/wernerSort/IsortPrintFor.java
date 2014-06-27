package wernerSort;
import java.util.Arrays;

public class IsortPrintFor {

	static void isort(int[] A) {
		int n = A.length;
		int j, i;
		int value;
		for (j = 1; j < n; j++) {
			value = A[j];
			for (i = j - 1;  i >= 0 &&  A[i] > value; i--) {
				A[i+1] = A[i];
			}
			A[i + 1] = value;
		}
	}

	public static void main(String args[]) {
		int[] testA = { 44, 55, 12, 42, 94, 18, 6, 67 };
		isort(testA);
		System.out.println(Arrays.toString(testA));
	}

}
