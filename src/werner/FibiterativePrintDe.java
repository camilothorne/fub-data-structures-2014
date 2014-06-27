package werner;
import java.math.BigInteger;

public class FibiterativePrintDe {

	static void druckeFib(int wieviele) {
		BigInteger fib1 = BigInteger.valueOf(1);
		BigInteger fib2 = BigInteger.valueOf(1);
		BigInteger fibneu;			
		for (int schritt =1; schritt <= wieviele; schritt++){
			if (schritt <= 2){
				System.out.println("Fibonacci von " + schritt + " ist 1");}
			else {
				fibneu = fib1.add(fib2);
				fib1 = fib2;
				fib2 = fibneu;
				System.out.println("Fibonacci von " + schritt + " ist " + fib2);};
			}
		}
	
	public static void main(String args[]) {
		druckeFib(Integer.parseInt(args[0]));
	}

}
