import java.util.Scanner;

public class LongestCommonSubSequenceStringUsingDynamicProgramming {
	
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		String s1, s2;
		s1 = in.next();
		s2 = in.next();

		String s = getCommonSubsequenceStringUsingDynamicProgramming(s1, s2);
		System.out.println(s);
	}

	private static String getCommonSubsequenceStringUsingDynamicProgramming(String s1, String s2) {
		final int n1 = s1.length();
		final int n2 = s2.length();
		String[][] hash = new String[n2+1][n1+1];
		for(int i=0; i<=n2; i++){
			for(int j=0; j<=n1; j++){
				hash[i][j]="";
			}
		}
		for(int i=1; i<=n2; i++){
			for(int j=1; j<=n1; j++){
				if(s1.charAt(j-1) == s2.charAt(i-1)){
					if (hash[i][j-1].length()>hash[i-1][j].length()){
						hash[i][j]+=hash[i][j-1]+s1.charAt(j-1);
					} else{
						hash[i][j]+=hash[i-1][j]+s1.charAt(j-1);
					}
					continue;
				}
				if (hash[i][j-1].length()>hash[i-1][j].length()){
					hash[i][j]+=hash[i][j-1];
				} else{
					hash[i][j]+=hash[i-1][j];
				}
			}
		}
		return hash[n2][n1];
	}

}
//iffffndsjfdjfbsdkffbjkfbdfbbdjfbdsssjkfbds
