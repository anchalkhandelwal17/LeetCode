class Solution {
    public int longestOnes(int[] nums, int k) {

        int st = 0;
        int end = 0;
        int zeroes = 0;
        int ans = Integer.MIN_VALUE;
        while(end < nums.length){
            if(nums[end] == 0){
                zeroes++;
            }
            if(zeroes > k){
                while(zeroes > k){
                    if(nums[st] == 0){
                        zeroes--;
                    }
                    st++;
                }
            }
            ans = Math.max(ans, end-st+1);
            end++;
        }
        return ans;
    }
}