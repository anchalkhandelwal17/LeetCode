class Solution {
    public int[][] merge(int[][] intervals) {
        // TC : O(nlogn)
        // SC : O(n)
        int n = intervals.length;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        for(int i=0; i<n; i++){
            int a = intervals[i][0];
            int b = intervals[i][1];

            if(list.isEmpty() || list.get(list.size()-1)[1] < a){
                list.add(new int[]{a, b});
            }
            else{
                list.get(list.size() - 1)[1] = Math.max(list.get(list.size() - 1)[1], b);
            }
        }

        int[][] ans = new int[list.size()][2];

        for(int i=0; i<ans.length; i++){
            ans[i][0] = list.get(i)[0];
            ans[i][1] = list.get(i)[1];
        }

        return ans;
    }
}