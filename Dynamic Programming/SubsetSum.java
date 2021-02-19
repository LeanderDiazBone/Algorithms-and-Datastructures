package DynamicProgramming;

import java.util.Arrays;
import java.util.LinkedList;

public class SubsetSum {
	public static void main(String[] args) {
		int[] geschenke = {4,1,3,4,2};
		int b = 10;
		System.out.println(Arrays.toString(subsetSum(geschenke, b)));
	}
	public static int[] subsetSum(int[] arr, int b) {
		int n = arr.length;
		boolean[][] dp = new boolean[n+1][b+1];
		for(int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}
		for(int j = 1; j <= n; j++) {
			int y = arr[j-1];
			for(int i = 1; i <= b; i++) {
				if(y <= i || dp[j-1][i]) {
					if(dp[j-1][i] || dp[j-1][i-y]){
						dp[j][i] = true;
				}
			}
		}
		}
		/*for(int i = 0; i <= n; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}*/
		if(dp[n][b] == false) {
			return null;
		}else {
			LinkedList<Integer> list = new LinkedList<Integer>();
			int posx = dp[0].length-1;
			int posy = dp.length-1;
			while(posx != 0) {
					if(dp[posy-1][posx]) {
						posy--;
					}else {
						int x = arr[posy-1];
						list.add(x);
						posy--;
						posx -= x;
					}
					//System.out.println(list + " " + posx);
			}
			int[] res = new int[list.size()];
			for(int i = 0; i < res.length; i++) {
				res[i] = list.removeFirst();
			}
			return res;
		}
	}
}
