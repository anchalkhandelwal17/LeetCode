class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        // TC : O(n)
        // SC : O(1)
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int val = nums[i];
            if(val >= k) return 1;

            for(int j=i+1; j<n; j++){
                
                val |= nums[j];

                if(val >= k){
                    ans = Math.min(ans, j-i+1);
                }
            }
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}