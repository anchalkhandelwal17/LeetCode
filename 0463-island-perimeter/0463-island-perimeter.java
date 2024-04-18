class Solution {
    public int islandPerimeter(int[][] grid) {
        // TC : O(m*n)
        // SC : O(1)
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                if(grid[i][j] == 1){
                    ans += 4;
                    if(i-1 >=0 && grid[i-1][j] == 1) ans -= 1;
                    if(j+1 < n && grid[i][j+1] == 1) ans -= 1;
                    if(i+1 < m && grid[i+1][j] == 1) ans -= 1;
                    if(j-1 >=0 && grid[i][j-1] == 1) ans -= 1;
                }
            }
        }
        return ans;
    }
}