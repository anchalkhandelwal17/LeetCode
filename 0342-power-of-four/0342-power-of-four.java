class Solution {
    public boolean isPowerOfFour(int n) {
        
        boolean ans = solve(n, 4);
        return ans;
    }
    
    public boolean solve(int n, long num){
        if(num == n || n == 1) return true;
        else if(num > n) return false;
        
        return solve(n, num*4);
    }
}