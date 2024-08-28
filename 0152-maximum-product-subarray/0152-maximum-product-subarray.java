class Solution {
    public int maxProduct(int[] nums) {
        // TC : O(n^2)
        // SC : O(1)
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int prd = 1;
            for(int j=i; j<n; j++){
                prd *= nums[j];
                ans = Math.max(ans, prd);
            }
        }
        return ans;
    }
}