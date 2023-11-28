class Solution {
    public int[] singleNumber(int[] nums) {
     
        Arrays.sort(nums);
        
        int idx = 0;
        int[] ans = new int[2];
        
        if(idx == 2) return ans;
        
        for(int i=1; i<nums.length; i++){
            if(nums[i] != nums[i-1]){
                ans[idx++] = nums[i-1];
            }
            else{
                i++;
            }
        }
        
        if(nums[nums.length-1] != nums[nums.length-2]){
            ans[idx] = nums[nums.length-1];
        }
        
        return ans;
    }
}