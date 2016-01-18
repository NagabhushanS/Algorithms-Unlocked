import java.util.Scanner;

public class LongestIncreasingSubsequence2 {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n = in.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++){
			a[i] = in.nextInt();
		}
		
		int longestIncreasingSubsequenceLength = getLongestIncreasingSubsequenceLength(a, n);
		System.out.println(longestIncreasingSubsequenceLength);
	}

	private static int getLongestIncreasingSubsequenceLength(int[] a, int n) {
		int maxLength = 1;
		int[] maxList = new int[n];
		for(int i=0; i<n; i++){
			maxList[i] = 1;
		}
		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				if (a[i] > a[j]){
					maxList[i] = Math.max(maxList[i], maxList[j]+1);
				}
			}
			//System.out.println(maxList[i]);
			if (maxLength < maxList[i]){
				maxLength = maxList[i];
			}
		}
		return maxLength;
		
	}

}
