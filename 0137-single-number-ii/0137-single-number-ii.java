class Solution {
    public int singleNumber(int[] nums) {
        
        Arrays.sort(nums);
        int ans = 0;
        
        for(int i=0; i<nums.length-1; i++){
            ans = nums[i];
            ans = ans & nums[++i];
            ans = ans ^ nums[++i];
            
            if(ans != 0) return nums[i-2];
        }
        
        return nums[nums.length-1];
    }
}