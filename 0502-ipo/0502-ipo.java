class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> pqMin = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> pqMax = new PriorityQueue<>((a,b) -> b[1]-a[1]);

        for(int i=0; i<profits.length; i++){
            pqMin.add(new int[]{capital[i], profits[i]});
        }

        while(k-- > 0){
            while(!pqMin.isEmpty() && pqMin.peek()[0] <= w){
                pqMax.add(pqMin.poll());
            }
            if(pqMax.isEmpty()) break;

            w += pqMax.poll()[1];
        }

        return w;
    }
}