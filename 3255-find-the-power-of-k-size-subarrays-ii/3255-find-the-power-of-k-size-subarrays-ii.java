class Solution {
    public int[] resultsArray(int[] nums, int k) {
        // TC : O(n + n-k+1)
        // SC : O(n + n-k+1)
        int n = nums.length;
        int[] ans = new int[n - k+1];
        int[] pref = new int[n];
        pref[0] = 1;
        for(int i=1; i<n; i++){
            if(nums[i] == nums[i-1]+1){
                pref[i] = pref[i-1]+1;
            }
            else{
                pref[i] = 1;
            }
        }
        for(int i=0;i<n-k+1; i++){
            if(pref[i+k-1] >= k){
                ans[i] = nums[i+k-1];
            }
            else ans[i] = -1;
        }
        return ans;   
    }
}