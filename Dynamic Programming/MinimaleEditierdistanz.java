package DynamicProgramming;

public class MinimaleEditierdistanz {
	public static void main(String[] args) {
		String a = "Ziege";
		String b = "Tieger";
		System.out.println(minimaleEditierdistanz(a,b));
	}
	public static int minimaleEditierdistanz(String a, String b) {
		int n = a.length();
		int m = b.length();
		int[][] dp = new int[n+1][m+1];
		for(int i = 0; i <= n; i++) {
			dp[i][0] = i;
		}
		for(int j = 0; j <= m; j++) {
			dp[0][j] = j;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				int x = 0;
				if(a.charAt(i-1) == b.charAt(j-1)) x++;
				dp[i][j] = Math.min(dp[i-1][i-1]+1-x, Math.min(dp[i-1][j]+1, dp[i][j-1]+1));
			}
		}
		return dp[n][m];
	}
}
