class Solution {
    public long coloredCells(int n) {
        // TC : O(n)
        // SC : O(1)
        // 4 -> 8 -> 12 -> 16 -> 20
        
        long ans = 1;
        long add = 4;
        for(int i=2; i<=n; i++){
            ans = ans + add;
            add = add + 4;
        }
        return ans;
    }
}

