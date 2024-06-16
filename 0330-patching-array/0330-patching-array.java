class Solution {
    public int minPatches(int[] nums, int n) {
        // TC : linear
        // SC : O(1)
        long sum = 1;
        int ans = 0;
        int i=0, len=nums.length;

        while(sum <= n){
            if(i < len && nums[i] <= sum){
                sum += nums[i];
                i++;
            }
            else{
                ans++;
                sum = sum + sum;
            }
        }
        return ans;
    }
}
