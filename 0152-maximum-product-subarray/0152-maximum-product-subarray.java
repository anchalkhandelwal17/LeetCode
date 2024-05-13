class Solution {
    public int maxProduct(int[] nums) {
        // TC : O(n*n)
        // SC : O(1)
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            int mul = 1;
            for(int j=i; j<nums.length; j++){
                mul *= nums[j];
                ans = Math.max(ans, mul);
            }
        }
        return ans;
    }
}