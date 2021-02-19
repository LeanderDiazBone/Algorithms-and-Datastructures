package DynamicProgramming;

public class MaximumSubarraySum {
	public static void main(String[] args) {
		int[] nums = {3456,3456,1345,-245,23,-45,52,-345,34,5,-234,5,234,-5,345,2345,34,-5345,-23,45,2345,-345,2-34534,5};
		System.out.println(maxSubarraySum(nums));
	}
	public static int maxSubarraySum(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for(int i = 1; i < dp.length; i++) {
			dp[i] = Math.max(dp[i-1], 0)+nums[i];
		}
		int max = 0;
		for(int i = 0; i < dp.length; i++) {
			max = Math.max(dp[i],max);
		}
		return max;
	}
}
