import java.util.Scanner;

public class RodCuttingProblemUsingDynamicProgramming {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n = in.nextInt();
		final int l = in.nextInt();
		int[] length = new int[n];
		int[] value = new int[n];

		for (int i = 0; i < n; i++) {
			length[i] = in.nextInt();
		}

		for (int i = 0; i < n; i++) {
			value[i] = in.nextInt();
		}

		int maxValue = getMaximumValueFromRodCutting(length, value, l, n);
		System.out.println(maxValue);
	}

	private static int getMaximumValueFromRodCutting(int[] length, int[] value, int l, int n) {
		int[][] hash = new int[n][l + 1];
		int maxValue = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= l; j++) {
				if (length[i] > j) {
					try {
						hash[i][j] = hash[i - 1][j];
					} catch (Exception e) {
						hash[i][j] = 0;
					}
				} else {
					try{
					hash[i][j] = Math.max(hash[i-1][j], value[i] + hash[i][j - length[i]]);
					} catch (Exception e){
						hash[i][j] = value[i] + hash[i][j - length[i]];
					}
				}
			}
		}

//		for (int i = 0; i < n; i++) {
//			for (int j = 1; j <= l; j++) {
//				System.out.print(hash[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		for(int i=0; i<n; i++){
			if (hash[i][l]>maxValue){
				maxValue = hash[i][l];
			}
		}
		return maxValue;
	}

}
