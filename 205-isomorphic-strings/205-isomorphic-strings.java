class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        if (s == null || s.length() <= 1) return true;
        
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if (!map.containsKey(a)) {
                if (map.containsValue(b)) {
                    return false;
                } else {
                    map.put(a, b);
                }
            } else {
                if (map.get(a) == b) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}