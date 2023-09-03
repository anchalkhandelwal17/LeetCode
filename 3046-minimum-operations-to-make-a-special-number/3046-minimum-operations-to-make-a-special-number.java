class Solution {
    public int minimumOperations(String num) {
     
        boolean zero = false;
        boolean five = false;

        int n = num.length();
        for(int i=n-1; i>=0; i--){
            int currVal = num.charAt(i) - '0';
            if((zero && (currVal == 0 || currVal == 5) || (five && (currVal == 2 || currVal == 7)))){

                return n-1-i-1;
            }
            if(currVal == 0){
                zero = true;
            }
            if(currVal == 5){
                five = true;
            }
        }
        if(zero){
            return n-1;
        }
        return n;
    }
}