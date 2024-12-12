class Solution {
    public long pickGifts(int[] gifts, int k) {
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : gifts){
            pq.offer(x);
        }

        while(k > 0){
            int val = (int) Math.floor(Math.sqrt(pq.poll()));
            pq.offer(val);
            k--;
        }

        while(!pq.isEmpty()){
            ans += pq.poll();
        }
        return ans;
    }
}