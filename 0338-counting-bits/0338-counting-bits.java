class Solution {
    public int[] countBits(int n) {
       
        int[] ans = new int[n+1];
        
        for(int i=1; i<=n; i++){
            
            int num = i;
            int ones = 0;
            while(num != 0){
                if((num & 1) == 1){
                    ones++;
                }
                
                num = num >> 1;
            }
            
            ans[i] = ones;
        }
        
        return ans;
    }
}