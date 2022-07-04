class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], dp.length + dp[0].length);
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0)
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    if (j > 0)
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                }
            }
        }
        
        
        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0; j--) {
                if (mat[i][j] == 0) {
                    continue;
                } else {
                    if (i < mat.length - 1)
                        dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                    if (j < mat[0].length - 1)
                        dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1); 
                }
            }
        }
        
        return dp;
    }
}