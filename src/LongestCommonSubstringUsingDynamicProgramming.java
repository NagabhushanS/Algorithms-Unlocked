import java.util.Scanner;

public class LongestCommonSubstringUsingDynamicProgramming {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String s1, s2;
		s1 = in.next();
		s2 = in.next();

		String s = getCommonSubstringUsingDynamicProgramming(s1, s2);
		System.out.println(s);

	}

	private static String getCommonSubstringUsingDynamicProgramming(String s1, String s2) {
		final int n1 = s1.length();
		final int n2 = s2.length();
		int[][] hash = new int[n2 + 1][n1 + 1];
		for (int i = 1; i <= n2; i++) {
			for (int j = 1; j <= n1; j++) {
				if (s2.charAt(i - 1) == s1.charAt(j - 1)) {
					hash[i][j] = hash[i - 1][j - 1] + 1;
				}
			}
		}
		int max = -1;
		int maxj = 0;
		for (int i = 1; i <= n2; i++) {
			for (int j = 1; j <= n1; j++) {
				if (hash[i][j] > max) {
					max = hash[i][j];
					maxj = j;
				}
			}
		}
		return s1.substring(maxj - max, maxj);
	}

}
