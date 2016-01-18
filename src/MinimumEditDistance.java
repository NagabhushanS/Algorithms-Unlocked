import java.util.Scanner;

public class MinimumEditDistance {
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		String a, b;
		a = in.next();
		b = in.next();
		
		int minimumDistance = findMinimumDistance(a, b);
		System.out.println(minimumDistance);
	}

	private static int findMinimumDistance(String a, String b) {
		char[] s1 = a.toCharArray();
		char[] s2 = b.toCharArray();
		final int n1 = s1.length+1;
		final int n2 = s2.length+1;
		int[][] hash = new int[n2][n1];
		for(int i=0; i<n2; i++){
			hash[i][0]=i;
		}
		
		for(int j=0; j<n1; j++){
			hash[0][j] = j;
		}
		
		for(int i=1; i<n2; i++){
			for(int j=1; j<n1; j++){
				if (s1[j-1]==s2[i-1]){
					hash[i][j] = hash[i-1][j-1];
				} else{
					hash[i][j] = 1+ Math.min(hash[i-1][j], Math.min(hash[i][j-1], hash[i-1][j-1]));
				}
			}
		}
		
		return hash[n2-1][n1-1];
	}

}
