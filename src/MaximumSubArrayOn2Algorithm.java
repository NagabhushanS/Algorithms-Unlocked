import java.util.Scanner;

public class MaximumSubArrayOn2Algorithm {
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		final int n = in.nextInt();
		int[] a = new int[n];
		
		for(int i=0; i<n; i++){
			a[i] = in.nextInt();
		}
		
		System.out.println(getMaximumSubArraySum(a));
	}

	private static int getMaximumSubArraySum(int[] a) {
		int finalMax = 0;
		final int n = a.length;
		for(int i=0; i<n; i++){
			int leftMax = 0;
			int leftSum = 0;
			for(int j=i; j>=0; j--){
				leftSum += a[j];
				if (leftSum>leftMax){
					leftMax = leftSum;
				}
			}
			int rightMax = 0;
			int rightSum = 0;
			for(int j=i+1; j<n; j++){
				rightSum += a[j];
				if (rightSum>rightMax){
					rightMax = rightSum;
				}
			}
			if(rightMax+leftMax>finalMax){
				finalMax = rightMax+leftMax;
			}
		}
		
		return finalMax;
	}

}
