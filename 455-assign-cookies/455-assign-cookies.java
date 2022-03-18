class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        int count = 0;
        for (int i = 0; i < s.length && index < g.length; i++) {
            if (g[index] <= s[i]) {
                index++;
                count++;
            }
        }
        return count;
    }
}