class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> max = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();
        
        int left = 0;
        int right;
        for (right = 0; right < nums.length; right++) {
            while (!max.isEmpty() && nums[right] > max.peekLast()) max.pollLast();
            while (!min.isEmpty() && nums[right] < min.peekLast()) min.pollLast();
            max.add(nums[right]);
            min.add(nums[right]);
            
            if (max.peek() - min.peek() > limit) {
                if (max.peek() == nums[left]) max.poll();
                if (min.peek() == nums[left]) min.poll();
                left++;
            }
        }
        
        return right - left;
    }
}