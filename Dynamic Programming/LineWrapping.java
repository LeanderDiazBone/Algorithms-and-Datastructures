package DynamicProgramming;

public class LineWrapping {
	public static void main(String[] args) {
		
	}
	public static int linewrapping(int[] l, int L) {
		//minimum Lines used for first i-words
		int[] numLet = new int[l.length];
		int counter = 0;
		int[] dp = new int[l.length];
		for(int i = 0; i < l.length; i++) {
			if(numLet[counter]+l[i]+1 < L) {
				numLet[counter] += l[i]+1;
				dp[i] = dp[i-1];
			}else {
				counter++;
				dp[i] = dp[i-1] + 1;
				numLet[counter] = l[i];
			}
		}
		return dp[l.length-1];
	}
}
