package wernerSort;

public class GcdRec {
	
	static int gcd(int x, int y) {
		if (x == 0) {
			return y;
		} 
		else if (y == 0){
			return x;
		}
		else if (x < y){
			return gcd(x,y % x);
		}
		else {
			return gcd(x % y,y);
		}
	}

	public static void main(String args[]) {
		System.out.println("The gcd of 12345678 and 87654321 is " + gcd(12345678,87654321));
	}


}
