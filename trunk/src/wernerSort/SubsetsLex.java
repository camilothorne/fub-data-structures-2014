package wernerSort;
public class SubsetsLex {
	
	/* Idea: 
	 *  - when we see a new character, we have to process the character in a context
	 *  - the context is the prefix that we have accumulated
	 *  - to process the new character, there are three possibilities:
	 *    - we add the new character to the prefix and stop
	 *    - we extend the prefix and continue
	 * 	  - we leave the prefix as it is and continue
	 *  - we drop the context if now new characters can be found
	 *  - initially, the context is empty
	 */

	public static void subsets(String prefix, int j, char[] A) {
		if (j < A.length) {
			System.out.println(prefix + A[j]);
			subsets(prefix + A[j], j + 1, A);
			subsets(prefix, j + 1, A);
		}
	}
	
	static char[] ATest = {'a','b','c','d','e','f','g'};
	
	public static void main(String[] args){
		subsets("", 0, ATest);
	}

}
