class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if(n == 1) return 0;
        int reachAtIdx = n-1;
        int minJumps = 0;
        int maxJumpReach = 0;
        int timeToJump = 0;

        for(int i=0; i<n; i++){

            maxJumpReach = Math.max(maxJumpReach, i + nums[i]);

            if(timeToJump == i){
                timeToJump = maxJumpReach;
                minJumps++;

                if(maxJumpReach >= reachAtIdx){
                    return minJumps;
                }
            }
        }
        return minJumps;
    }
}