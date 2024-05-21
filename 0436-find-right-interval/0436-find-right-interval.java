class Solution {
    public int[] findRightInterval(int[][] intervals) {

        int n = intervals.length;
        int[] ans = new int[n];
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] start = new int[n];
        for(int i=0; i<n; i++){
            map.put(intervals[i][0], i);
            start[i] = intervals[i][0];
        }

        Arrays.sort(start);

        for(int i=0; i<n; i++){
            int end = intervals[i][1];

            int val = find(start, end);
            if(val != Integer.MAX_VALUE){
                ans[i] = map.get(val);
            }
            else{
                ans[i] = -1;
            }
        }
        return ans;
    }

    public int find(int[] arr, int val){

        int lo = 0;
        int hi = arr.length-1;
        int ans = Integer.MAX_VALUE;

        while(lo <= hi){
            int m = (lo + hi)/2;

            if(arr[m] == val){
                return val;
            }
            else if(arr[m] > val){
                ans = arr[m];
                hi = m-1;
            }
            else{
                lo = m+1;
            }
        }
        return ans;
    }
}