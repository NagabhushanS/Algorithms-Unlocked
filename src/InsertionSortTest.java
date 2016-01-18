
public class InsertionSortTest {
	public static void main(String[] args) {
		// final int n = 10;
		int[] a = { 21, 32, 54, 2, 65, 65, 21, 54, 2, 100 };

		insertionSort(a);

		print(a);
	}
	
	private static void insertionSort(int[] a) {
		final int n = a.length;
		for(int i=1; i<n-1; i++){
			int key = a[i];
			int j=i;
			while(j>0 && a[j-1]>key){
				a[j]=a[j-1];
				j--;
			}
			a[j] = key;
		}
		
	}

	private static void print(int[] a) {
		final int n = a.length;
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

	}
}
