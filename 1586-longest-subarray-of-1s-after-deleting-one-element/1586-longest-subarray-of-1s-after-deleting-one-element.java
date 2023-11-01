class Solution {
    public int longestSubarray(int[] nums) {
        
        int ans = Integer.MIN_VALUE;
        int j=0;
        int i=0;
        int zeroes = 0;

        while(j < nums.length){
            if(nums[j] == 0){
                zeroes++;
            }
            while(i < nums.length && zeroes > 1){
                if(nums[i] == 0){
                    zeroes--;
                }
                i++;
            }
            ans = Math.max(ans, j-i);
            j++;
        }

        return ans;
    }
}