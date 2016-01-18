import java.util.Arrays;
import java.util.Scanner;

public class SetOfCollinearPointsInAPlane {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n = in.nextInt();
		int[][] a = new int[n][2];
		for(int i=0; i<n; i++){
			a[i][0] = in.nextInt();
			a[i][1] = in.nextInt();
		}
		
		boolean isCollinear = isCollinear(a);
		System.out.println(isCollinear);
	}

	// O(n * lg n)
	private static boolean isCollinear(int[][] a) {
		final int n = a.length;
		double[] polarArray = new double[n];
		
		// O(n)
		for(int i=0; i<n; i++){
			polarArray[i] = (double)a[i][1]/a[i][0];
		}
		
		// O(n * lg n)
		Arrays.sort(polarArray);
		
		// O(n)
		for(int i=0; i<n-2; i++){
			if (polarArray[i]==polarArray[i+1] && polarArray[i+1]==polarArray[i+2]){
				return true;
			}
		}
		
		return false;
	}
}
