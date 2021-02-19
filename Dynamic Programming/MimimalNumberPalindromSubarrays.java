package DynamicProgramming;

import java.util.Arrays;

public class MimimalNumberPalindromSubarrays {
	public static void main(String[] args) {
		int res = minSubarrays("BANANA");
		System.out.println(res);
	}
	public static int minSubarrays(String A) {
		int n = A.length();
		int[][] dp = new int[n][n];
		for(int i = 0; i < n; i++) {
			dp[i][i] = 1;
 		}
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < n-i; j++) {
				int min = Integer.MAX_VALUE;
				//Is a Palindrome
				if(A.charAt(j) == A.charAt(i+j) && (i == 2 || dp[j+1][i+j-1] == 1)) {
						dp[j][j+i] = 1;
				}else {
				//Is not a Palindrome 
				for(int k = 0; k < i; k++) {
					min = Math.min(min, dp[j][j+k]+dp[j+k+1][j+i]);
				}
				dp[j][j+i] = min;
			}
			}
		}
		System.out.println(A);
		for(int i = 0; i < n; i++) {
			System.out.print(A.charAt(i));
			System.out.println(Arrays.toString(dp[i]));
		}
		return dp[0][n-1];
	}
}
