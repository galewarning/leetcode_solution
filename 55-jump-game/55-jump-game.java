class Solution {
    public boolean canJump(int[] nums) {
        boolean res = false;
        int reachable = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > reachable) break;
            reachable = Math.max(reachable, i + nums[i]);
        }
        
        return res = reachable >= nums.length - 1;
    }
}