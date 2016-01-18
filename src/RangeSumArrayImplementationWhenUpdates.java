import java.util.Scanner;

public class RangeSumArrayImplementationWhenUpdates {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		int[] diff = new int[n];
		diff[0] = a[0];
		for (int i = 1; i < n; i++) {
			diff[i] = a[i] - a[i - 1];
		}

		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int s, e, d;
			s = in.nextInt();
			e = in.nextInt();
			d = in.nextInt();
			diff[s] += d;
			try {
				diff[e + 1] -= d;
			} catch (Exception ex) {
				// Array index out of bounds
			}
		}

		a[0] = diff[0];
		System.out.print(a[0] + " ");
		for (int i = 1; i < n; i++) {
			a[i] = a[i - 1] + diff[i];
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}
/* Sample input:
7
1 2 4 3 5 6 7
4
1 3 7
3 6 9
1 3 -1
3 4 1
*/
