class Solution {
    public long repairCars(int[] ranks, int cars) {
        // TC : O(n * log(1e14))
        // SC : O(1)
        long lo = 1;
        long hi = (long)(1e14);
        long ans = hi;

        while(lo <= hi){
            long mid = (lo + hi)/2;

            if(check(ranks, cars, mid)){
                ans = mid;
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return ans;
    }

    public boolean check(int[] ranks, int cars, long mid){
        int cnt = 0;
        for(int r : ranks){
            cnt += Math.sqrt(mid / r);

            if(cnt >= cars) return true;
        }
        return false;
    }
}