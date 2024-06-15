class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // TC : O(nlogn)
        // SC : O(1)
        PriorityQueue<int[]> minPq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxPq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for(int i=0; i<profits.length; i++){
            minPq.offer(new int[]{capital[i], profits[i]});
        }
        
        while(k > 0){
            while(!minPq.isEmpty() && minPq.peek()[0] <= w){
                maxPq.offer(minPq.poll());
            }
            if(maxPq.isEmpty()) break;

            w += maxPq.peek()[1];
            maxPq.poll();
            k--;
        }
        return w;
    }
}