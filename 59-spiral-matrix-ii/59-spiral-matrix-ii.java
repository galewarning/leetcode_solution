class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        
        int loop = n/2;
        
        int startX = 0;
        int startY = 0;
        
        int offset = 1;
        
        int count = 1;
        
        while (loop > 0) {
            int i = startX;
            int j = startY;
            
            //left to right on the top
            for (; j < startY + n - offset; j++) {
                res[i][j] = count++;
            }
            
            //up to down on the right handside
            for (; i < startX + n - offset; i++) {
                res[i][j] = count++;
            }
            
            //right to left on the bottom
            for (; j > startY; j--) {
                res[i][j] = count++;
            }
            
            //down to up on the left handside
            for (; i > startX; i--) {
                res[i][j] = count++;
            }
            
            loop--;
            
            startX++;
            startY++;
            
            offset = offset + 2;
        }
        
        if (n % 2 == 1) {
            res[n/2][n/2] = count;
        }
        
        return res;
    }
}