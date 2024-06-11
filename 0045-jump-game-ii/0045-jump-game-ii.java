class Solution {
    public int jump(int[] nums) {
        // TC : O(n)
        // SC : O(1);

        int n = nums.length;
        if(n <= 1) return 0;
        int jumps = 0;
        int maxReach = 0;
        int timeToJump = 0;
        for(int i=0; i<n; i++){
            if(i > maxReach) return -1;
            
            maxReach = Math.max(maxReach, i + nums[i]);

            if(i == timeToJump){
                timeToJump = maxReach;
                jumps++;
                
                if(timeToJump >= n-1){
                    return jumps;
                }
            }
        }
        return jumps;
    }
}