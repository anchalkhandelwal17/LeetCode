class Solution {
    public int minBitFlips(int start, int goal) {
        // TC : constant
        // SC : constant
        int cnt = 0;
        for(int i=0; i<32; i++){
            int a = (1 << i) & start;
            int b = (1 << i) & goal;
            if(a != b) cnt++;
        }
        return cnt;
    }
}