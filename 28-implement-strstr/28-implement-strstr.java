class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);
        
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j-1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
        
    }
    
    private void getNext(int[] next, String s) {
        next[0] = 0;
        //前缀末尾
        int j = 0;
        for (int i = 1; i < s.length(); i++) {//i 后缀末尾
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j-1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }
}