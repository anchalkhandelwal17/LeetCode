class Solution {
    public int totalMoney(int n) {
        
        int totalAmount = 1;
        int initialAmount = 1;
        
        for(int i=2; i<=n; i++){
            
            totalAmount = totalAmount + ++initialAmount;
            
            if(i % 7 == 0){
                initialAmount = i/7;
            }
        }
        
        return totalAmount;
    }
}