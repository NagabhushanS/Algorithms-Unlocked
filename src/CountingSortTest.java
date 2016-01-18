import java.util.Scanner;

/***
 * The algorithm can also be used to detect how many numbers lie in the range
 * (a, b) in linear time
 ***/
public class CountingSortTest {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n = in.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		countingSort(a);

	}

	private static void print(int[] a) {
		final int n = a.length;
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

	}

	// O(n+max(ai<sub>i</sub>))
	private static void countingSort(int[] a) {
		int[] c = new int[11];
		final int n = a.length;
		int[] b = new int[n];
		for (int i = 0; i < n; i++) {
			c[a[i]] += 1;
		}
		for (int i = 1; i < 11; i++) {
			c[i] = c[i] + c[i - 1];
		}

		for (int i = n - 1; i >= 0; i--) { // The loop runs from n-1 to 0 to
											// ensure that the sorting algorithm
											// is stable
			b[c[a[i]] - 1] = a[i];
			c[a[i]]--;
		}
		print(b);
	}

}
