class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        // TC : O(n + n)
        // SC : O(n + n)
        int m = nums.length;
        int n = queries.length;
        boolean[] ans = new boolean[n];
        int[] parityCheck = new int[m];
        parityCheck[0] = 1;
        for(int i=1; i<m; i++){

            if((nums[i] %2) != (nums[i-1] % 2)){
                parityCheck[i] = parityCheck[i-1] + 1;
            }
            else{
                parityCheck[i] = 1;
            }
        }
        
        for(int i=0; i<n; i++){
            int k = queries[i][0];
            int l = queries[i][1];
            int prefix = parityCheck[l] - parityCheck[k];
            
            if(prefix == l-k){
                ans[i] = true;
            }
        }
        return ans;
    }
}