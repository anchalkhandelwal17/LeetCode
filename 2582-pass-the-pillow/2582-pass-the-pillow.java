class Solution {
    public int passThePillow(int n, int time) {
        // TC : O(n)
        // SC : O(1)
        int curr = 0;
        int p = 1;
        boolean dir = true;
        while(curr != time){
            if(dir) p++;
            else p--;
            if(p == n){
                dir = false;
            }
            if(p == 1){
                dir = true;
            }
            curr++;
        }
        return p;
    }
}