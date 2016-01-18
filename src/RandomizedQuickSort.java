import java.util.Random;

public class RandomizedQuickSort {
	private static Random random = new Random();

	public static void main(String[] args) {
		final int n = 10;
		int[] a = { 21, 32, 54, 2, 65, 65, 21, 54, 2, 100 };

		quickSort(a, 0, n);

		print(a);
	}

	private static void quickSort(int[] a, int s, int e) {
		if (s + 1 < e) {
			int q = partition(a, s, e);
			quickSort(a, s, q);
			quickSort(a, q + 1, e);
		}
	}

	private static int partition(int[] a, int s, int e) {
		int ri = random.nextInt(2 * e) % (e - s) + s;
		int temp2 = a[ri];
		a[ri] = a[e - 1];
		a[e - 1] = temp2;
		int pivot = a[e - 1];
		int i = s - 1;
		for (int j = s; j < e - 1; j++) {
			if (a[j] <= pivot) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		i++;
		int temp = a[e - 1];
		a[e - 1] = a[i];
		a[i] = temp;
		return i;
	}

	private static void print(int[] a) {
		final int n = a.length;
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}