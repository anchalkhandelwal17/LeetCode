class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // TC : O(nlog(1e9))
        // SC : O(1)
        if((m * k) > bloomDay.length) return -1;
        int lo = 1;
        int hi = (int)(1e9);
        int ans = -1;

        while(lo <= hi){
            int mid = (lo + hi)/2;
            if(check(mid, bloomDay, m, k)){
                ans = mid;
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return ans;
    }

    public boolean check(int mid, int[] arr, int m, int k){
        int cnt = k;
        for(int i=0; i<arr.length; i++){
            int val = arr[i];
            if(val <= mid){
                cnt--;
                if(cnt == 0){
                    m--;

                    if(m == 0) return true;
                    cnt = k;
                }
            }
            else{
                cnt = k;
            }
        }
        return false;
    }
}