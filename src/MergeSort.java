import java.util.Random;
import java.util.Scanner;

public class MergeSort {

	private static Random randGenerator = new Random();
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int n=100;
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = randGenerator.nextInt(100);
		}
		
		mergeSort(a, 0, a.length);
		
		for(int i=0; i<n; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		in.next();
	}

	private static void mergeSort(int[] a, int s, int e) {
		if (e-s==1){
			return;
		}
		int mid = (s+e)/2;
		mergeSort(a, s, mid);
		mergeSort(a, mid, e);
		
		int left[] = new int[mid-s];
		int right[] = new int[e-mid];
		
		for(int i=s; i<mid; i++){
			left[i-s] = a[i]; 
		}
		for(int i=mid; i<e; i++){
			right[i-mid] = a[i];
		}
		
		int i=0, j=0;
		for(int k=s; k<e; k++){
			try{
				if (left[i]<right[j]){
					a[k] = left[i];
					i++;
				} else{
					a[k] = right[j];
					j++;
				}
			} catch(Exception ex){
				if (i>=mid-s){
					for(int l=j; l<e-mid; l++, k++){
						a[k] = right[l];
					}
				} else{
					for(int l=i; l<mid-s; l++, k++){
						a[k] = left[l];
					}
				}
			}
			
		}
		return;
	}

}
