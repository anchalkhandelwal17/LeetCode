class Solution {
    public int maxEvents(int[][] events) {
        // TC : O(nlogn)
        // SC : O(1)
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = events.length;
        int i = 0;
        int ans = 0;
        int day = 0;
        while(!pq.isEmpty() || i < n){
            if(pq.isEmpty()){
                day = events[i][0];
            }

            while(i < n && events[i][0] <= day){
                pq.offer(events[i][1]);
                i++;
            }
            pq.poll();
            ans++;
            day++;
            while(!pq.isEmpty() && pq.peek() < day){
                pq.poll();
            }
        }
        return ans;
    }
}