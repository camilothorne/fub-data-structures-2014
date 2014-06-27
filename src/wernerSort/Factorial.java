package wernerSort;

public class Factorial {
	
	static int fac(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * fac(n - 1);
		}
	}

	public static void main(String args[]) {
		System.out.println("Factorial of 6 is " + fac(6));
	}


}
