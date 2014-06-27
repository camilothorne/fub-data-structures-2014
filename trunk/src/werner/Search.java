package werner;

class Search {
	static final int n = 5;
	static int j, q;
	static int a[] = { 11, 1, 4, -3, 22 };

	public static void main(String args[]) {
		j = 0;
		q = 22;
		while (j < n && a[j] != q) {
			j++;
		}
		if (j < n) {
			System.out.println(j);
		} else {
			System.out.println("NIL");
		}
	}
}
