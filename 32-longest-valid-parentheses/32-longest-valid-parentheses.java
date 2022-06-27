class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int leftCount = 0;
        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            if (s.charAt(i) == '(') {
                leftCount++;
            } else if (s.charAt(i) == ')' && leftCount > 0) {
                leftCount--;
                dp[i] = dp[i - 1] + 2;
                dp[i] += (i - dp[i]) >= 0 ? dp[i - dp[i]] : 0;
                res = Math.max(dp[i], res);
            }
        }
        
        return res;
    }
}