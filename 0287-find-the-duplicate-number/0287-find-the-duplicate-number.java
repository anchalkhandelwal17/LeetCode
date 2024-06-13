class Solution {
    public int findDuplicate(int[] nums) {
        
        int i=0;
        int n = nums.length;

        while(i < n){
            int crct = nums[i]-1;

            if(nums[i] != nums[crct]){
                swap(nums, i, crct);
            }
            else i++;
        }
        return nums[n-1];
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}