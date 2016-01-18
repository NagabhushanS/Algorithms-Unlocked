import java.util.Scanner;

public class StockMaximiseProblem {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		
		System.out.println(getMaxProfitFromStocks(a));
	}

	private static int getMaxProfitFromStocks(int[] a) {
		final int n = a.length;
		int[] max = new int[n];
		max[n-1] = a[n-1];
		for(int i=n-2; i>=0; i--){
			max[i] = Math.max(max[i+1], a[i]);
		}
		int withMe = 0;
		int profit = 0;
		for(int i=0; i<n; i++){
			if (a[i]<max[i]){
				withMe+=1;
				profit-=a[i];
			} else{
				profit+=a[i]*withMe;
				withMe=0;
			}
		}
		
		return profit;
	}
	

}
