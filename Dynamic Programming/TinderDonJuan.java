package DynamicProgramming;

import java.util.Arrays;

public class TinderDonJuan {
	public static void main(String[] args) {
		boolean[] K = {false,false,true,true,false,true,false,false,true,true,true,true,false,true,false,true};
		int n = optionDateSchedules(K);
		System.out.println(n);
		boolean[] K2 = {false, true, false, false, true, true, true, false};
		int n2 = optionDateSchedules(K2);
		System.out.println(n2);
	}
	public static int optionDateSchedules(boolean[] friendavailable) {
		int n = friendavailable.length;
		int[] dp = new int[n];
		int[] last = new int[n];
		int counter = -1;
		for(int i = 0; i < n; i++) {
			last[i] = counter; 
			if(friendavailable[i]) {
				counter = i;
			}
		}
		dp[0] = 2;
		dp[1] = 3;
		for(int i = 2; i < n; i++) {
			int x = 1;
			int l = last[i];
			if(l != -1 && l >= 1) {
				x = dp[l-1];
			}
			dp[i] = dp[i-1] + x; 
		}
		System.out.println(Arrays.toString(last));
		System.out.println(Arrays.toString(dp));
		return dp[n-1];
	}
}
