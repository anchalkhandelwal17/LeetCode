class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        for(int i=0; i<n; i++){
            int sizeRem = n-i;
            if(sizeRem < 3 && nums[i] == 0) return -1;
            else if(nums[i] == 0){
                cnt++;
                nums[i] = 1;
                nums[i+1] = nums[i+1] == 0 ? 1 : 0;
                nums[i+2] = nums[i+2] == 0 ? 1 : 0;
            }
        }
        for(int i=0; i<n; i++){
            if(nums[i] == 0) return -1;
        }
        return cnt;
    }
}