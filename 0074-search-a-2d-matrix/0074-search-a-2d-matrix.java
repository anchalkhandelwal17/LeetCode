class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        // TC : O(log m*n)
        // SC : O(1)
        int n = matrix.length;
        int m = matrix[0].length;
        int lo = 0;
        int hi = n*m-1;

        while(lo <= hi){
            int mid = (lo + hi)/2;
            int row = mid/m;
            int col = mid%m;
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target) hi = mid-1;
            else lo = mid+1;
        }
        return false;
    }
}