class Solution {
    public int longestSubarray(int[] nums) {
        // TC : O(n + n)
        // SC : O(1)
        int n = nums.length;
        int numOfZeroes = 0;
        int ans = 0;
        int i = 0;
        int j = 0;
        while(j < n){
            if(nums[j] == 0){
                numOfZeroes++;
            }
            if(numOfZeroes > 1){
                while(i <= j && numOfZeroes > 1){
                    if(nums[i] == 0){
                        numOfZeroes--;
                    }
                    i++;
                }
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans-1;
    }
}