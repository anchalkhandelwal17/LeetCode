class Pair {
    long dist;
    int[] point;

    public Pair(long dist, int[] point){
        this.dist = dist;
        this.point = point;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // TC : O(nlogn)
        // SC : O(n)
        int n = points.length;
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b.dist, a.dist));

        for(int i=0; i<n; i++){

            int x = points[i][0];
            int y = points[i][1];

            long eqdDist = 1l * ((x * x) + (y * y));

            maxHeap.offer(new Pair(eqdDist, points[i]));
            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        int[][] ans = new int[k][2];
        int idx = 0;
        while(!maxHeap.isEmpty()){
            Pair p = maxHeap.poll();
            int[] arr = p.point;
            ans[idx][0] = arr[0];
            ans[idx][1] = arr[1];
            idx++;
        }
        return ans; 
    }
}