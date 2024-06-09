class Solution {
    public int numberOfChild(int n, int k) {
        
        boolean flag = true;
        int cnt = 0;
        int i = 0;
        while(cnt < k){
            cnt++;
            // System.out.println(i);
            if(i == n-1){
                flag = false;
            }
            else if(i == 0){
                flag = true;
            }
            if(flag) i++;
            else i--;
            
        }
        return i;
    }
}