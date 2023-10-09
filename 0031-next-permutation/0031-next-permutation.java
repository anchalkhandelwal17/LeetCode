class Solution {
    public void nextPermutation(int[] nums) {
        
        int minIdx = -1;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                minIdx = i;
                break;
            }
        }
        if(minIdx == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }
        int maxIdx = -1;
        for(int i=nums.length-1; i>=0; i--){
            if(nums[i] > nums[minIdx]){
                maxIdx = i;
                break;
            }
        }
        swap(nums, minIdx, maxIdx);
        reverse(nums, minIdx+1, nums.length-1);
    }

    public void swap(int[] nums, int first, int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    public void reverse(int[] nums, int i, int j){
    int start = i;
    int end = j;
    while(start <= end){
        swap(nums, start, end);
        start++;
        end--;
    }
}
}