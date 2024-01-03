// class Solution {
//     public int rob(int[] nums) {
//         int[] dp = new int[nums.length];
//         Arrays.fill(dp, -1);
        
//         int ans = rec(0, nums,dp);
//         return ans;
//     }
    
//     public int rec(int i, int[] nums, int[] dp){
//         if(i >= nums.length){
//             return 0;
//         }
//         if(dp[i] != -1) return dp[i];
        
//         int take = nums[i] + rec(i+2, nums, dp);
//         int not_take = 0 + rec(i+1, nums, dp);
        
//         return dp[i] = Math.max(take , not_take);
//     }
// }

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        else if(n == 2) return Math.max(nums[0], nums[1]);
        
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i=1; i<n; i++){
            int take = nums[i];
            if(i > 1){
                take += dp[i-2];
            }
            
            int not_take = 0 + dp[i-1];
            
            dp[i] = Math.max(take, not_take);
        }
        return dp[n-1];
    }
}
