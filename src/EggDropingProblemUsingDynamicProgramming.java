import java.util.Scanner;

public class EggDropingProblemUsingDynamicProgramming {
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args){
		int floors, eggs;
		floors = in.nextInt();
		eggs = in.nextInt();
		
		System.out.println(getTries(floors, eggs));
	}

	private static int getTries(int floors, int eggs) {
		int[][] hash = new int[eggs][floors];
		
		for(int i=1; i<=eggs; i++){
			for(int j=1; j<=floors; j++){
				for(int k=1; k<=j; k++){
					hash[i][j] = Math.min(hash[i][j], 1+Math.max(hash[i-1][j-k], hash[eggs][k-1]));
				}
			}
		}
		
		return hash[eggs][floors];
	}

}
