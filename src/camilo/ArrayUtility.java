package camilo;


import java.util.*;
import java.math.BigInteger;


public class ArrayUtility {
	
	
	// A. Simple methods

	
	// retuns the max of the array
	public static int findMax (int[] A, int i, int j){
		int max = A[i];
		for (int s=i;s<=j;s++){
			int newmax = A[s];
			if (newmax >= max){
				max = newmax;
			}
		}
		return max;			
	}
	
	
	// returns the position of ths max element
	public static int findMaxPos (int[] A, int i, int j) {
		int max = A[i];
		int res = i;
		for (int s=i;s<=j;s++){
			int newmax = A[s];
			if (newmax >= max){
				max = newmax;
				res = s;
			}
		}
		return res;		
	}


	// dual
	public static int findMin (int[] A, int i, int j){
		int min = A[i];
		for (int s=i;s<=j;s++){
			int newmin = A[s];
			if (newmin >= min){
				min = newmin;
			}
		}
		return min;			
	}
	

	// dual
	public static int findMinPos (int[] A, int i, int j) {
		int min = A[i];
		int res = i;
		for (int s=i;s<=j;s++){
			int newmin = A[s];
			if (newmin < min){
				min = newmin;
				res = s;
			}
		}
		return res;		
	}
	

	// swap element in i by element in j
	public static void swap (int[] A, int i, int j){
		int n = A[i];
		int m = A[j];
		A[j] = n;
		A[i] = m;
	}
	

	// shifts right
	public static void shiftRight (int[] A, int i, int j) {
		int[] B = new int[A.length];
		for (int n=i;n<j;n++){
			B[n+1] = A[n];
		}
		for (int n=0;n<=i;n++){
			B[n] = A[n];
		}
		for (int n=j+1;n<B.length;n++){
			B[n] = A[n];
		}
		displayArray(B);
	}
	

	// shifts left
	public static void shiftLeft (int[] A, int i, int j){
	
		//bla bla
		
	}
	
	
	// create a random array
	public static int[] createRandomArray 
		(int size, int min, int max) {
	int[] res = new int[size];
	Random r = new Random(); 
	for (int i=0;i<size;i++){
		int j = r.nextInt(max);
		if (j > min && j < max){
			res[i] = j;
		}else{
			res[i] = min;
		}
	}
	return res;	
	}
	

	// create a random array of big integers
	public static BigInteger[] createRandomArrayBig 
		(int size, int max) {
	BigInteger[] res = new BigInteger[size];
	Random r = new Random(); 
	for (int i=0;i<size;i++){
		BigInteger j = new BigInteger(max,r);
		res[i] = j;
	}
	return res;	
	}	
	

	// create a random matrix
	public static int[][] createRandomMatrix 
		(int rows, int cols, int min, int max){
		int[][] res = new int[rows][cols];
		Random r = new Random(); 
		for (int i=0;i<rows;i++){
			for (int j=0;j<cols;j++){
				int k = r.nextInt(max);
				if (j > min && j < max){
					res[i][j] = k;
				}else{
					res[i][j] = min;
				}
			}
		}
		return res;	
	}
	

	// make a copy of array A
	public static int[] copyArray (int[] A) {
		int[] res = new int[A.length];
		for (int i=0;i<A.length;i++){
			res[i] = A[i];
		}
		return res;		
	}
	

	// make a copy of matrix M
	public static int[][] copyMatrix (int[][] M){
		int[][] res = new int[M.length][M[0].length];
		for (int i=0;i<M.length;i++){
			for (int j=0;j<M[0].length;j++){
				res[i][j] = M[i][j];
			}
		}
		return res;	
	}
	
	
	// linear search
	public static int findElement (int[] A, int n){
		int res = -1;
		for (int i=0;i<A.length;i++){
			if (A[i] == n){
				res = i;
			}
		}
		return res;
	}
	
	
	// binary search
	
	// incomplete!!!
	
	public static int binarySearch (int[] A, int n) {
		int res = 0;
		return res;		
	}


	// returns subarray [n_i,...,n_j]
	public static int[] slice(int [] A, int i, int j){
		int[] res = new int[(j-i)+1];
		for (int s=i;s<=j;s++){
			res[s-i] = A[s];
		}
		return res;
	}


