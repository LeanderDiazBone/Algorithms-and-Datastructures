package DynamicProgramming;

import java.util.Arrays;

public class Matrixkettenmultiplikation {

	public static void main(String[] args) {
		int[] n = {3,4,2,4};
		int[] m = {3,3,4,2};
		System.out.println(matrixkettenmultiplikation(m,n));
 	}
	public static int matrixkettenmultiplikation(int[] m, int[] n) {
		int[][] dp = new int[m.length][m.length];
		for(int i = 1; i < m.length; i++) {
			for(int j = 0; j < m.length-i; j++) {
				int min = Integer.MAX_VALUE;
				System.out.println(i + " " + (i+j));
				for(int l = 0; l < i; l++) {
					int x1 = dp[j][j+l]+dp[j+l+1][j+i];
					int x2 = m[j+l]*n[j+l+1]*n[j+l];
					min = Math.min(min,x1+x2);
					System.out.println(x1 + " " +x2);
				}
				dp[j][i+j]= min;
			}
		}
		for(int i = 0; i < m.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		int result = dp[0][m.length-1];
		return result;
	}
}
