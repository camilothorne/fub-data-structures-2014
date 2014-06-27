package camSort;


public class MyRecursion {
	
	
	//-----------------------------------------------------------------		
	
	
	// Assgn 1
	
	
	// palindrome method (recursive)
	public static boolean palin(char[] word){
		if (word.length == 0 || word.length == 1){
			return true;
		}
		else{
			if (word[0] != word[word.length-1]){
				return false;
			}
			else{
				word = slice(word,1,word.length-2); // use slicing aux function		
				return true && palin(word);
			}
		}		
	}
	
	
	// max ascent method (iterative)
	public static int maxAscent(int[] A){
		int i = 0; // start at the first cell of the array
		int l = 1; // singletons are ascents
		while (i < A.length){
			int j = i;
			while (j < A.length-1 && A[j] <= A[j+1]){
				j = j + 1;
			}
			if ((j-i)+1 > l){
				l = (j-i)+1;
			}
			i = (i+j)+1;
		}
		System.out.print("res=");
		return l;
	}	
	
	
	// matrix of averages
	public static float[][] avgMatrix(int[] A){
		float[][] M = new float[A.length][A.length];
		for (int i=0;i<A.length;i++){
			float avg = A[i];
			M[i][i] = A[i];// fill the diagonal 
			for (int j=i+1;j<A.length;j++){// start second counter at i+1
				avg = (avg + A[j])/((j-i)+1);
				M[i][j] = avg;
			}
		}
		return M;
	}
	
	
	//-----------------------------------------------------------------	
	
	
	// Lab 3
	
	
	// conversion to binary
	public static String DecToBin(int n){
		if (n==0){
			return "";
		}
		else{
			return DecToBin(n/2) + n%2;
		}
	}
	
	
	// recursive GCD algorithm
	public static int recGCD(int n, int m){
		if (m == 0){
			return n;
		}else{
			if (n < m){
				return recGCD(n, m % n);
			}else{
				return recGCD(m, n % m);
			}
		}
	}
	
	
	//-----------------------------------------------------------------
	
	
    // print all subsets of the characters in s
    public static void recComb(String s) { recComb("", s); }
    // print all subsets of the remaining elements, with given prefix 
    private static void recComb(String prefix, String s) {
        if (s.length() > 0) {
            System.out.println(prefix + s.charAt(0));
            recComb(prefix + s.charAt(0), s.substring(1));
            recComb(prefix, s.substring(1));
        }
    } 
	
    
    // print all subsets that take k of the remaining elements
    public  static void recCombK(String s, int k) { recCombK(s, "", k); }
    // print all subsets that take k of the remaining elements, with given prefix 
    private static void recCombK(String s, String prefix, int k) {
        if (s.length() < k) return;
        else if (k == 0) System.out.println(prefix);
        else {
            recCombK(s.substring(1), prefix + s.charAt(0), k-1);
            recCombK(s.substring(1), prefix, k);
        }
    }    
    
    
	//-----------------------------------------------------------------
	
	
	// Auxiliary procedures
	
	
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
	
	
	// returns subarray [n_i,...,n_j]
	public static char[] slice(char [] A, int i, int j){
		char[] res = new char[(j-i)+1];
		for (int s=i;s<=j;s++){
			res[s-i] = A[s];
		}
		return res;
	}	
	
	
	//-----------------------------------------------------------------	
	
	
	// main method
	public static void main(String[] args){
		
		char[] palindrome 	= {'a','b','c','b','a'};
		char[] word 			= {'j','o','h','n'};
		char[] palindrome2	= {'a','b','b','a'};
				
		//System.out.println(palin(palindrome));
		//System.out.println(palin(word));
		//System.out.println(palin(palindrome2));
		
		//System.out.print("\n----------------------------------------------------\n\n");
		
		int[] asc 	= {1,2,1,2,2,4,5,3};
		int[] asc2 	= {7,6,5,4};
		int[] asc3 	= {1,2,1,2,1,2};
				
		//System.out.println(maxAscent(asc));
		//System.out.println(maxAscent(asc2));
		//System.out.println(maxAscent(asc3));
		
		//System.out.print("\n----------------------------------------------------\n\n");
		
		//ArrayUtility.displayMatrix(avgMatrix(asc));
		
		System.out.print("\n----------------------------------------------------\n\n");
		
		System.out.println(DecToBin(21));

		System.out.print("\n----------------------------------------------------\n\n");		
		
		System.out.println(recGCD(21,49));

		System.out.print("\n----------------------------------------------------\n\n");		
		
		recComb("abc");		

		System.out.print("\n----------------------------------------------------\n\n");		
		
		recCombK("abc",2);				
		
	}

}
