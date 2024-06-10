class Solution {
    public int heightChecker(int[] heights) {
        // TC : O(n + k)
        // SC : O(n)
        int n = heights.length;
        int[] expected = new int[n];
        for(int i=0; i<n; i++){
            expected[i] = heights[i];
        }
        // Arrays.sort(expected);
        countingSort(expected);
        int cnt = 0;
        for(int i=0; i<n; i++){
            if(expected[i] != heights[i]){
                cnt++;
            }
        }
        return cnt;
    }
    public void countingSort(int[] arr){
        int min = Integer.MAX_VALUE;
        int max = -1;
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        for(int i=0; i<n; i++){
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }
        int i = 0;
        for(int idx=min; idx<=max; idx++){
            while(map.containsKey(idx) && map.get(idx) > 0){
                arr[i++] = idx;
                map.put(idx, map.getOrDefault(idx, 0)-1);
            }
        }
    }
}