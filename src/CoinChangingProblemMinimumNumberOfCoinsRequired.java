import java.util.Scanner;

public class CoinChangingProblemMinimumNumberOfCoinsRequired {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n, sum;
		n = in.nextInt();
		sum = in.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		int minimumCoins = getMinimumCoins(a, sum);
		System.out.println(minimumCoins);
	}

	private static int getMinimumCoins(int[] a, int sum) {
		final int n = a.length;
		int hash[][] = new int[n][sum + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= sum; j++) {
				hash[i][j] = 100000;
			}
		}
//		for(int i=0; i<n; i++){
//			for(int j=1; j<=sum; j++){
//				System.out.print(hash[i][j]+" ");
//			}
//			System.out.println();
//		}

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (j < a[i]) {
					try {
						hash[i][j] = hash[i - 1][j];
					} catch (Exception e) {
						// None
					}
				} else if (j == a[i]) {
					hash[i][j] = 1;
				} else if (j > a[i]) {

					try {
						hash[i][j] = Math.min(hash[i - 1][j], 1 + hash[i][j - a[i]]);
					} catch (Exception e) {
						hash[i][j] = 1 + hash[i][j - a[i]];
					}
				}
			}
		}
//		for(int i=0; i<n; i++){
//			for(int j=1; j<=sum; j++){
//				System.out.print(hash[i][j]+" ");
//			}
//			System.out.println();
//		}
		return hash[n - 1][sum];
	}

}
