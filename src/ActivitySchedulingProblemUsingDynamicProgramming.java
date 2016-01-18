import java.util.Scanner;

public class ActivitySchedulingProblemUsingDynamicProgramming {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n = in.nextInt();
		int[][] a = new int[n][2];

		for (int i = 0; i < n; i++) {
			a[i][0] = in.nextInt();
			a[i][1] = in.nextInt();
		}

		int maxActivities = getMaxActivities(a);
		System.out.println(maxActivities);
	}

	private static int getMaxActivities(int[][] a) {
		final int n = a.length;
		int[] hash = new int[n];
		int[] track = new int[n];
		
		for(int i=0; i<n; i++){
			track[i] = -1;
		}
		for (int i = 0; i < n; i++) {
			hash[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i][0] >= a[j][1]) {
					hash[i] = Math.max(1 + hash[j], hash[i]);
					track[i] = j;
				}
			}
		}

		int maxActivities = hash[0];
		int maxI=0;
		for (int i = 1; i < n; i++) {
			if (maxActivities < hash[i]) {
				maxActivities = hash[i];
				maxI = i;
			}
		}
//		for (int i = 0; i < n; i++) {
//			System.out.print(hash[i] + " ");
//		}
//		System.out.println();
		
		int i = maxI;
		System.out.print("The list is: ");
		while (true){
			System.out.print((i+1)+" ");
			i = track[i];
			if (i==-1){
				System.out.println();
				break;
			}
		}
		return maxActivities;

		
	}

}
/*
 * 11 1 4 3 5 0 6 5 7 3 9 5 9 6 10 8 11 8 12 2 14 12 16
 */