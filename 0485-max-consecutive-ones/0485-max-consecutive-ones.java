class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int ans = Integer.MIN_VALUE;
        int ones = 0;

        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1) ones++;
            else if(nums[i] == 0) ones = 0;

            ans = Math.max(ans, ones);
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}