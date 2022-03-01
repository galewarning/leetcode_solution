class Solution {
    public int maxSubArray(int[] nums) {
        int temp = 0;
        int sum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            temp = temp + nums[i];
            sum = Math.max(temp, sum);
            if(temp < 0) temp = 0;
        }
        return sum;
    }
}