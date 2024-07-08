class Solution {
    public int findTheWinner(int n, int k) {
        // TC : O(n * k)
        // SC : O(n)
        if(k > n){
            k =k % n;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=1; i<=n; i++) q.offer(i);
        int p = 0;
        while(q.size() > 1){
            for(int i=1; i<k; i++){
                q.offer(q.poll());
            }
            q.poll();
        }
        return q.peek();
    }
}