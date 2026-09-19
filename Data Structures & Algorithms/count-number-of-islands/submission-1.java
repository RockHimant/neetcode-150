class Solution {
    private int [][] directions = {{-1,0}, {1,0}, {0, -1}, {0, 1}};
    public int numIslands(char[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    bfs(grid, i, j);
                }
            }
        }

        return result;
        
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        for(int[] dir : directions) {
            dfs(grid, r+dir[0], c+dir[1]);
        }


    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new LinkedList();
        grid[r][c] = '0';
        q.add(new int[] {r, c});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];
            for (int[] dir: directions) {
                int newr = row + dir[0];
                int newc = col + dir[1];

                if (newr >= 0 && newc >= 0 && newr < grid.length && newc < grid[0].length && grid[newr][newc] == '1') {
                    q.add(new int[]{newr, newc});
                    grid[newr][newc] = '0';
                }
            }
        }

    }
}
