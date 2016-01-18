import java.util.Scanner;

public class BoxStackingProblem {
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		final int n = in.nextInt();
		int[][] a = new int[n][3];
		
		for(int i=0; i<n; i++){
			a[i][0] = in.nextInt();
			a[i][1] = in.nextInt();
			a[i][2] = in.nextInt();
		}
		
		int maxHeight = findTheStackMaxHeight(a);
		System.out.println(maxHeight);
	}

	private static int findTheStackMaxHeight(int[][] a) {
		int maxHeight = 0;
		final int n = a.length;
		int[][] b = new int[3*n][3];
		for(int i=0, j=0; i<3*n && j<n; i+=3, j++){
			b[i] = a[j];
			b[i+1][2] = a[j][1];
			b[i+2][2] = a[j][0];
			b[i+1][0] = a[j][0];
			b[i+1][1] = a[j][2];
			b[i+2][0] = a[j][1];
			b[i+2][1] = a[j][2];
			
		}
		
		sort(b);
		for(int i=0; i<3*n; i++){
			for(int j=0; j<3; j++){
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
		
		int[] hash = new int[3*n];
		for(int i=0; i<3*n; i++){
			hash[i] = b[i][2];
		}
		for(int i=0; i<3*n; i++){
			for(int j=0; j<i; j++){
				if (b[j][0]>b[i][0] && b[j][1]>b[i][1]){
					hash[i] = Math.max(hash[i], b[i][2]+hash[j]);
				}
			}
		}
		
		for(int i=0; i<n; i++){
			if (hash[i]>maxHeight){
				maxHeight = hash[i];
			}
		}
		
		
		
		return maxHeight;
	}

	private static void sort(int[][] b) {
		final int n =b.length;
		for(int i=1; i<n; i++){
			int j = i;
			int key = b[i][0]*b[i][1];
			int[] keyArray = b[i];
			while(j>0 && b[j-1][0]*b[j-1][1]<key){
				b[j] = b[j-1];
				j--;
			}
			b[j] = keyArray;
		}
		
	}

}
