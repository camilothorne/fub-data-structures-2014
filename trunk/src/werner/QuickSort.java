package werner;
import java.util.Arrays;

public class QuickSort {
	
	static void sort(int[] A){
		quicksort(A,0,A.length-1);
	}

	static void quicksort(int[] A, int l, int r) {
		if (l < r){
			int m = partition(A,l,r);
			quicksort(A,l,m-1);
			quicksort(A,m,r);
		}
	}

	static int partition(int[] A, int l, int r){
		int x = A[r];
		int i = l-1;
		int j = r+1;
		int value;
		while (true) {
			do{j--;}while(A[j]>x);
			do{i++;}while(A[i]<x);
			if (i < j){
				value=A[i]; A[i]=A[j]; A[j]=value;
			} else {
				return i;
			}
		}
		}
	
	public static void main(String args[]) {
		int[] testA = { 44, 55, 12, 42, 94, 18, 6, 67, 33, 86, 41, 19, 4, 48};
		sort(testA);
		System.out.println(Arrays.toString(testA));
	}

}
