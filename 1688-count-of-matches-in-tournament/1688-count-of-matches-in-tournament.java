class Solution {
    public int numberOfMatches(int n) {
        
        int matchPlayed = 0;
        
        while(n != 1){
            
            matchPlayed += n/2;
            
            if(n % 2 == 0){
                n = n/2;
            }
            else{
                n = n/2 + 1;
            }
        }
        
        return matchPlayed;
    }
}