package werner;
import java.util.Arrays;

public class IsortPrint {

	static void isort(int[] A) {
		int n = A.length;
		int j, i;
		int value;
		for (j = 1; j < n; j++) {
			value = A[j];
			i = j - 1;
			while (i >= 0 && A[i] > value) {
				A[i + 1] = A[i];
				i--;
			}
			A[i + 1] = value;
		}
	}

	public static void main(String args[]) {
		int[] testA = { 44, 55, 12, 42, 94, 18, 6, 67, 33, 86, 41, 19, 4, 48};
		isort(testA);
		System.out.println(Arrays.toString(testA));
	}

}
