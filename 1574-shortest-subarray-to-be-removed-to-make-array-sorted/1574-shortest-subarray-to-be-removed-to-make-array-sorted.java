class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        // TC : O(n)
        // SC : O(1)
        int l = 0;
        int n = arr.length;
        while(l+1 < n && arr[l] <= arr[l+1]){
            l++;
        }
        
        if(l == n-1) return 0;

        int r = n-1;
        while(r > l && arr[r-1] <= arr[r]){
            r--;
        }
        int ans = Math.min(r, n-l-1);

        int i = 0;
        int j = r;
        while(i <= l && j < n){
            if(arr[j] >= arr[i]){
                ans = Math.min(ans, j-i-1);
                i++;
            }
            else j++;
        }
        return ans;
    }
}