// class Solution {
//     int max = Integer.MIN_VALUE;
//     public int maximalSquare(char[][] matrix) {
//         // TC : O(m * n)   SC : O(m * n) + recursion space
//         if(matrix.length == 0) return 0;
//         int row = matrix.length;
//         int col = matrix[0].length;
//         int[][] dp = new int[row][col];
//         for(int[] arr : dp){
//             Arrays.fill(arr, -1);
//         }
        
//         solve(matrix, 0, 0, dp);
//         return max * max;
//     }
    
//     public int solve(char[][] mat, int i, int j, int[][] dp){
//         if(i >= mat.length || j >= mat[0].length){
//             return 0;
//         }
//         if(dp[i][j] != -1) return dp[i][j];
        
//         int right = solve(mat, i, j+1, dp);
//         int diagonal = solve(mat, i+1, j+1, dp);
//         int down = solve(mat, i+1, j, dp);
        
//         if(mat[i][j] == '1'){
//             dp[i][j] = 1 + Math.min(Math.min(right, diagonal), down);
//             max = Math.max(max, dp[i][j]);
//             return dp[i][j];
//         }
//         else return dp[i][j] = 0;
//     }
// }

class Solution {
    int max = Integer.MIN_VALUE;
    public int maximalSquare(char[][] matrix) {
        // TC : O(m * n)   SC : O(m * n)
        if(matrix.length == 0) return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        
        int[][] dp = new int[row+1][col+1];
        int maxSquare = Integer.MIN_VALUE;
        
        for(int i=row-1; i>=0; i--){
            for(int j=col-1; j>=0; j--){
                if(matrix[i][j] == '1'){
                    int right = dp[i][j+1];
                    int diagonal = dp[i+1][j+1];
                    int down = dp[i+1][j];
                    
                    dp[i][j] = 1 + Math.min(Math.min(right, diagonal), down);
                    maxSquare = Math.max(maxSquare, dp[i][j]);
                }
            }
        }
        return maxSquare * maxSquare;
    }
}