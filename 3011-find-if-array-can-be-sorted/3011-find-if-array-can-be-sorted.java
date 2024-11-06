class Solution {
    public boolean canSortArray(int[] nums) {
        // TC : O(n^2)
        // SC : O(1)
        int n = nums.length;
        for(int i=0; i<n-1; i++){
            for(int j=0; j<n-1-i; j++){
                if(cnt(nums[j]) == cnt(nums[j+1]) && nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }

        for(int i=0; i<n-1; i++){
            if(nums[i] > nums[i+1]) return false;
        }
        return true;
    }

    public int cnt(int n){
        int cnt = 0;
        while(n != 0){
            if((n & 1) == 1) cnt++;

            n >>= 1;
        }
        return cnt;
    }
}