class Solution {
    public int minGroups(int[][] intervals) {
        // TC : O(nlogn)
        // SC : O(1)

        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int[] i : intervals){
            int a = i[0];
            int b = i[1];

            if(!pq.isEmpty() && a  > pq.peek()){
                pq.poll();
            }
            pq.offer(b);
        }

        return pq.size();
    }
}