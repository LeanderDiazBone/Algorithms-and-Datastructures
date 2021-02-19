package DynamicProgramming;

import java.util.Arrays;

public class SplitIntoSupersequences {
	public static void main(String[] args) {
		String s = "efmsusderm";
		String[] D = {"usd","sus","derm"};
		System.out.println(splitIntoSupersequence(s,D));
	}
	public static int splitIntoSupersequence(String s, String[] D){
		boolean[][] words = new boolean[s.length()][D.length];
		for(int i = 0; i < D.length; i++) {
			int counter = 0;
			for(int j = 0; j < s.length(); j++) {
				if(D[i].charAt(counter) == s.charAt(j)) {
					if(counter+1 == D[i].length()) {
						words[j][i] = true;
						counter = 0;
					}else counter++;
				}
			}
		}
		int[] dp = new int[s.length()+1];
		dp[0] = 0;
		for(int i = 1; i <= s.length(); i++) {
			dp[i] = dp[i-1];
			for(int j = 0; j < D.length; j++) {
				if(words[i-1][j]) {
					dp[i] = Math.max(dp[i], dp[i-D[j].length()]+D[j].length());
				}
			}
		}
		for(int i = 0; i < s.length(); i++) {
			System.out.println(Arrays.toString(words[i]));
		}
		System.out.println(Arrays.toString(dp));
		return dp[s.length()];
	}
}
