class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // TC : O(nlogn)
        // SC : O(1)
        Arrays.sort(intervals, (a, b) -> 
            Integer.compare(a[0], b[0]));

        int ans = 0;
        int n = intervals.length;
        int b = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < b) {
                ans++;
                b = Math.min(b, intervals[i][1]);
            } else {
                b = intervals[i][1];
            }
        }
        return ans;
    }
}