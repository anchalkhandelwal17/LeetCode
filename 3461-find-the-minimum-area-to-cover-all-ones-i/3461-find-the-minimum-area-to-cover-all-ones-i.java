class Solution {
    public int minimumArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ones = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) ones++;
            }
        }
        if(ones == 1) return 1;
        int ones2 = 0;
        int firstIdx = -1;
        int jFirstIdxMin = Integer.MAX_VALUE;
        int jFirstIdxMax = Integer.MIN_VALUE;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1) {
                    ones2++;
                    jFirstIdxMin = Math.min(jFirstIdxMin, j);
                    jFirstIdxMax = Math.max(jFirstIdxMax, j);
                }
                if(firstIdx == -1 && ones2 == 1) {
                    firstIdx = i;
                }
                if(ones == ones2){
                    return (i - firstIdx + 1) * (Math.abs(jFirstIdxMin - jFirstIdxMax)+1);
                }
            }
        }
        return m*n;
    }
}