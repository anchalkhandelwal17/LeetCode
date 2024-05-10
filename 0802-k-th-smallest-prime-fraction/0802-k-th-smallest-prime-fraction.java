class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // TC : O(n ^ 2 * logk)
        // SC : O(k)
        PriorityQueue<Double> pq = new PriorityQueue<>((a, b) -> 
        Double.compare(b, a));
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                pq.offer((double)(arr[i]/(double)arr[j]));
                if(pq.size() > k){
                    pq.poll();
                }
            }
        }

        double kthSmallest = pq.poll();

        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                double fraction = (double)(arr[i]/(double)arr[j]);
                if(fraction == kthSmallest){
                    return new int[]{arr[i], arr[j]};
                }
            }
        }
        return new int[]{-1,-1};
    }
}