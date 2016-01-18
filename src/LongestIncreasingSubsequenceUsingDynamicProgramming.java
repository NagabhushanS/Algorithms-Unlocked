import java.util.Scanner;

public class LongestIncreasingSubsequenceUsingDynamicProgramming {
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		final int n = in.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++){
			a[i] = in.nextInt();
		}
		
		int maxLength = getLongestIncreasingSubsequenceUsingDynamicProgramming(a);
		System.out.println(maxLength);

	}

	private static int getLongestIncreasingSubsequenceUsingDynamicProgramming(int[] a) {
		final int n = a.length;
		int[] hash = new int[n];
		int maxLength = 0;
		for(int i=1; i<n; i++){
			for(int j=0; j<i; j++){
				if (a[i]>a[j]){
					hash[i] = Math.max(hash[i], hash[j]+1);
				}
			}
			if (hash[i]>maxLength){
				maxLength = hash[i];
			}
		}
		return maxLength+1;
	}

}
