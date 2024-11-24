class Solution {
    public long maxMatrixSum(int[][] matrix) {
        // TC : O(m * n)
        // SC : O(1)
        int m = matrix.length;
        int n = matrix[0].length;

        long ans = 0;
        int cnt = 0;
        int smallestNegative = Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] <= 0){
                    cnt++;
                }

                smallestNegative = Math.min(Math.abs(matrix[i][j]), smallestNegative);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans += Math.abs(matrix[i][j]);
            }
        }
        if(cnt % 2 == 0) return ans;
        return ans - (2 * smallestNegative);
    }
}