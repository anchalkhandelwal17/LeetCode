class Solution {
    public long flowerGame(int n, int m) {
        // long ans = 0;
        // for(int i=1; i<=n; i++){
        //     if(i%2 == 1){
        //         ans += m/2;
        //     }
        //     else {
        //         ans += (m+1)/2;
        //     }
        // }
        // return ans;
        
        long ans = 0;
        long oddX = (n+1)/2;
        long evenX = n/2;
        long oddY = (m+1)/2;
        long evenY = m/2;
        
        return (oddX * evenY) + (evenX * oddY);
    }
}