class Pair{
    int dist;
    int[] arr = new int[2];
    public Pair(int dist, int[] arr){
        this.dist = dist;
        this.arr[0] = arr[0];
        this.arr[1] = arr[1];
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            return b.dist-a.dist;
        });

        for(int[] arr : points){
            pq.add(new Pair(((arr[0] * arr[0] + arr[1] * arr[1])), arr));
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        while(!pq.isEmpty()){
            k--;
            ans[k][0] = pq.peek().arr[0];
            ans[k][1] = pq.peek().arr[1];
            pq.poll();
        }
        return ans;
    }
}