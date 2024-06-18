class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // TC : O(nlogn + mlogm)
        // SC : O(n)
        int n = difficulty.length;
        int m = worker.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        for(int i=0; i<n; i++){
            pq.offer(new int[]{profit[i], difficulty[i]});
        }

        Arrays.sort(worker);
        int i=m-1;
        int sum = 0;

        while(i >= 0 && !pq.isEmpty()){
            if(worker[i] >= pq.peek()[1]){
                sum += pq.peek()[0];
                i--;
            }
            else{
                while(!pq.isEmpty() && worker[i] < pq.peek()[1]){
                    pq.poll();
                }
            }
        }
        return sum;
    }
}