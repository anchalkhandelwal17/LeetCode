class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        while(i < n && newInterval[0] > intervals[i][1]){
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        while(i < n && newInterval[1] >= intervals[i][0]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        list.add(new int[]{newInterval[0], newInterval[1]});

        while(i < n){
            list.add(new int[]{intervals[i][0], intervals[i][1]});
            i++;
        }

        int[][] ans = new int[list.size()][2];
        for(int k=0; k<list.size(); k++){
            ans[k][0] = list.get(k)[0];
            ans[k][1] = list.get(k)[1];
        }

        return ans;
    }
}