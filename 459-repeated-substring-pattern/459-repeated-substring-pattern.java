class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s.equals("")) return false;
        
        int[] next = new int[s.length()];
        //前缀末尾
        int j = 0;
        //得到next数组
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j-1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        
        if (next[s.length()-1] > 0 && s.length() % (s.length() - next[s.length()-1]) == 0)
            return true;
        return false;
    }
}