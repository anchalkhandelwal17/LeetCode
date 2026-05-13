class Solution {
    public long minOperations(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int i=1; i<n; i++){
            if(nums[i] < nums[i-1]){
                sum = sum + (nums[i-1] - nums[i]);
            }
        }
        return sum;
    }
}
