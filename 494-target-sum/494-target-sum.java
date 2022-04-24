class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        //target = left - (sum - left)
        //left = (target + sum) / 2
        if ((target + sum) % 2 == 1) return 0;
        //dp[i]填满容量为i的背包有多少种方法
        int size = (target + sum)/2;
        if (size < 0) size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }
}