	// returns subarray [n_i,...,n_j]
	public static char[] slicechar(char [] A, int i, int j){
		char[] res = new char[(j-i)+1];
		for (int s=i;s<=j;s++){
			res[s-i] = A[s];
		}
		return res;
	}	
	
	
	// B. Sorting method
	
	
	// B.1 quicksort
	
	
	// quicksort
	public static int[] quickSort(int[] input){
		quickSortInd(input,0,input.length-1);
		return input;
	}
	

	// quicksort (2nd version)
	public static int[] quickSortB(int[] input){
		quickSortIndB(input,0,input.length-1);
		return input;
	}
	
	
	// quicksort from index i to j
	public static void quickSortInd(int[] input, int i, int j){
		if (i < j){
			int k = partition(input,i,j);
			quickSortInd(input,i,k-1);
			quickSortInd(input,k+1,j);
		}
	}


	// quicksort from index i to j (second version)
	public static void quickSortIndB(int[] input, int i, int j){
		if (i < j){
			int[] r = partitionB(input,i,j);
			quickSortInd(input,i,r[0]-1);
			quickSortInd(input,r[0]+r[1],j);
		}
	}	
	
	
	// partitioning for quicksort (basic version)
	public static int partition(int [] input, int i, int j){
		int k = input[j];
		int l = i-1;
		for (int n=i;n<j;n++){
			if (input[n] <= k){
				l = l+1;
				int m = input[n];
				input[n] = input[l];
				input[l] = m;
			}
		}
		int m = input[l+1];
		input[l+1] = k;
		input[j] = m;
		return l+1;
	}
	

	// partitioning for quicksort (other version)
	public static int[] partitionB(int [] input, int i, int j){
		
		// pivot
		int k = input[i];
		
		// count
		int c = 1;
		
		// initial partition position (we want to update)
		
		int r = i-1;
		
		// we go from left to right
		
		for (int n=i;n<j;n++){
					
			// if the inspected integer is
			// smaller than the pivot,
			// we swap it to the left; as
			// a result, the partition position 
			// advances by one unit (to the right)
			
			if (input[n] < k){
				swap(input,input[n],input[i]);
				r = r + 1;
			}
			
			// if the integer inspected is equal to the pivot, 
			// we skip it and the partition position
			// advances by one unit (to the right)
			
			if (input[n] == k){
				i = i + 1;
				c = c + 1;
				r = r + 1;
			}
			
		}

		// current partition position 
		 int[] res = {r,c};
		
		return res;
	}	
	

	// B.2 ordered insertion
	
	
	// insertion sorting from index i
	public static int[] insSortInd(int[] input, int i){
		if (input.length == i+1){
			return input;
		}
		else{
			int k = input[i];
			if (k > input[i+1]){
				input[i] = input[i+1];
				input[i+1] = k;
				i = i + 1;
				return insSortInd(input,i);
			}
			else{
				i = i + 1;
				return insSortInd(input,i);		
			}
		}
	}	
	
	
	// insertion sorting over the whole array
	public static int[] insSort(int[] input){
		return insSortInd(input, 0);
	}
	
	
	// B.3 max sorting
	
	
	// maxsort with swapping
	public static int[] maxSort(int[] input){
		for (int i=0;i<input.length;i++){
			int maxind = findMaxPos(input,i,input.length-1);
			swap(input,maxind,i);
		}
		return input;
	}
		
	
	// C. Display array/matrix
	
	
	// print array to stdout
	public static void displayArray(int[] input){
		String res = "";
		for (int i=0;i<input.length;i++){
			res = res + " " + input[i];
		}
		System.out.println(res+"\n");
	}
	
	
	// print array to stdout
	public static void displayArray(float[] input){
		String res = "";
		for (int i=0;i<input.length;i++){
			res = res + " " + input[i];
		}
		System.out.println(res+"\n");
	}	
	

	// print matrix to stdout
	public static void displayMatrix(long[][] input){
		for (int i=0;i<input.length;i++){
			String res = "";
			for (int j=0;j<input[0].length;j++){
				res = res + " " + input[i][j];
			}
			System.out.println(res+"\n");
		}
	}	
	

	// print matrix to stdout
	public static void displayMatrix(float[][] input){
		for (int i=0;i<input.length;i++){
			String res = "";
			for (int j=0;j<input[0].length;j++){
				res = res + " " + input[i][j];
			}
			System.out.println(res+"\n");
		}
	}		
	
	
	// D. Comparison methods
	

