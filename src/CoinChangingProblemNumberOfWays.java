import java.util.Scanner;

public class CoinChangingProblemNumberOfWays {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n, sum;
		n = in.nextInt();
		sum = in.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++){
			a[i] = in.nextInt();
		}
		
		int numberOfWays = getWays(a, sum);
		System.out.println(numberOfWays);
	}

	private static int getWays(int[] a, int sum) {
		final int n = a.length;
		int[][] hash = new int[n][sum+1];
		for(int i=0; i<n; i++){
			hash[i][0]=1;
		}
		for(int i=0; i<n; i++){
			for(int j=1; j<=sum; j++){
				if (a[i]<=j){
					try{
						hash[i][j] = hash[i-1][j]+hash[i][j-a[i]];
					} catch(Exception e){
						hash[i][j] = hash[i][j-a[i]];
					}
				} else{
					try{
						hash[i][j] = hash[i-1][j];
					} catch (Exception e){
						hash[i][j]=0;
					}
				}
			}
		}
		return hash[n-1][sum];
	}

}
