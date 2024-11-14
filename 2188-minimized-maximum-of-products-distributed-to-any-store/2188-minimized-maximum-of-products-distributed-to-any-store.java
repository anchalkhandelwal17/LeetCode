class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        // TC : O(nlogn)
        // SC : O(1)
        int ans = 0;
        int lo = 1;
        int hi = 1000000;

        while(lo <= hi){
            int mid = (lo + hi)/2;

            if(check(n, quantities, mid)){
                ans = mid;
                hi = mid-1;
            }
            else{
                lo = mid+1;
            }
        }
        return ans;
    }

    public boolean check(int n, int[] arr, int m){

        for(int i=0; i<arr.length; i++){
            n = n- (arr[i] / m);
            if(arr[i] % m != 0) n--;

            if(n < 0) return false;
        }
        return true;
    }
}