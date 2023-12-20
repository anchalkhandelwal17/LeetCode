class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int start = 0;
        int end = prices.length-1;
        
        int maxMoneyLeft = -1;
        while(start != end){
            if(prices[start] + prices[end] <= money){
                maxMoneyLeft =  money - (prices[start] + prices[end]);
            }
            end--;
        }
        return maxMoneyLeft == -1 ? money : maxMoneyLeft;
    }
}
