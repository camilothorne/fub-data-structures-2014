package werner;

public class SubsetsRec {
	
	static void printPrefixedSubsets(String pre, char A[], int j){
		if (j > A.length - 1){
			System.out.println(pre);
		} 
		else
		{
			printPrefixedSubsets(pre + A[j], A, j+1);
			printPrefixedSubsets(pre, A, j+1);
			}
	}
	

	public static void main(String args[]) {
		char A[] = {'a','b','c','d','e','f'};
			
		printPrefixedSubsets("",A,0);
	}


}
