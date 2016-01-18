import java.util.Scanner;

public class MaxtrixMultiplicationUsingNaiveAlgorithm {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n = in.nextInt();
		int[][] a = new int[n][n];
		int[][] b = new int[n][n];

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				a[i][j] = in.nextInt();
			}
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				b[i][j] = in.nextInt();
			}
		}
		multiplyMatrices(a, b);

	}

	private static void multiplyMatrices(int[][] a, int[][] b) {
		final int n = a.length;
		int[][] c = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}

		System.out.println("The result is: ");
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}

	}

}
/*Sample Input:
3
2 -1 2
3 -2 1
1 2 3
0 1 -1
2 3 -1
-1 0 2
*/
