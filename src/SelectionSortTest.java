
public class SelectionSortTest {
	public static void main(String[] args) {
		//final int n = 10;
		int[] a = { 21, 32, 54, 2, 65, 65, 21, 54, 2, 100 };

		selectionSort(a);

		print(a);
	}

	private static void print(int[] a) {
		final int n = a.length;
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

	}

	private static void selectionSort(int[] a) {
		final int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int smallest = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[smallest]) {
					smallest = j;
				}
			}
			int temp = a[smallest];
			a[smallest] = a[i];
			a[i] = temp;
		}

	}
}
