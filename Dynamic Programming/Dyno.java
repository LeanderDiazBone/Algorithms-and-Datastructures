package DynamicProgramming;
import java.util.Arrays;

public class Dyno {
	public static void main(String[] args) {
		int L = 15;
		int D = 4;
		int[] C = {4,6,8,11,13,14};
		int x = dyno(L,D,C);
		System.out.println(x);
	}
	public static int dyno(int L, int D, int[] C) {
		boolean[] dp = new boolean[L];
		dp[0] = true;
		for(int i = 1; i < L; i++) {
			if(!binaerySearch(C, i)) {
				if(dp[i-1]) {
					dp[i] = true;
				}else if(D <= i && dp[i-D]) {
					dp[i] = true;
				}else {
					dp[i] = false;
				}
			}else {
				dp[i] = false;
			}
		}
		for(int i = L-1; i >= 0; i--) {
			if(dp[i]) {
				System.out.println(Arrays.toString(dp));
				return i;
			}
		}
		return 0;
	}
	public static boolean binaerySearch(int[] C, int i) {
		int right = C.length-1;
		int left = 0;
		while(right > left) {
			//System.out.println(Arrays.toString(C) +" " +i+ " "+left +" "+right);
			int mid = (right+left)/2;
			if(C[mid] == i) return true;
			if(C[mid] > i) right = mid-1;
			else left = mid+1;
		}
		if(C[left] == i) {
			return true;
		}else {
			return false;
		}
	}
}
