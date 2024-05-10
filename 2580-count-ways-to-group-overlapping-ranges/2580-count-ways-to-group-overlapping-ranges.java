class Solution {
    public int countWays(int[][] ranges) {
        // TC : O(nlogn)
        // SC : O(1)
        Arrays.sort(ranges, (a, b) -> Integer.compare(a[0], b[0]));
        int mod = (int)(1e9) + 7;
        int ans = 2;
        int a = ranges[0][1];
        for(int i=1; i<ranges.length; i++){
            int b = ranges[i][0];
            
            if(b > a){
                ans = ((ans * 2) % mod);
            }
            
           a = Math.max(a, ranges[i][1]);
        }
        return ans;
    }
}