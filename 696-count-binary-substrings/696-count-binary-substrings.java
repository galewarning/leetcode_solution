class Solution {
    public int countBinarySubstrings(String s) {
        int res = 0;
        int prev = 0;
        int cur = 1;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                res += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        res += Math.min(prev, cur);
        return res;
    }
}