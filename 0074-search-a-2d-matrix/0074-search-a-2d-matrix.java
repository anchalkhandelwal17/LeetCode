class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int start = matrix.length;
        int end = matrix[0].length;

        int row = 0;
        int col = end-1;

        while(row < start && col > -1){
            int curr = matrix[row][col];
            if(curr == target) return true;
            else if(curr > target){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }
}