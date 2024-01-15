class Solution {
    public int jump(int[] nums) {
        if(nums.length <= 1)return 0;
        int jumps = 0;
        int nextJump = 0;
        int maxReachable = 0;
        
        for(int i=0; i<nums.length; i++){
            if(i > maxReachable) return -1;
            
            maxReachable = Math.max(maxReachable, nums[i]+i);
            if(i == nextJump){
                jumps++;
                nextJump = maxReachable;
                
                if(nextJump >= nums.length-1) return jumps;
            }
        }
        return jumps;
    }
}