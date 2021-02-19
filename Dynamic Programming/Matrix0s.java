package DynamicProgramming;

import java.util.Arrays;

public class Matrix0s {
	public static void main(String[] args) {
		int[][] Matrix = {{1,0,0},
						 {1,0,0},
						 {1,1,1}};
		System.out.println(biggest0Matrix(Matrix));
	}
	public static int biggest0Matrix(int[][] A) {
		int[][] dp = new int[A.length][A[0].length];
		for(int i = 0; i < A.length; i++) {
			int x = 0;
			if(A[i][0] == 0) x = 1;
			dp[i][0] = x;
		}
		for(int i = 0; i < A[0].length; i++) {
			int x = 0;
			if(A[0][i] == 0) x = 1;
			dp[0][i] = x;
		}
		for(int i = 1; i < A.length; i++) {
			for(int j = 1; j < A[0].length; j++) {
				if(A[i][j] == 0) {
					int min = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
					dp[i][j] = min+1;
				}else {
					dp[i][j] = 0;
				}
			}
		}
		int max = 0;
		for(int i = 0; i < A.length; i++) {
			for(int j = 0; j < A[0].length; j++) {
				max = Math.max(max, dp[i][j]);
			}
		}
		for(int i = 0; i < A.length; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return max;
	}
}
