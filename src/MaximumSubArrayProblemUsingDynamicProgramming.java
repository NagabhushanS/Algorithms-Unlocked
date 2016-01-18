import java.util.Scanner;

/* A little use of dynamic programming to solve the maximum sub array problem in O(n) time */

public class MaximumSubArrayProblemUsingDynamicProgramming {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		int maxSum = getMaximumSubArraySum(a);
		System.out.println(maxSum);

	}

	private static int getMaximumSubArraySum(int[] a) {
		int maxSum = 0;
		final int n = a.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] > 0) {
				sum += a[i];
			} else if (a[i] < 0 && Math.abs(a[i]) >= sum) {
				if (sum > maxSum) {
					maxSum = sum;
				}
				sum = 0;
			} else {
				if (sum > maxSum) {
					maxSum = sum;
				}
				sum += a[i];
			}
		}
		return maxSum;
	}

}
/*
 * 16 13 -3 -25 20 -3 -16 -23 18 20 -7 12 -5 -22 15 -4 7
 */
