class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int sLen = s.length();
        
        // presum
        int presum[] = new int[sLen];
        int temp = 0;
        for (int i = 0; i < sLen; i++) {
            temp = temp + (s.charAt(i) == '*' ? 1 : 0);
            presum[i] = temp;
        }
        
        // last
        int last[] = new int[sLen];
        temp = -1;
        for (int i = 0; i < sLen; i++) {
            if (s.charAt(i) == '|') {
                temp = i;
            }
            last[i] = temp;
        }
        
        // next
        int next[] = new int[sLen];
        temp = -1;
        for (int i = sLen - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                temp = i;
            }
            next[i] = temp;
        }
        
        // for each query
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = next[queries[i][0]];
            int right = last[queries[i][1]];
            if (left == -1 || right == -1 || left >= right) {
                result[i] = 0;
            } else {
                result[i] = presum[right] - presum[left];
            }
        }
        
        return result;
        
    }
}
