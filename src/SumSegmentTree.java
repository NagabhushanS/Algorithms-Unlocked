import java.util.Scanner;

public class SumSegmentTree {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n = in.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		int sizeOfSegmentTree = (int) Math.pow(2, Math.ceil(Math.log10(n) / Math.log10(2)));
		sizeOfSegmentTree = 2 * sizeOfSegmentTree - 1;

		int[] segmentTree = new int[sizeOfSegmentTree];
		formSegmentTree(a, segmentTree, 0, n - 1, 0);

//		print(segmentTree);

		int q = in.nextInt();
		for (int i = 0; i < q; i++) {
			int s, e;
			s = in.nextInt();
			e = in.nextInt();

			int sumOverRange = getSumOverRange(segmentTree, s, e, 0, n - 1, 0);
			System.out.println(sumOverRange);
		}

	}

	private static int getSumOverRange(int[] segmentTree, int qs, int qe, int s, int e, int pos) {
		if (qs <= s && qe >= e) {
			return segmentTree[pos];
		}
		if (qs > e || s > qe) {
			return 0;
		}

		int mid = (s + e) / 2;
		return getSumOverRange(segmentTree, qs, qe, s, mid, 2 * pos + 1)
				+ getSumOverRange(segmentTree, qs, qe, mid + 1, e, 2 * pos + 2);
	}

	@SuppressWarnings("unused")
	private static void print(int[] a) {
		final int n = a.length;
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	private static void formSegmentTree(int[] a, int[] segmentTree, int s, int e, int pos) {
		if (e - s == 0) {
			segmentTree[pos] = a[s];
			return;

		}

		int mid = (s + e) / 2;

		formSegmentTree(a, segmentTree, s, mid, 2 * pos + 1);
		formSegmentTree(a, segmentTree, mid + 1, e, 2 * pos + 2);

		segmentTree[pos] = segmentTree[2 * pos + 1] + segmentTree[2 * pos + 2];

	}
}
