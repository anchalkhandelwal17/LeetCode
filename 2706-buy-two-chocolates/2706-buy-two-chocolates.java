class Solution {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int chocolate_1 = prices[0];
        int chocolate_2 = prices[1];
        
        int moneyLeft = money - (chocolate_1 + chocolate_2);
        
        return moneyLeft >= 0 ? moneyLeft : money;
    }
}
