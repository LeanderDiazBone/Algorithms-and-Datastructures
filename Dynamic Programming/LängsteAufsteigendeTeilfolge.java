package DynamicProgramming;
import java.util.Arrays;

public class LängsteAufsteigendeTeilfolge {
	public static void main(String[] args) {
		int[] A = {12,31,32,5,21,43,65,87,64,34,643};
		int[] l = längsteAufsteingendeTeilfolge(A);
		System.out.println(Arrays.toString(l));
		int[] B = {3456,1346,3567,564,567,4562,461,346,356,2,45234,6};
		int[] l1 = längsteAufsteingendeTeilfolge(B);
		System.out.println(Arrays.toString(l1));
	}
	public static int[] längsteAufsteingendeTeilfolge(int[] A) {
		int n = A.length;
		int[] dp = new int[n+1];
		int[] V = new int[n+1];
		dp[0] = Integer.MIN_VALUE;
		for(int i = 1; i <= n; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		for(int i = 1; i <= n; i++) {
			int pos = binaerySearch(dp, 0, n-1, A[i-1]);
			dp[pos] = A[i-1];
			V[i-1] = dp[pos-1];
		}
		//Reading out the result
		int[] result;
		int l = 0;
		//Finding the length of the LAT
		for(int i = n-1; i >= 0; i--) {
			if(dp[i] < Integer.MAX_VALUE) {
				l = i;
				break;
			}
		}
		result = new int[l];
		result[0] = dp[result.length];
		for(int i = 0; i < result.length-1; i++) {
			//System.out.println(result[i]);
			int k = getIndex(A, result[i]);
			int u =  V[k];
			result[i+1] = u;
		}
		//Array drehen
		for(int i = 0; i < result.length/2; i++) {
			int b = result[result.length-1-i];
			result[result.length-1-i] = result[i];
			result[i] = b;
		}
		return result;
	}
	public static int binaerySearch(int[] A, int start, int end, int key) {
		//System.out.println(start + " " + end +" " +(end-start)+" "+key);
		if(end-start <= 1) {
			if(key > A[start] && key <= A[end]) {
				return end;
			}else {
				System.out.println("Problem");
				return 0;
			}
		}else {
			int mid = (end+start)/2;
			if(key < A[mid]) {
				return binaerySearch(A, start, mid, key);
			}else {
				return binaerySearch(A, mid, end, key);
			}
		}
	}
	public static int getIndex(int[] A, int key) {
		for(int i = 0; i < A.length; i++) {
			if(A[i] == key) {
				return i;
			}
		}
		return -1;
	}
}
