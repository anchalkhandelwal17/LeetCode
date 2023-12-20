class Solution {
    public int buyChoco(int[] prices, int money) {
        
        int smallest_price = Integer.MAX_VALUE;
        int second_smallest_price = Integer.MAX_VALUE;
        
        for(int i=0; i<prices.length; i++){
            if(prices[i] < smallest_price){
                second_smallest_price = smallest_price;
                smallest_price = prices[i];
            }else{
                second_smallest_price = Math.min(second_smallest_price, prices[i]);
            }
        }
        
        int moneyLeft = money - (second_smallest_price + smallest_price);
        
        return moneyLeft >= 0 ? moneyLeft : money;
    }
}
