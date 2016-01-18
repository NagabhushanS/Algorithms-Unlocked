import java.util.Random;
import java.util.Scanner;

public class MedianFindingLinearAlgorithm {

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		Random random = new Random();
		int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = random.nextInt(100);
		}

		int median = getMedian(a, n);
		System.out.println(median);
	}

	private static int getMedian(int[] a, int n) {
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, a[i]);
		}

		int[] hash = new int[max + 1];
		for (int i = 0; i < n; i++) {
			hash[a[i]] += 1;
		}
		int j = 0;
		for (int i = 0; i < max + 1; i++) {
			while (hash[i] > 0) {
				a[j] = i;
				hash[i]--;
				j++;
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
		return a[a.length / 2];
	}

}
