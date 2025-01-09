
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // TC : O(nlog(1e8))
        // SC : O(1)
        int lo = 1;
        int hi = (int)(1e9);

        int ans = -1;

        while (lo <= hi) {
            int m = (lo + hi) / 2;
            if (check(piles, h, m)) {
                ans = m;
                hi = m - 1;
            } else
                lo = m + 1;
        }
        return ans;
    }

    public boolean check(int[] piles, int h, int x) {
        long ans = 0;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            ans = ans + (piles[i] / x);
            if (piles[i] % x != 0)
                ans++;
        }
        return ans <= h;
    }
}

// Input: piles = [3,6,7,11], h = 8
// Output: 4

// 1 + 2 + 2 + 3

// pick a number x
// if a value p is div by x then add p/x to ans
// other wise add p/x + 1 to ans

// at the end if ans <= h true else false;