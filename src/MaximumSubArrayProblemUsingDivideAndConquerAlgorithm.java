import java.util.Scanner;

public class MaximumSubArrayProblemUsingDivideAndConquerAlgorithm {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		int maxSum = getMaximumSubArraySumUsingDivideAndConquer(a, 0, n);
		System.out.println(maxSum);

	}

	private static int getMaximumSubArraySumUsingDivideAndConquer(int[] a, int s, int e) {
		int maxSum = 0;
		int leftMax = -100, rightMax = -100, splitMax = -100;
		if (e - s == 1) {
			return a[s];
		}
		int mid = (s + e) / 2;
		leftMax = getMaximumSubArraySumUsingDivideAndConquer(a, s, mid);
		rightMax = getMaximumSubArraySumUsingDivideAndConquer(a, mid, e);
		splitMax = getSplitMax(a, s, e);
		maxSum = Math.max(rightMax, Math.max(splitMax, leftMax));
		return maxSum;
	}

	private static int getSplitMax(int[] a, int s, int e) {
		int mid = (s + e) / 2;
		int leftMax = 0;
		int rightMax = 0;
		int leftSum = 0;
		int rightSum = 0;
		for (int i = mid - 1; i >= s; i--) {

			leftSum += a[i];
			if (leftSum > leftMax) {
				leftMax = leftSum;
			}
		}
		for (int i = mid; i < e; i++) {

			rightSum += a[i];
			if (rightSum > rightMax) {
				rightMax = rightSum;

			}
		}
		return rightMax + leftMax;

	}
}
