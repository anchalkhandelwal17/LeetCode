class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = (int)(1e9);
        int ans = -1;

        while(min <= max){
            int mid = (min + max) / 2;

            if(check(piles, h, mid)){
                ans = mid;
                max = mid-1;
            }
            else min = mid+1;
        }
        return ans;
    }

    public boolean check(int[] nums, int h, int k){
        long cnt = 0;
        for(int i=0; i<nums.length; i++){
            int x = nums[i] / k;
            cnt += x;
            if(nums[i] % k != 0) cnt++;
        }
        return cnt <= h;
    }
}