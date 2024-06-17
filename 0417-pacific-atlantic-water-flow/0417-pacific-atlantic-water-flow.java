class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // dfs solution

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i=0; i<n; i++){
            dfs(0, i, heights, pacific, heights[0][i]);
            dfs(m-1, i, heights, atlantic, heights[m-1][i]);
        }

        for(int i=0; i<m; i++){
            dfs(i, 0, heights, pacific, heights[i][0]);
            dfs(i, n-1, heights, atlantic, heights[i][n-1]);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, int[][] grid, boolean[][] flag, int prevH){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] < prevH
            || flag[i][j]){
            return;
        }
        flag[i][j] = true;

        dfs(i-1, j, grid, flag, grid[i][j]);
        dfs(i, j+1, grid, flag, grid[i][j]);
        dfs(i+1, j, grid, flag, grid[i][j]);
        dfs(i, j-1, grid, flag, grid[i][j]);
    }
}