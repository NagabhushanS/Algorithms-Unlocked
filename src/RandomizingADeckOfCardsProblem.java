import java.util.Random;
import java.util.Scanner;

public class RandomizingADeckOfCardsProblem {

	private static Scanner in = new Scanner(System.in);
	private static Random random = new Random();

	public static void main(String[] args) {
		final int n = in.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		randomizeTheDeckOfCards(a);
	}

	private static void randomizeTheDeckOfCards(int[] a) {
		final int n = a.length;
		for(int i=n-1; i>=0; i--){
			int r = random.nextInt(n);
			int temp = a[r];
			a[r] = a[i];
			a[i] = temp;
		}
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
		
	}

//	private static void randomizeTheDeckOfCards(int[] a) {
//		final int n = a.length;
//		int j = n - 1;
//		for (int i = 0; i < n - 1; i++) {
//			int k = random.nextInt(j); // avoid the case random.nextInt(0) which
//										// causes exception by repeating the
//										// loop from i=0 to n-2
//			int temp = a[k];
//			a[k] = a[j];
//			a[j] = temp;
//			j--;
//		}
//
//		for (int i = 0; i < n; i++) {
//			System.out.print(a[i] + " ");
//		}
//		System.out.println();
//	}

}
