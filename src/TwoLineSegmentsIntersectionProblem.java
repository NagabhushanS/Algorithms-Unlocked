import java.util.Scanner;

public class TwoLineSegmentsIntersectionProblem {
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int x1, y1;
		int x2, y2;
		int x3, y3;
		int x4, y4;
		x1 = in.nextInt();
		y1 = in.nextInt();
		x2 = in.nextInt();
		y2 = in.nextInt();
		x3 = in.nextInt();
		y3 = in.nextInt();
		x4 = in.nextInt();
		y4 = in.nextInt();

		boolean doIntersect = doIntersect(x1, y1, x2, y2, x3, y3, x4, y4);
		boolean doTurnLeft = doTurnLeft(x1, y1, x2, y2, x3, y3);
		System.out.println("Intersect : " + (doIntersect ? "Yes" : "No"));
		System.out.println("TurnLeft : " + (doTurnLeft ? "Yes" : "No"));
	}

	private static boolean doIntersect(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		// definition of intersection
		/*
		 * Two line segments intersect if and only if either (or both) of the
		 * following conditions holds: 1. Each segment straddles the line
		 * containing the other. 2. An endpoint of one segment lies on the other
		 * segment. (This condition comes from the boundary case.)
		 */
		int d1 = getCrossProduct(x1, y1, x2, y2, x3, y3); // >0
		int d2 = getCrossProduct(x1, y1, x2, y2, x4, y4); // <0
		int d3 = getCrossProduct(x4, y4, x3, y3, x1, y1); // >0
		int d4 = getCrossProduct(x4, y4, x3, y3, x2, y2); // <0

		if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0)) && ((d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0))) {
			return true;
		} else if (d1 == 0 && onSegment(x1, y1, x2, y2, x3, y3)) {
			System.out.println("Yes1");
			return true;
		} else if (d2 == 0 && onSegment(x1, y1, x2, y2, x4, y4)){
			System.out.println("Yes2");
			return true;
		} else if (d3==0 && onSegment(x4, y4, x3, y3, x1, y1)){
			System.out.println("Yes3");
			return true;
		} else if (d4==0 && onSegment(x4, y4, x3, y3, x2, y2)){
			System.out.println("Yes4");
			return true;
		} else{
			return false;
		}

	}

	private static boolean onSegment(int x1, int y1, int x2, int y2, int x3, int y3) {
		if (x3 >= Math.min(x1, x2) && x3 <= Math.max(x1, x2) && y3 >= Math.min(y1, y2) && y3 <= Math.max(x1, x2)) {
			return true;
		}
		return false;
	}

	private static int getCrossProduct(int x1, int y1, int x2, int y2, int x3, int y3) {
		return ((x2 - x1) * (y3 - y2) - (x3 - x2) * (y2 - y1));
	}

	private static boolean doTurnLeft(int x1, int y1, int x2, int y2, int x3, int y3) {
		int X1 = x2 - x1;
		int Y1 = y2 - y1;
		int X2 = x3 - x2;
		int Y2 = y3 - y2;
		return (X1 * Y2 - X2 * Y1 > 0);
	}

}
