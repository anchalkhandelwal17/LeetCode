class Solution {
    public int shipWithinDays(int[] weights, int days) {
        // TC : O(n * log(1e9))
        // SC : O(1)
        int lo = 1;
        int hi = (int)(1e9);

        int ans = hi;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(check(weights, days, mid)){
                ans = mid;
                hi = mid - 1;
            }
            else lo = mid + 1;
        }
        return ans;        
    }
    public boolean check(int[] arr, int days, int mid){
        int countDays = 1;
        int currWeight = arr[0];
        if(arr[0] > mid) return false;
        for(int i=1; i<arr.length; i++){
            if(arr[i] > mid) return false;
            if(currWeight + arr[i] > mid){
                currWeight = arr[i];
                countDays++;
            }
            else currWeight += arr[i];
        }
        return (countDays <= days);
    }
}

// weights = [1,2,3,1,1], days = 4
// c = 4, w = 2