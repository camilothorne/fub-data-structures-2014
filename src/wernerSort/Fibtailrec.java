package wernerSort;
public class Fibtailrec {

	static int fibaux(int fib1, int fib2, int n) {
		if (n == 2) {
			return fib2;
		} else {
			return fibaux(fib2, fib1 + fib2, n - 1);
		}

	}

	static int fib(int n) {
		if (n <= 2) {
			return 1;
		} else {
			return fibaux(1, 1, n);
		}
	}

	public static void main(String args[]) {
		System.out.println("Fibonacci of 1000 is " + fib(1000));
	}

}
