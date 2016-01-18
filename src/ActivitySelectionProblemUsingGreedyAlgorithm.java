import java.util.Scanner;

public class ActivitySelectionProblemUsingGreedyAlgorithm {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n = in.nextInt();
		int[][] a = new int[n][2];

		for (int i = 0; i < n; i++) {
			a[i][0] = in.nextInt();
			a[i][1] = in.nextInt();
		}
		
		int maxActivities = getMaximumActivities(a);
		System.out.println(maxActivities);
	}

	private static int getMaximumActivities(int[][] a) {
		int k = 1;
		int count = 1;
		System.out.print(1+" ");
		final int n = a.length;
		for(int i=1; i<n; i++){
			if (a[k-1][1]<=a[i][0]){
				System.out.print((i+1)+" ");
				k = i+1;
				count++;
			}
		}
		System.out.println();
		return count;
	}

}
