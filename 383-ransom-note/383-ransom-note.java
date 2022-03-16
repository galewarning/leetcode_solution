class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        
        for (char c : magazine.toCharArray()) {
            record[c - 'a']++;
        }
        
        for (char c : ransomNote.toCharArray()) {
            record[c - 'a']--;
        }
        
        for (int i = 0; i < 26; i++) {
            if (record[i] < 0)
                return false;
        }
        
        return true;
    }
}