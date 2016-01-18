import java.util.Scanner;

public class MaximiseNmodRSubArrayProblem {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		final int n, r;
		n = in.nextInt();
		r = in.nextInt();
		int[] a = new int[n];
		for(int i=0; i<n; i++){
			a[i] = in.nextInt();
		}
		
		int maxRemainder = getMaximisedRemainder(a, n, r);
		System.out.println(maxRemainder);
		System.out.println(getMaximisedRemainder2(a, n, r));
	}

	private static int getMaximisedRemainder(int[] a, int n, int r) {
		int[] hash = new int[n];
		hash[0] = a[0]%r;
		for(int i=1; i<n; i++){
			hash[i] = Math.max((a[i]+hash[i-1])%r, a[i]%r);
		}
		int maxRemainder = -1;
		try{
			maxRemainder = hash[0];
		} catch (Exception e){
			// Empty one
		}
		for(int i=1; i<n; i++){
			if (hash[i]>maxRemainder){
				maxRemainder = hash[i];
			}
		}
		for(int i=0; i<n; i++){
			System.out.print(hash[i]+" ");
		}
		System.out.println();
		return maxRemainder;
	}
	
	private static int getMaximisedRemainder2(int[] a, int n, int r){
		int leftSum[] = new int[n];
		leftSum[0] = a[0];
		for(int i=1; i<n; i++){
			leftSum[i] = leftSum[i-1]+a[i];
		}
		int maxRemainder = 0;
		for(int i=0; i<n; i++){
			for(int j=i; j<n; j++){
				int sum = leftSum[j]-leftSum[i]+a[i];
				sum = sum%r;
				if (sum>maxRemainder){
					maxRemainder = sum;
					//System.out.println(i+" "+j);
				}
			}
		}
		return maxRemainder;
	}

}
