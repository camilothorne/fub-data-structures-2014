package wernerLists;

import java.util.Random;


public class ListTest {

	public static int[] randomArray(int n) {

		int min = 0, max = 1000000;

		int[] randomArray = new int[n];

		// Usually this can be a field rather than a method variable
		Random rand = new Random();

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum;

		for (int i = 0; i < n; i++) {
			randomNum = rand.nextInt((max - min) + 1) + min;
			randomArray[i] = randomNum;
		}
		return randomArray;
	}

	public static void main(String args[]) {

//		int[] testArray = { 44, 44, 44, 55, 12, 33, 42, 94, 18, 6, 67, 33, 86, 41, 33, 19, 4, 48, 32, 68 };
//		int[] testArray = { 3, 4, 2, 1, 2};
		
		int listLength = 10000000;
		
//		int listLength = testArray.length;
		
		System.out.println("List length is: " + listLength);
		System.out.println();

		int[] testArray = randomArray(listLength);

		// List testList = null;

//		List testList = List.buildFromArray(testArray);
		HTList testList = HTList.buildFromArray(testArray);

//		testList.printAll();

		System.out.println();
		System.out.println();
		// System.out.println(testList.length());

		// testList.reverse();
		
		long startTime = System.currentTimeMillis();
		testList.quickSort();
		long stopTime = System.currentTimeMillis();
		long elapsedTime = stopTime - startTime;

		// testList.insertFirst(new Node(123));
		// testList.insertSorted(new Node(188));

//		System.out.println("Final Result: ");
		
		testList.printAll();

		System.out.println();
		System.out.println();

		// System.out.println("Fibonacci of " + n + " is " + fib);
		System.out.println("Running time was " + elapsedTime + "ms");

	}
}
