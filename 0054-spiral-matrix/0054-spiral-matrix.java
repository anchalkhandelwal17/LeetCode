class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;
        List<Integer> list = new ArrayList<>();
        int dir = 0;
        int i;
        while(top <= bottom && left <= right){
            if(dir == 0){
                // left to right
                for(i=left; i<=right; i++){
                    list.add(matrix[top][i]);
                }
                top++;
            }
            else if(dir == 1){
                // top to bottom
                for(i=top; i<=bottom; i++){
                    list.add(matrix[i][right]);
                }
                right--;
            }
            else if(dir == 2){
                // right to left
                for(i=right; i>=left; i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }
            else if(dir == 3){
                // bottom to top
                for(i=bottom; i>=top; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }

            dir = (dir + 1) % 4;
        }
        return list;
    }
}