class Solution {
    public int findLongestChain(int[][] pairs) {
        // TC : O(nlogn)
        // SC : O(1)
        Arrays.sort(pairs, (a,b) -> a[1] - b[1]);

        int len = 1;
        int n = pairs.length;
        int b = pairs[0][1];
        for(int i=1; i<n; i++){
            int c = pairs[i][0];

            if(b < c){
                len++;
                b = pairs[i][1];
            }
        }
        return len;   
    }
}