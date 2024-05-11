class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i+1 <m){
                    if(grid[i][j] == grid[i+1][j]){
                        continue;
                    }
                    else return false;
                }
                if(j+1 < n){
                    if(grid[i][j] != grid[i][j+1]){
                        continue;
                    }
                    else return false;
                }
            }
        }
        return true;
    }
}