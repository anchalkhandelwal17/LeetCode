class Solution {
    public boolean canMakeSquare(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i+1 < m && j+1 < n && (i+1 < m && j+1 < n)){
                    int b = 0;
                    int w = 0;
                    if(grid[i][j] == 'B') b++;
                    else w++;
                    
                    if(grid[i+1][j] == 'B') b++;
                    else w++;
                    
                    if(grid[i][j+1] == 'B') b++;
                    else w++;
                    
                    if(grid[i+1][j+1] == 'B') b++;
                    else w++;
                    
                    if(b >= 3 || w >= 3) return true;
                }
            }
        }
        return false;
    }
}