	// quick sort up to bound
	public static int sortRandomA(int bound){
		long time = 0;
		int count = 1;
		while (time <(bound*1000000000)){// b secs in nanosecs
			int ind = (int)Math.pow(10,count);
			int[] rand = createRandomArray(ind,0,10000);
			long inTime 	= System.nanoTime();
			quickSort(rand);
			long esTime 	= System.nanoTime() - inTime;
			time = time + esTime;
			count = count + 1;
		}
		return count;
	}
	
	
	// max sort up to bound
	public static int sortRandomB(int bound){
		long time = 0;
		int count = 1;
		while (time < (bound*1000000000)){ // b secs in nanosecs
			int ind = (int)Math.pow(10,count);
			int[] rand = createRandomArray(ind,0,10000);
			long inTime 	= System.nanoTime();
			maxSort(rand);
			long esTime 	= System.nanoTime() - inTime;
			time = time + esTime;
			count = count + 1;
		}
		return count;
	}	
	

	// quicksort up to bound in secs, repeat 100 times
	public static long[][] compareSortsA(int bound){
		int bound2 = sortRandomA(bound);
		long[][] res = new long[bound2][100];
		for (int i=0;i<bound2;i++){
			for (int j=0;j<100;j++){
				int ind = (int)Math.pow(10,i);
				int[] rand = createRandomArray(ind,0,10000);
				long inTime 		= System.nanoTime();
				quickSort(rand);
				long esTime 		= System.nanoTime() - inTime;
				res[i][j] = esTime;
			}
		}
		return res;
	}	
	
	
	// maxsort up to bound, repeat 100 times	
	public static long[][] compareSortsB(int bound){
		int bound2 = sortRandomA(bound);
		long[][] res = new long[bound2][100];
		for (int i=0;i<bound2;i++){
			long avg = 0;
			long med = 0;
			long var = 0;
			int[] meds = new int[100];
			for (int j=i+1;j<100;j++){
				int ind = (int)Math.pow(10,i);
				int[] rand = createRandomArray(ind,0,10000);
				long inTime 		= System.nanoTime();
				maxSort(rand);
				long esTime 		= System.nanoTime() - inTime;
				res[i][j] = esTime;
				// avg, var, med
				avg = avg + esTime; // update avg
				var = var + (esTime - res[i][j-1])*(esTime - res[i][j-1]);// update var
				meds[j] = (int)esTime;// update medians
			}
			// i. avg
			avg = (avg/100);
			System.out.println("average for size 10^"+ i + "=" + avg + "ms");
			// ii. var
			var = (var/100);
			System.out.println("variance for size 10^"+ i + "=" + var + "ms");
			// iii. med
			int[] medsort = quickSort(meds);
			med = (medsort[100/2]+medsort[(100/2)+1])/2;
			System.out.println("median for size 10^"+ i + "=" + med + "ms");
			//
			System.out.println();
		}
		return res;
	}	
	
	
	// Running method
	
	
	// main method
	public static void main(String[] args){
		
		int[] test = {5,7,2,3,4,9,1,6,12,11,13,16,15,14};

		int[] test2 = {5,7,2,2,2,3,11,4,9,1,6,11,13,16,14,3};		
		
		/*
		
		displayArray(test);
		
		//swap(test,2,5);
		//displayArray(test);
		
		displayArray(quickSort(test));		
		displayArray(maxSort(test));
		
		System.out.println(findMax(test,0,test.length-1));
		System.out.println(findMax(test,0,test.length-5));
		System.out.println(findMaxPos(test,0,test.length-5));

		System.out.println();			
		//shiftRight(test,0,test.length-5);
		System.out.println();		
		//displayArray(test);
		
		*/
		
		/*
		
		int[] one 	= createRandomArray(10,0,10000);
		int[] two 	= createRandomArray(100,0,10000);
		int[] three 	= createRandomArray(1000,0,10000);
		int[] four	= createRandomArray(10000,0,10000);
			
		long startTime1 			= System.nanoTime();
		quickSort(one);
		long estimatedTime1 	= System.nanoTime() - startTime1;
		System.out.println(estimatedTime1+"ns");
		
		*/

		
		//displayArray(quickSort(test));
		//displayArray(insSort(test));
		//displayArray(quickSortB(test));				
		//displayArray(quickSortB(test2));		
		//System.out.println(sortRandomB(5));
		//System.out.println();
		//System.out.println(sortRandomA(5));
		//System.out.println();	
		//long[][] test2 = {{1,2,5},{3,4,1}};
		//displayMatrix(test2);
		
		compareSortsB(4);
		
		//displayMatrix(compareSortsB(5));
		
	}
	
	
}
