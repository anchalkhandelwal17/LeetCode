class Solution {
    public int getMaximumGold(int[][] grid) {
        // TC : O(m*n*3*m*n)
        // SC : O(m*n)
        int m = grid.length;
        int n = grid[0].length;
        int[] max = new int[1];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] != 0){
                    dfs(i, j, grid, m, n, 0, max);
                }
            }
        }
        return max[0];
    }

    public void dfs(int i, int j, int[][] grid, int m, int n, int curr, int[] max){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0){
            max[0] = Math.max(max[0], curr);
            return ;
        }
        int val = grid[i][j];
        grid[i][j] = 0;
        dfs(i-1, j, grid, m, n, curr+val, max);
        dfs(i, j+1, grid, m, n, curr+val, max);
        dfs(i+1, j, grid, m, n, curr+val, max);
        dfs(i, j-1, grid, m, n, curr+val, max);

        grid[i][j] = val;
    }
}