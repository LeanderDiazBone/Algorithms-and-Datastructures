package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;

public class Knapsackproblem {
	public static void main(String[] args) {
		int[] values = {4, 30, 3, 1 , 1, 4, 10, 30, 40, 4, 12, 7};
		int[] weights = {10, 50, 5, 3, 2, 6, 23, 53, 63, 25, 21,32};
		int maxweight = 100;
		System.out.println(knapsackDp(values,weights,maxweight));
	}
	public static int knapsackDp(int[] values, int[] weights, int maxweight) {
		int[] dp = new int[maxweight+1];
		for(int i = 1; i < dp.length; i++) {
			int maxVal = 0;
			for(int j = 0; j < values.length; j++) {
				int w = weights[j];
				if(i-w >= 0) {
					maxVal = Math.max(maxVal, values[j]+dp[i-w]);
				}
			}
			dp[i] = maxVal;
		}
		System.out.println(Arrays.toString(dp));
		//Rekonstruktion der Lösung
		int pos = dp.length-1;
		ArrayList<Integer> result = new ArrayList<Integer>();
		while(pos > 0) {
			boolean changed = false;
			for(int i = 0; i < values.length; i++) {
				if(pos - weights[i] >= 0 && dp[pos-weights[i]]+values[i] == dp[pos]) {
					pos = pos-weights[i];
					result.add(0, i);
					changed = true;
				}
			}
			if(!changed) pos--;
		}
		System.out.println(result.toString());
		return dp[dp.length-1];
	}
}
