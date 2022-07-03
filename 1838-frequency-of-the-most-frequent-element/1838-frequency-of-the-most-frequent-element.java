class Solution {
    public int maxFrequency(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int res = 0;
        Arrays.sort(nums);
        
        int sum = 0;
        
        for (right = 0; right < nums.length; right++) {
            sum += nums[right];
            
            while (nums[right] * (right - left + 1) - sum > k) {
                sum -= nums[left];
                left++;
            }
            
            res = Math.max(res, right - left + 1);
        }
        
        return res;
    }
}