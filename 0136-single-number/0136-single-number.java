class Solution {
    public int singleNumber(int[] nums) {
        
        Arrays.sort(nums);
        
        int start = 0;
        int end = 1;
        int ans = Integer.MIN_VALUE;
        
        while(start < nums.length){
            
            while(end < nums.length && nums[end] == nums[start]){
                ++end;
            }
            
            if(end - start == 1) {
                ans = nums[start];
                break;
            }
            
            start = end++;
        }
        
        return ans;
    }
}