import java.util.Scanner;

public class SubsetSumUsingDynamicProgramming {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n, sum;
		n = in.nextInt();
		sum = in.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		
		boolean isSubSetSumPossible = isSubSetSumPossible(a, sum);
		System.out.println((isSubSetSumPossible ? "Yes" : "No"));
	}

	private static boolean isSubSetSumPossible(int[] a, int sum) {
		final int n = a.length;
		int[][] hash = new int[n][sum+1];
		for(int i=0; i<n; i++){
			for(int j=1; j<=sum; j++){
				if (a[i]==j){
					hash[i][j]=1;
				} else if (a[i]>j){
					hash[i][j]=0;
				} else{
					int temp = j-a[i];
					int flag=0;
					for(int k=0; k<i; k++){
						if (hash[k][temp]==1){
							flag=1;
							break;
						}
					}
					hash[i][j] = flag;
				}
			}
		}
		int flag=0;
		for(int i=0; i<n; i++){
			flag+=hash[i][sum];
		}
		if (flag>=1){
			return true;
		} else{
			return false;
		}
	}

}
