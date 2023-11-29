public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
       
        int ans = 0;
        
        for(int i=0; i<=31; i++){
            if((n & 1) == 1){
                ans |= 1 << 31-i;
            }
            
            n = n >> 1;
        }
        
        return ans;
    }
}