package werner;
import java.math.BigInteger;

public class FibIterativePrint {

	static void printFib(int howMany) {
		BigInteger fib1 = BigInteger.valueOf(1);
		BigInteger fib2 = BigInteger.valueOf(1);
		BigInteger fibnew;			
		for (int step = 1; step <= howMany; step++){
			if (step <= 2){
				System.out.println("Fibonacci of " + step + " is 1");}
			else {
				fibnew = fib1.add(fib2);
				fib1 = fib2;
				fib2 = fibnew;
				System.out.println("Fibonacci of " + step + " is " + fib2);};
			}
		}
	
	public static void main(String args[]) {
		printFib(Integer.parseInt(args[0]));
	}

}
