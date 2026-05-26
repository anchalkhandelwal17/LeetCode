class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(target >= matrix[i][0] && target <= matrix[i][n-1]){
                    if(check(matrix, target, i)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean check(int[][] matrix, int target, int row){
        int lo = 0;
        int hi = matrix[0].length-1;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(matrix[row][mid] == target){
                return true;
            }
            else if(target > matrix[row][mid]){
                lo = mid+1;
            }
            else{
                hi = mid-1;
            }
        }
        return false;
    }
}