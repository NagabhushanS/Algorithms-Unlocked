import java.util.Arrays;
import java.util.Scanner;

public class NextStringPermutation {

	static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		String s = in.next();
		
		System.out.println(getNextPermutation(s));
	}
	private static char[] getNextPermutation(String s) {
		char[] c = s.toCharArray();
		final int n = c.length;
		for(int i=n-2; i>=0; i--){
			int flag=0;
			for(int j=n-1; j>i; j--){
				if (c[i]<c[j]){
					char temp = c[j];
					c[j] = c[i];
					c[i] = temp;
					Arrays.sort(c, i+1, n);
					flag=1;
					break;
				}
			}
			if (flag==1){
				break;
			}
		}
		return c;
	}

}
