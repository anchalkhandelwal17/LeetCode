class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int ans = Integer.MAX_VALUE;
        long sum = 0;
        int j=0;
        int i=0;

        while(j < nums.length){
            sum += nums[j];
            if(sum < target){
                j++;
            }
            else if(sum >= target){
                while(i < nums.length && sum >= target){
                    ans = Math.min(ans, j-i+1);
                    sum -= nums[i];
                    i++;
                }
                j++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans; 
    }
}