import java.util.Scanner;

/***The recurrence is T(n) = 2*T(n/2) + O(1) => T(n) = O(n) ***/
public class MinimumAndMaximumAlgorithms {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		System.out.println("Maximum: " + getMaximum(a, 0, n));
		System.out.println("Minimum: " + getMinimum(a, 0, n));
		
	}

	private static int getMinimum(int[] a, int s, int e) {
		if (e - s == 1) {
			return a[s];
		}
		int mid = (s + e) / 2;
		return Math.min(getMinimum(a, s, mid), getMinimum(a, mid, e));
	}

	private static int getMaximum(int[] a, int s, int e) {
		if (e - s == 1) {
			return a[s];
		}
		int mid = (s + e) / 2;
		return Math.max(getMaximum(a, s, mid), getMaximum(a, mid, e));
	}
	


}
