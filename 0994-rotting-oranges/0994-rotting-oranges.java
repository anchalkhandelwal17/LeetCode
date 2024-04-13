class Solution {
    public int orangesRotting(int[][] grid) {
        // DFS
        // TC : O(m*n)
        // SC : O(m*n)
        int m = grid.length;
        int n = grid[0].length;
        int totalMinutes = 2;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    dfs(i, j, grid, 2);
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) return -1;
                totalMinutes = Math.max(totalMinutes, grid[i][j]);
            }
        }
        return totalMinutes-2;
    }

    public void dfs(int i, int j, int[][] grid, int minute){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0
        || (grid[i][j] > 1  && grid[i][j] < minute)){
            return;
        }
        
        grid[i][j] = minute;

        dfs(i-1, j, grid, minute+1);
        dfs(i, j+1, grid, minute+1);
        dfs(i+1, j, grid, minute+1);
        dfs(i, j-1, grid, minute+1);
    }
}