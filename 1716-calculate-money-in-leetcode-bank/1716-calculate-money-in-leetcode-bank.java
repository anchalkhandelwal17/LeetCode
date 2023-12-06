class Solution {
    public int totalMoney(int n) {
        
        int weeks = n / 7;
        int lo = 28;
        int hi = 28 + 7 * (weeks - 1);
        
        int totalAmount = ( weeks * (lo + hi) /2);
        
        for(int i=1; i<=n%7; i++){
            totalAmount += weeks + i;
        }
        
        return totalAmount;
    }
}