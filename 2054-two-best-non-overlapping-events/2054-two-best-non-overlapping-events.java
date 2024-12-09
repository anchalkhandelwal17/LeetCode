class Solution {
    public int maxTwoEvents(int[][] events) {
        // TC : O(nlogn)
        // SC : O(n)
        Arrays.sort(events, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        int res = 0;
        int max = 0;

        pq.offer(new int[]{events[0][1], events[0][2]});

        for(int i=1; i<events.length; i++){

            while(!pq.isEmpty() && events[i][0] > pq.peek()[0]){
                int[] curr = pq.poll();

                max = Math.max(max, curr[1]);
            }
            res = Math.max(res, max + events[i][2]);
            pq.offer(new int[]{events[i][1], events[i][2]});
        }

        while(!pq.isEmpty()){
            res = Math.max(res, pq.peek()[1]);
            pq.poll();
        }
        return res;
    }
}