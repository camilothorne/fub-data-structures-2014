package wernerSort;
public class Fibclassic {

	static int fib(int n) {
		if (n <= 2) {
			return 1;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

	public static void main(String args[]) {
		System.out.println("Fibonacci of 6 is " + fib(6));
	}

}
