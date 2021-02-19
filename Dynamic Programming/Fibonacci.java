package DynamicProgramming;

public class Fibonacci {
	public static void main(String[] args) {
		for(int i = 2; i < 50; i++) {
			long fib1 = fibonacciRecursion(i);
			long fib2 = fibonacciMemoization(i);
			long fib3 = fibonacciDP(i);
			System.out.println(i + " " + fib1+ " "+fib2+" "+fib3);
		}
	}
	public static long fibonacciRecursion(int n) {
		if(n <= 2) {
			return 1;
		}
		return fibonacciRecursion(n-1)+fibonacciRecursion(n-2);
	}
	
	public static long fibonacciMemoization(int n) {
		long[] memo = new long[n+1];
		return fibMemRec(n,memo);
	}
	public static long fibMemRec(int n, long[] memo) {
		if(n <= 2) {
			return 1;
		}
		if(memo[n] != 0) {
			return memo[n];
		}
		memo[n] = fibMemRec(n-1, memo)+fibMemRec(n-2, memo);
		return memo[n];
	}
	public static long fibonacciDP(int n) {
		long[] dp = new long[n];
		dp[0] = 1;
		dp[1] = 1;
		for(int i = 2; i < n; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n-1];
	}
}
