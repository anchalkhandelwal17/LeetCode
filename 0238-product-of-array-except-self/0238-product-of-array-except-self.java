class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        int[] suf = new int[n];

        pref[0] = nums[0];
        for(int i=1; i<n; i++){
            pref[i] = pref[i-1] * nums[i];
        }
        suf[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            suf[i] = suf[i+1] * nums[i];
        }

        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            if(i == 0) ans[i] = i+1 < n ? suf[i+1] : nums[i];

            else if(i == n-1) ans[i] = i-1 >= 0 ? pref[i-1] : nums[i];
            
            else ans[i] = suf[i+1] * pref[i-1];
        }
        return ans;
    }
}