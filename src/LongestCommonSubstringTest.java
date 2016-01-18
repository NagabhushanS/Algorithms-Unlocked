import java.util.Scanner;

public class LongestCommonSubstringTest {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		String a, b;
		a = in.next();
		b = in.next();
		final int n1 = a.length();
		final int n2 = b.length();

		System.out.println(getCommonSubstring(a, b, n1, n2));

	}

	public static String getCommonSubstring(String a, String b, final int n1, final int n2) {
		String max = "";
		for (int i = 0; i < n1; i++) {
			for (int j = n1; j >= i; j--) {
				for (int k = 0; k < n2 - j + i; k++) {
					if (a.substring(i, j).equals(b.substring(k, k + j - i))
							&& a.substring(i, j).length() > max.length()) {

						max = a.substring(i, j);

					}
				}
			}
		}
		return max;
	}

}
