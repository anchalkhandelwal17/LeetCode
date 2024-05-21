class Solution {
    public int[] findRightInterval(int[][] intervals) {
        
        int n = intervals.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int idx = -1;
            int min = Integer.MAX_VALUE;
            for(int j=0; j<n; j++){
                if(intervals[j][0] == end){
                    idx = j;
                    break;
                }
                if(intervals[j][0] >= end){
                    if(intervals[j][0] < min){
                        min = intervals[j][0];
                        idx = j;
                    }
                }
            }
            ans[i] = idx;
        }
        return ans;
    }
}