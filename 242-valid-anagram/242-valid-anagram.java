class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        
        for (char c : s.toCharArray()) {
            record[c - 'a'] ++;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a'] --;
        }
        for (int i = 0; i < 26; i++) {
            if (record[i] != 0) {
                return false;
            }
        }
        return true;
    }
}