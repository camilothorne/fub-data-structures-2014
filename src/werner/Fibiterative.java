package werner;
public class Fibiterative {

	static int fib(int n) {
		if (n <= 2) {
			return 1;
		} else {
			int fib1 = 1, fib2 = 1;
			int fibnew;
			for (int i = 3; i <= n; i++) {
				fibnew = fib1 + fib2;
				fib1 = fib2;
				fib2 = fibnew;
			}
			;
			return fib2;
		}
	}

	public static void main(String args[]) {
		System.out.println("Fibonacci of 1000000 is " + fib(2));
	}

}
