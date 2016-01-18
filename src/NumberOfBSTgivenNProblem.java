import java.util.Scanner;

/*** hash[n] is also called catalan number ***/
public class NumberOfBSTgivenNProblem {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n = in.nextInt();
		int[] a = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = i;
		}

		int numberOfBST = getNumberOfBST(a, n);
		System.out.println(numberOfBST);
	}

	private static int getNumberOfBST(int[] a, int n) {
		int[] hash = new int[n + 1];
		hash[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				hash[i] += hash[j - 1] * hash[i - j];
			}
		}

		return hash[n];
	}

}
