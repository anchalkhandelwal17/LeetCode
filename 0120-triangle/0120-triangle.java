class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
         int m = triangle.size();
        int[][] dp = new int[m][];
        for(int i=0; i<m; i++){
            dp[i] = new int[i+1];
        }
        for(int[] arr : dp){
            Arrays.fill(arr, (int)1e5);
        }
        int ans = rec(triangle, 0, 0, m, dp);
        return ans;
    }
    
    public int rec(List<List<Integer>> triangle, int i, int j, int m, int[][] dp){
        if(i == m) return 0;
        if(dp[i][j] != (int)1e5) return dp[i][j];
        
        int idx = triangle.get(i).get(j) + rec(triangle, i+1, j, m, dp);
        int idx_plus_one = triangle.get(i).get(j) + rec(triangle, i+1, j+1, m, dp);
        
        return dp[i][j] = Math.min(idx, idx_plus_one);
    }
}