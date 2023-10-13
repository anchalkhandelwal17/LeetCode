class StockSpanner {
    Stack<int[]> stock;

    public StockSpanner() {
        stock = new Stack<>();
    }
    
    public int next(int price) {
        int days = 1;
        while(!stock.isEmpty() && stock.peek()[0] <= price){
            days += stock.pop()[1];
        }
        stock.push(new int[]{price, days});
        return days;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */