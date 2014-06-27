package werner;
public class Mystery {

	public static void main(String[] args) {
		int[] testArray = {4,2,8,5,9,7,3,1,6,0};
		mystery(testArray,0,testArray.length-1);
		printArray(testArray);
	}

	private static void mystery(int[] A, int l, int r) {
		int range = r - l + 1;
		int subrange = (int) Math.ceil((float)(2 * range)/3);
		if (range == 2 && A[l] > A[r]) {
			int tmp = A[l];
			A[l] = A[r];
			A[r] = tmp;
		}
		if (range >= 3) {
			mystery(A, l, l + subrange - 1);
			mystery(A, r - (subrange - 1),r);
			mystery(A, l, l + subrange - 1);
		}
	}

	private static void printArray(int[] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}

}
