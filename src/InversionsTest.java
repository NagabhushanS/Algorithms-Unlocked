import java.util.Arrays;

public class InversionsTest {

	private static int inversions = 0;

	public static void main(String[] args) {
		int n = 9;
		int[] a = { 32, 43, 1, 5, 2, 53, 56, 21, 55 };
		int[] b = Arrays.copyOfRange(a, 0, a.length);
		mergeSort(a, 0, n);

		System.out.println(Arrays.binarySearch(a, 55));
		System.out.println(binarySearch(a, 55));
		System.out.println(recursiveBinarySearch(a, 0, n, 55));

		System.out.println(inversions);

		System.out.println(bruteForceInversions(b));
	}

	public static int binarySearch(int[] a, int x) {
		final int n = a.length;
		int s = 0;
		int e = n - 1;
		int mid = 0;
		while (s <= e) {
			mid = (s + e) / 2;
			if (a[mid] == x) {
				return mid;
			} else if (a[mid] > x) {
				e = mid - 1;
			} else if (a[mid] < x) {
				s = mid + 1;
			}
		}
		return -1;
	}

	public static int recursiveBinarySearch(int[] a, int s, int e, int x) {
		int mid = (s + e) / 2;
		if (e-s>1){
			return -1;
		}
		if (a[mid] == x) {
			return mid;
		} else if (a[mid] > x) {
			return recursiveBinarySearch(a, s, mid, x);
		} else {
			return recursiveBinarySearch(a, mid, e, x);
		}
	}

	public static int bruteForceInversions(int[] a) {
		final int n = a.length;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[i] > a[j]) {
					sum++;
				}
			}
		}
		return sum;
	}

	private static void mergeSort(int[] a, int s, int e) {
		if (e - s <= 1) {
			return;
		}
		int mid = (s + e) / 2;
		mergeSort(a, s, mid);
		mergeSort(a, mid, e);

		int left[] = new int[mid - s];
		int right[] = new int[e - mid];

		for (int i = s; i < mid; i++) {
			left[i - s] = a[i];
		}
		for (int i = mid; i < e; i++) {
			right[i - mid] = a[i];
		}

		int i = 0, j = 0;
		for (int k = s; k < e; k++) {
			try {
				if (left[i] <= right[j]) {
					a[k] = left[i];
					i++;
				} else {
					inversions += mid - s - i;
					a[k] = right[j];
					j++;
				}
			} catch (Exception ex) {
				if (i >= mid - s) {
					for (int l = j; l < e - mid; l++, k++) {
						a[k] = right[l];
					}
				} else {
					for (int l = i; l < mid - s; l++, k++) {
						a[k] = left[l];
					}
				}
			}

		}
		return;
	}
}
