package DynamicProgramming;
public class Mobilfunkmasten {
	public static void main(String[] args) {
		int L = 22;
		int R = 3;
		int[] masten = {0,2,4,10,13,15,18,20,22};
		int[] costs = {6,8,3,15,5,6,4,7,5};
		int minCost =masten(L, R, masten, costs);
		System.out.println(minCost);
	}
	public static int masten(int L, int R, int[] masts, int[] costs) {
		int n = masts.length;
		int[] end = new int[n];
		int[] dp =  new int[n];
		end[0] = masts[0]+R;
		dp[0] = costs[0];
		for(int i = 1; i < n; i++) {
			dp[i] = costs[i];
			end[i] = masts[i]+R;
			int min = dp[i-1];
			for(int j = 2; j < R; j++) {
				if(i-j >= 0 && end[i-j] > masts[i]-R){
					min = Math.min(min, dp[i-j]);
				}
			}
			dp[i] += min;
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < n; i++) {
			if(end[i] >= L) {
				min  = Math.min(min, dp[i]);
			}
		}
		return min;
	}
}
