class Solution {
    public int reverseBits(int n) {
        int ans = 0;

        for(int i=0; i<=31; i++){
            if((n & 1) == 1){
                ans = ans | 1 << 31 - i;
            }
            n >>= 1;
        }
        return ans;
    }
}