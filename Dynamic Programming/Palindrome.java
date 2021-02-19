package DynamicProgramming;

import java.util.Arrays;

public class Palindrome {
	public static void main(String[] args) {
		String s = "BANANA";
		minNumSubarrayPalindroms(s);
	}
	public static int minNumSubarrayPalindroms(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		//Base Cases
		for(int i = 0; i < n; i++) {
			dp[i][i] = 1;
		}
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < n-i; j++) {
				if(s.charAt(j) == s.charAt(i+j) && dp[j+1][i+j-1] <= 1) {
					dp[j][i+j] = 1;
				}else {
					int min = dp[j][j]+dp[j+1][i+j];
					for(int x = 1; x < i; x++) {
						min = Math.min(min, dp[j][j+x]+dp[j+x+1][j+i]);
					}
					dp[j][i+j] = min;
				}
			}
		}
		for(int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return dp[0][n-1];
	}
}
