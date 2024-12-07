class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        // TC : O(nlog(1e9))
        // SC : O(1)
        int lo = 1;
        int hi = 1000000000;
        int ans = 0;

        while(lo <= hi){
            int mid = (lo + hi) / 2;

            if(check(nums, mid, maxOperations)){
                ans = mid;
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return ans;   
    }

    public boolean check(int[] nums, int mid, int operations){
        int cnt = 0;

        for(int x : nums){
            if(x > mid){
                cnt = cnt + ((x - 1) / mid);
            }
        }
        return cnt <= operations;
    }
}