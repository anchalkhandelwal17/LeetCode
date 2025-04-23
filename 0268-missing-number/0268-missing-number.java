class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        int n = nums.length;
        while(i < n){
            if(nums[i] == n) i++;
            else if(nums[i] != i){
                swap(nums, i, nums[i]);
            }
            else i++;
        }
        for(int k=0; k<n; k++){
            if(nums[k] != k){
                return k;
            }
        }
        return n;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}