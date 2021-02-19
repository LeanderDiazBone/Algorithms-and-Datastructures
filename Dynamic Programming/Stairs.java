package DynamicProgramming;

import java.util.Arrays;

public class Stairs {
	public static void main(String[] args) {
		System.out.println(optionsStairs(49));
	}
	public static int optionsStairs(int N) {
		int[] dp = new int[N];
		dp[0] = 1;
		dp[1] = 2;
		dp[2] = 2;
		for(int i = 3; i < N; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		System.out.println(Arrays.toString(dp));
		return dp[N-1];
	}
}
