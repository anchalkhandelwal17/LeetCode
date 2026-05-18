class Solution {
    public int maxArea(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int maxWater = Integer.MIN_VALUE;

        while(l < r){
            int a = nums[l];
            int b = nums[r];

            int min = Math.min(a, b);

            maxWater = Math.max(maxWater, min * (r - l));

            if(b < a){
                r--;
            }
            else{
                l++;
            }
        }
        return maxWater;
    }
}