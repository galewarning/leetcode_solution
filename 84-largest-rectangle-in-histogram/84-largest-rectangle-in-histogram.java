class Solution {
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int[] left = new int[length];
        int[] right = new int[length];
        left[0] = -1;
        right[length - 1] = length;
        
        for (int i = 1; i < length; i++) {
            int l = i - 1;
            
            while (l >= 0 && heights[l] >= heights[i]) {
                l = left[l];
            }
            left[i] = l;
        }
        
        for (int i = length - 2; i >= 0; i--) {
            int r = i + 1;
            
            while (r < length && heights[r] >= heights[i]) {
                r = right[r];
            }
            right[i] = r;
        }
        
        int max = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, (right[i] - left[i] - 1) * heights[i]);
        }
        return max;
        
    }
}