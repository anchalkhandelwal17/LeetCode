class Solution {
    public int maxSubArray(int[] nums) {
        // TC : O(n)
        // SC : O(1)
        int n=nums.length, ans=Integer.MIN_VALUE, sum=0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            ans = Math.max(ans, sum);
            if(sum < 0){
                sum = 0;
            }
        }
        return ans;
    }
}