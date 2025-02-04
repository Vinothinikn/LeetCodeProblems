package com.leetcode.arrayex;

public class TwoArrayDimension {

	public static void main(String a[]) {
		twoArrayExample();
		minimum_time_visiting();
	}
	
	public static void twoArrayExample() {
		int a[][] = {
					{1,3},
					{2,4},
					{3,5}
					};
		System.out.println(a.length);
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				System.out.print(a[i][j]+" ");
			}
		System.out.println();
		}
	}
	
	public static void minimum_time_visiting() {
		//MinimumTimeToVisitAllPoints   - O(N)
		int[][] points = {{1, 1},
						  {3, 4},
						  {-1, 0}};
		int totalTime = 0;
		for(int i=1;i<points.length;i++) {
			
			int dx = Math.abs(points[i][0] - points[i-1][0]);
			System.out.println("for "+i+" dx is "+dx);
			int dy = Math.abs(points[i][1] - points[i-1][1]);
			System.out.println("for "+i+" dy is "+dy);
			totalTime+=Math.max(dx, dy);
			System.out.println("for "+i+" totalTime is "+totalTime);
		}
		System.out.println("Total time taken to visit: "+totalTime);
	}
}
