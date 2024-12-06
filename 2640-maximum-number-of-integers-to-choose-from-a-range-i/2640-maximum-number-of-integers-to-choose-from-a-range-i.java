class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // TC : O(m + n)
        // SC : O(m)
        HashSet<Integer> set = new HashSet<>();
        for(int x : banned) set.add(x);

        int cnt = 0;
        int sum = 0;

        for(int i=1; i<=n; i++){
            if(set.contains(i)) continue;
            else{
                if(sum + i > maxSum) return cnt;
                cnt++;
                sum += i;
            }
        }
        return cnt;
    }
}