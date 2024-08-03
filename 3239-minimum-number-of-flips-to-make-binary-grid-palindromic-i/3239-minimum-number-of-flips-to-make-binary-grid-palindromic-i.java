class Solution {
    public int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int ans1 = 0;
        for(int i=0; i<n; i++){
            int s = 0;
            int e = m-1;
            
            while(s < e){
                if(grid[s][i] != grid[e][i]){
                    ans1++;
                    // break;
                }
                s++;
                e--;
            }
        }
        
        int ans2 = 0;
        for(int i=0; i<m; i++){
            int s = 0;
            int e = n-1;
            
            while(s < e){
                if(grid[i][s] != grid[i][e]){
                    ans2++;
                    // break;
                }
                s++;
                e--;
            }
        }
        return Math.min(ans1, ans2);
    }
}