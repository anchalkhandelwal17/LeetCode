class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // TC : O(log(m * n))
        int m = matrix.length;
        int n = matrix[0].length;

        int start = 0;
        int end = n-1;

        while(start < m && end > -1){
            int val = matrix[start][end];

            if(val == target) return true;
            else if(val > target){
                end--;
            }
            else{
                start++;
            }
        }
        return false;
    }
}