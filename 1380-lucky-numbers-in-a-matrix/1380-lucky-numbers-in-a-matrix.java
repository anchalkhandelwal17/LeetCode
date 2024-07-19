class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        // TC : O((m * n) * (m + n))
        // SC : O(1)
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        if(m == 0 || n == 0) return ans;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){

                int val = matrix[i][j];
                boolean flag1 = true;
                boolean flag2 = true;

                for(int k=0; k<n; k++){
                    if(matrix[i][k] < val){
                        flag1 = false;
                        break;
                    }
                }
                if(flag1){
                    for(int k=0; k<m; k++){
                        if(matrix[k][j] > val){
                            flag2 = false;
                            break;
                        }
                    }
                }
                if(flag1 && flag2){
                    ans.add(val);
                }
            }
        }
        return ans;
    }
}