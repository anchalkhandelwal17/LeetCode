class Solution {
    public String[] findRelativeRanks(int[] score) {
        // TC : O(nlogn)
        // SC : O(n)
        int n = score.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : score){
            pq.offer(x);
        }
        int position = n;
        while(!pq.isEmpty()){
            map.put(pq.poll(), position--);
        }

        String[] ans = new String[n];
        for(int i=0; i<n; i++){
            if(map.get(score[i]) == 1){
                ans[i] = "Gold Medal";
            }
            else if(map.get(score[i]) == 2){
                ans[i] = "Silver Medal";
            }
            else if(map.get(score[i]) == 3){
                ans[i] = "Bronze Medal";
            }
            else{
                ans[i] = String.valueOf(map.get(score[i]));
            }
        }
        return ans;
    }
}