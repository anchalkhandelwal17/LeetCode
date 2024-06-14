class Solution {
    public int minIncrementForUnique(int[] nums) {
        // TC : O(nlogn)
        // SC : O(1)
        int n = nums.length;
        int cnt = 0;
        Arrays.sort(nums);

        for(int i=1; i<n; i++){
            if(nums[i] <= nums[i-1]){
                int diff = nums[i-1]+1 - nums[i];
                cnt += diff;
                nums[i] = nums[i-1]+1;
            }
        }
        return cnt;
    }
} 