class Solution {
    public int longestPalindrome(String s) {
        int[] upperCase = new int[26];
        int[] lowerCase = new int[26];
        int res = 0;
        for (char c : s.toCharArray()) {
            if (c <= 'z' && c >= 'a') {
                lowerCase[c - 'a']++;
            } else {
                upperCase[c - 'A']++;
            }
        }
        
        for (int i = 0; i < 26; i++) {
            res += (lowerCase[i] / 2) * 2;
            res += (upperCase[i] / 2) * 2;
        }
        if (res < s.length()) res++;
        return res;
    }
}