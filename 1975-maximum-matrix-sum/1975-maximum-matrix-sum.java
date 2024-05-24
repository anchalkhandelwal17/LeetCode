class Solution {
    public long maxMatrixSum(int[][] matrix) {
        // TC : O(n*n)
        // SC : O(1)
        int n = matrix.length;
        long sum = 0;
        int minVal = Integer.MAX_VALUE;
        int neg = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] < 0) neg++;
                sum += Math.abs(matrix[i][j]);

                if(minVal > Math.abs(matrix[i][j])){
                    minVal = Math.abs(matrix[i][j]);
                }
            }
        }
        if(neg % 2 == 0) return sum;
        return sum - 2*minVal;
    }
}