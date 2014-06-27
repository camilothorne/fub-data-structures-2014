package camSort;


public class MyIntersect {
	
	
	// fields
	private int[] array1;
	private int[] array2;
	
	
	// constructor
	MyIntersect(int[] a, int[] b){
		this.array1 = a;
		this.array2 = b;
		int[] res = intersect(this.array1,this.array2);
		ArrayUtility.displayArray(res);
	}
	

	
	// max method
	public static int min(int n, int m){
		if (n <= m){
			return n;
		}else{
			return m;
		}
	}


	// max method
	public static int max(int n, int m){
		if (n >= m){
			return n;
		}else{
			return m;
		}
	}	
	
	
	// intersect method
	public static int[] intersect(int[] a, int[] b){
		
		// output array
		int[] res = new int[max(a.length,b.length)];
		
		// counters
		int i = 0;
		int j = i;
		int curr = 0;// current max value of output list
		
		// we sort the arrays
		a = ArrayUtility.quickSort(a);
		b = ArrayUtility.quickSort(b);
		
		ArrayUtility.displayArray(a);
		ArrayUtility.displayArray(b);
		
		// main loop
		while (i < a.length & j < b.length){
			
			// move up either array till we find a match
			if (a[i] > b[j]){
				j = j+1;
			}					
			if (a[i] < b[j]){
				i = i+1;
			}
						
			// if identical, we save the value if
			// greater than the current max
			// and move
			// forward in parallel
			// (works only for sorted arrays)
			if (a[i] == b[j]){
				if (curr >= a[i]){
					i = i+1;
					j = j+1;					
				}else{
					curr = a[i];
					res[i] = a[i];
					i = i+1;
					j = j+1;
				}
			}		
			
		}
		
		// return output
		return res;
	
	}
	
	
	public static void main(String[] args){
		
		int[] ex1 = {2,3,4,2,5,1,8};
		int[] ex2 = {3,4,2,2};
		
		new MyIntersect(ex1,ex2);
		
	}
	
}
