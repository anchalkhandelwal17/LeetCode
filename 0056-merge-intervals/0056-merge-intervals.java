class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            int a = intervals[i][0];
            int b = intervals[i][1];

            if(list.isEmpty() || list.get(list.size()-1)[1] < a){
                list.add(new int[]{a, b});
            }
            else{
                list.get(list.size()-1)[1] = Math.max(list.get(list.size()-1)[1], b);
            }
        }

        int[][] ans = new int[list.size()][2];
        for(int i=0; i<list.size(); i++){
            int a = list.get(i)[0];
            int b = list.get(i)[1];

            ans[i][0] = a;
            ans[i][1] = b;
        }
        return ans;
    }
}