class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = search(nums, -1, true, target);
        int second = search(nums, -1, false, target);
        return new int[]{first,second};
    }

    public int search(int[] nums, int index, boolean flag, int target){

        int start = 0;
        int end = nums.length-1;

        while(start <= end){
            int mid = (start + end)/2;
            if(nums[mid] == target){
                index = mid;
                if(flag){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            else if(nums[mid] > target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return index;
    }
}