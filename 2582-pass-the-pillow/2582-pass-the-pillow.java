class Solution {
    public int passThePillow(int n, int time) {
        // TC : linear
        // SC : constant
        int p = 1;
        int itr = 1;
        boolean flag = true;
        while(itr <= time){
            if(flag){
                ++p;
            }
            else --p;
            if(p == n){
                flag = false;
            }
            else if(p == 1){
                flag = true;
            }
            itr++;
        }
        return p;
    }
}