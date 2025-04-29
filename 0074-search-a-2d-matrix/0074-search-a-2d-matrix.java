class Solution {
    public boolean searchMatrix(int[][] nums, int target) {
        // TC : O(m * log(n))
        // SC : O(1)
        int m = nums.length;
        int n = nums[0].length;

        for(int i=0; i<m; i++){

            int lo = 0;
            int hi = n-1;

            while(lo <= hi){
                int mid = (lo + hi)/2;

                if(nums[i][mid] == target) return true;
                else if(nums[i][mid] > target){
                    hi = mid-1;
                }
                else lo = mid+1;
            }
        }
        return false;
    }
}