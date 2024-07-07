class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        // TC : log base(numExchange(numBottles));
        // SC : O(1)
        int ans = numBottles;
        while(numBottles >= numExchange){
            int rem = numBottles / numExchange;
            ans += rem;
            numBottles = numBottles % numExchange + rem;
        }
        return ans;
    }
}