import java.util.Scanner;

public class MaximiseRemainderUsingDivideAndConquer {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n, r;
		n = in.nextInt();
		r = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}

		System.out.println(getMaximisedRemainderUsingDivideAndConquer(a, 0, n, r, n));
	}

	private static int getMaximisedRemainderUsingDivideAndConquer(int[] a, int s, int e, int r, int n) {
		if (e-s==1){
			return a[s]%r;
		}
		int mid = (s+e)/2;
		
		int leftMax = getMaximisedRemainderUsingDivideAndConquer(a, s, mid, r, n);
		int rightMax = getMaximisedRemainderUsingDivideAndConquer(a, mid, e, r, n);
		int splitMax = getSplitMaxRemainder(a, s, e, r, n);
		return Math.max(leftMax, Math.max(rightMax, splitMax));
	}

	private static int getSplitMaxRemainder(int[] a, int s, int e, int r, int n) {
		int mid = (s+e)/2;
		int remainder = 0;
		int maxRemainder = 0;
		for(int i=mid; i<e; i++){
			remainder = (remainder+a[i])%r;
			if (remainder > maxRemainder){
				maxRemainder = remainder;
			}
		}
		remainder = maxRemainder;
		for(int i=mid-1; i>=s; i--){
			remainder = (maxRemainder+a[i])%r;
			if (remainder > maxRemainder){
				maxRemainder = remainder;
			}
//			if (e-s==n){
//				System.out.println(maxRemainder);
//			}
			
		}
		return maxRemainder;
	}

}
/*
 * 
 * 8 9
2 3 1 3 7 13 4 1
*/
