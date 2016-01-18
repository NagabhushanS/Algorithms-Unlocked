import java.util.Scanner;

public class MaximumSubArrayLinearAlgorithm2 {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n = in.nextInt();
		int[] a = new int[n];

		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		
		System.out.println(getMaximumSubArraySum(a));

	}

	private static int getMaximumSubArraySum(int[] a) {
		final int n = a.length;
		int hash[] = new int[n];
		hash[0] = a[0];
		for(int i=1; i<n; i++){
			if (a[i]+hash[i-1]>a[i]){
				hash[i] = hash[i-1]+a[i];
			} else{
				hash[i] = a[i];
			}
		}
		
		int maxRet = 0;
		for(int i=0; i<n; i++){
			if(hash[i]>maxRet){
				maxRet = hash[i];
			}
		}
		return maxRet;
	}

}
