class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int cnt = 0;
        int b = intervals[0][1];

        for(int i=1; i<intervals.length; i++){
            int a = intervals[i][0];

            if(b > a){
                cnt++;
                b = Math.min(b, intervals[i][1]);
            }
            else{
                b = intervals[i][1];
            }
        }

        return cnt;
    }
}