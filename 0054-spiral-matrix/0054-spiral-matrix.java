class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = m-1;
        int dir = 0;
        int i;

        while(left <= right && top <= bottom){

            // from left to right
            if(dir == 0){
                for(i=left; i<=right; i++){
                    ans.add(matrix[top][i]);
                }
                top++;
            }

            // from top to bottom
            if(dir == 1){
                for(i=top; i<=bottom; i++){
                    ans.add(matrix[i][right]);
                }
                right--;
            }

            // from right to left
            if(dir == 2){
                for(i=right; i>=left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // from bottom to top
            if(dir == 3){
                for(i=bottom; i>=top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }

            dir = (dir + 1) % 4;
        }

        return ans;
    }
}