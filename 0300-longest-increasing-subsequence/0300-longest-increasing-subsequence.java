
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[][] dp = new int[n][n];
        
//         for(int[] arr : dp){
//             Arrays.fill(arr, -1);
//         }
//         int ans = lis(nums, 0, -1, dp);
//         return ans;
//     }
    
//     public int lis(int[] nums, int idx, int prev_idx, int[][] dp){
//         if(idx == nums.length){
//         return 0;
//     }
//         if(prev_idx != -1 && dp[idx][prev_idx] != -1) return dp[idx][prev_idx];
        
//         int take = 0;
//         if(prev_idx == -1 || nums[idx] > nums[prev_idx]){
//             take = 1 + lis(nums, idx+1, idx, dp);
//         }
        
//         int not_take = 0 + lis(nums, idx+1, prev_idx, dp);
        
//         if(prev_idx != -1){
//             dp[idx][prev_idx] = Math.max(take, not_take);
//         }
//         return Math.max(take, not_take);
//   }
// }


// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int[] dp = new int[n];
//         Arrays.fill(dp, 1);
//         int maxLen = 1;
        
//         for(int i=0; i<n; i++){
//             for(int j=0; j<i; j++){
//                 if(nums[i] > nums[j]){
//                      dp[i] = Math.max(dp[i], 1+dp[j]);
//                 }
//                 maxLen = Math.max(maxLen, dp[i]);
//             }
//         }
        
//         return maxLen;
//     }
// }

class Solution {
    public int lengthOfLIS(int[] nums) {
        
        int n = nums.length;
        List<Integer> list = new ArrayList<>();

        list.add(nums[0]);
        int len = 1;
        for(int i=1; i<n; i++){
            if(nums[i] > list.get(list.size()-1)){
                len++;
                list.add(nums[i]);
            }
            else {
                int idx = lower_bound(list, nums[i]);
                list.set(idx, nums[i]);
            }
        }
        return len;
    }
    

    // lower_bound func
    public int lower_bound(List<Integer> list, int val){
        
        int lo = 0;
        int hi = list.size();
        int idx = 0;
        while(lo < hi){
            
            int m = (lo + hi)/2;
            
            if(val <= list.get(m)){
                hi = m;
            }
            else lo = m+1;
        }
        if(lo < list.size() && list.get(list.size()-1) < val) lo++;
        return lo;
    }
}


