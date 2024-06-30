class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(solve(red, blue), solve(blue, red));
    }

    public int solve(int a , int b){
        for(int i=1; i<=100; i++){
            if(i % 2 == 1){
                if(a < i) return i-1;
                a -= i;
            }
            else{
                if(b < i) return i-1;
                b -= i;
            }
        }
        return -1;
    }
}