class Solution {
    public int maxSubArray(int[] nums) {
        // TC : O(n)
        // SC : O(1)
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        int n = nums.length;

        for(int i=0; i<n; i++){
            int val = nums[i];

            sum += val;
            ans = Math.max(ans, sum);
            if(sum < 0){
                sum = 0;
            }
            
        }
        return ans;
    }
}

// kadane's algo can be used
