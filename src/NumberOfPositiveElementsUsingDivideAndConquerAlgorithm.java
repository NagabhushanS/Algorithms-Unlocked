import java.util.Scanner;

public class NumberOfPositiveElementsUsingDivideAndConquerAlgorithm {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n = in.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		int postiveElements = getPositiveElements(a, 0, n);
		System.out.println(postiveElements);

	}

	private static int getPositiveElements(int[] a, int s, int e) {
		if (e - s == 1) {
			return a[s] > 0 ? 1 : 0;
		}

		int mid = (s + e) / 2;
		return getPositiveElements(a, s, mid) + getPositiveElements(a, mid, e);
	}

}
