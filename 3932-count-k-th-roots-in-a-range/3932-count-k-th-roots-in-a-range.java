class Solution {
    public int countKthRoots(int l, int r, int k) {
        int left = lowerBound(l, r, k);
        int right = upperBound(l, r, k);

        if (left == -1 || right == -1 || left > right) {
            return 0;
        }
        return right - left + 1;
    }

    public int lowerBound(int l, int r, int k) {
        int lo = 0;
        int hi = r;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            long val = pow(mid, k, r);

            if (val >= l) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public int upperBound(int l, int r, int k) {
        int lo = 0;
        int hi = r;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            long val = pow(mid, k, r);

            if (val <= r) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
    public long pow(int x, int k, int lim){
        long res = 1;

        while(k > 0){
            res *= x;
            if(res > lim) return lim+1;
            k--;
        }
        return res;
    }
}