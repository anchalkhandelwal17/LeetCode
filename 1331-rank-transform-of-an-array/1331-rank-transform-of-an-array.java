class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // TC : O(nlogn)
        // SC : O(n + n + n)
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : arr) pq.offer(x);

        int last = Integer.MAX_VALUE;
        int rank = 1;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(!pq.isEmpty()){
            int curr = pq.poll();

            if(last != curr || last == Integer.MAX_VALUE){
                map.put(curr, rank);
                rank++;
            }
            last = curr;
        }
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            ans[i] = map.get(arr[i]);
        }
        return ans;
    }
}