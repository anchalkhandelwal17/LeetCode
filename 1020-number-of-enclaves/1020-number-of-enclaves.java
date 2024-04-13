class Solution {
    public int numEnclaves(int[][] grid) {
        // DFS
        // TC : O(m*n)
        // SC : O(m*n)
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] copyGrid = grid;

        for(int i=0; i<m; i++){
            if(grid[i][0] == 1){
                dfs(i, 0, copyGrid);
            }
            if(grid[i][n-1] == 1){
                dfs(i, n-1, copyGrid);
            }
        }

        for(int i=0; i<n; i++){
            if(grid[0][i] == 1){
                dfs(0, i, copyGrid);
            }
            if(grid[m-1][i] == 1){
                dfs(m-1, i, copyGrid);
            }
        }
        int trappedLandCells = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(copyGrid[i][j] == 1){
                    trappedLandCells++;
                }
            }
        }
        return trappedLandCells;
    }
    public void dfs(int i, int j, int[][] copyGrid){

        if(i < 0 || i >= copyGrid.length || j < 0 || j >= copyGrid[0].length
        || copyGrid[i][j] != 1){
            return;
        }
        copyGrid[i][j] = -1;
        dfs(i-1, j, copyGrid);
        dfs(i, j+1, copyGrid);
        dfs(i+1, j, copyGrid);
        dfs(i, j-1, copyGrid);
    }
}