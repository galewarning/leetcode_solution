class Solution {
    public int compress(char[] chars) {
        int left = 0;
        int right = 0;
        int index = 0;
        while (right < chars.length) {
            int count = 0;
            while (right < chars.length && chars[right] == chars[left]) {
                right++;
                count++;
            }
            chars[index++] = chars[left];
            if (count > 1) {
                for (char c : Integer.toString(count).toCharArray()) {
                    chars[index++] = c;
                }
            }
            left = right;
        }
        return index;
    }
}