class Solution {
    public long subArrayRanges(int[] nums) {
        int length = nums.length;
        long res = 0;
        int left, mid;
        
        //先存最小, 再存最大
        Stack<Integer> stack = new Stack<>();
        
        //get min sum of all subarrays
        for (int i = 0; i <= length; i++) {
            while (!stack.isEmpty() && (i == length ? Integer.MIN_VALUE : nums[i]) < nums[stack.peek()]) {
                mid = stack.pop();
                left = stack.isEmpty() ? -1: stack.peek(); 
                res -= (long)nums[mid] * (i - mid) * (mid - left);
            }
            stack.push(i);
        }
        
        
        stack.clear();
        //get max sum of all subarrays
        for (int i = 0; i <= length; i++) {
            while (!stack.isEmpty() && (i == length ? Integer.MAX_VALUE : nums[i]) > nums[stack.peek()]) {
                mid = stack.pop();
                left = stack.isEmpty() ? -1: stack.peek(); 
                res += (long)nums[mid] * (i - mid) * (mid - left);
            }
            stack.push(i);
        }
        
        
        return res;
    }
}