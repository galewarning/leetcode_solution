class Solution {
    private int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        boolean visited[][] = new boolean[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
               if(dfs(board, word, i, j, visited, 0)) {
                   return true;
               } 
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int x, int y, boolean[][] visited, int index) {
        boolean res = false;
        if(word.length() == index) 
            return true;
        if(x < 0 || x >= board.length || y<0 || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }
        visited[x][y] = true;
        for(int[] dir : directions) {
            boolean flag = dfs(board, word, x+dir[0], y+dir[1], visited, index+1);
            if(flag) {
                res = true;
                break;
            }
        }
        visited[x][y] = false;
        
        return res;
    }
}