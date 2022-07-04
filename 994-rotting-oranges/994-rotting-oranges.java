class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        int minutes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int x = queue.peek()[0];
                int y = queue.poll()[1];
                if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    queue.offer(new int[]{x - 1, y});
                    freshCount--;
                }
                if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    queue.offer(new int[]{x + 1, y});
                    freshCount--;
                }
                if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    queue.offer(new int[]{x, y - 1});
                    freshCount--;
                }
                if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    queue.offer(new int[]{x, y + 1});
                    freshCount--;
                }
            }
            
            if (queue.size() != 0)
                minutes++;
        }
        
        return freshCount == 0 ? minutes : -1;
    }
}