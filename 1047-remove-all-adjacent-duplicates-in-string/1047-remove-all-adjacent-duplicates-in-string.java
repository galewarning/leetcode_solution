class Solution {
    public String removeDuplicates(String s) {
        char[] ch = new char[s.length()];
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (cur > 0 && ch[cur - 1] == temp) {
                cur--;
            } else {
                ch[cur] = temp;
                cur++;
            }
        }
        return new String(ch, 0, cur);
    }
}