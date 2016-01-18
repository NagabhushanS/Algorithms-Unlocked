import java.util.Scanner;

public class HeapSortTest {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n = in.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		buildMaxHeap(a);
		heapSort(a);
		print(a);
	}

	private static void print(int[] a) {
		final int n = a.length;
		for(int i=0; i<n; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
	}

	private static void heapSort(int[] a) {
		int heapSize = a.length;
		final int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			// swap a[0] with a[heapSize-1]
			int temp = a[0];
			a[0] = a[heapSize - 1];
			a[heapSize - 1] = temp;
			heapSize--;
			maxHeapify(a, 0, heapSize);
		}

	}

	private static void buildMaxHeap(int[] a) {
		final int n = a.length;
		for (int i = a.length / 2; i >= 0; i--) {
			maxHeapify(a, i, n);
		}

	}

	private static void maxHeapify(int[] a, int i, int heapSize) {
		int left = 2*i;
		int right = left + 1;
		int largest = i;
		if (left < heapSize && a[left] > a[largest]) {
			largest = left;
		}
		if (right < heapSize && a[right] > a[largest]) {
			largest = right;
		}
		if (largest != i) {
			a[i] += a[largest];
			a[largest] = a[i] - a[largest];
			a[i] = a[i] - a[largest];
			maxHeapify(a, largest, heapSize);
		}
	}

}
