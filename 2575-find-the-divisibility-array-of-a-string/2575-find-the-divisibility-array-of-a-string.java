class Solution {
    public int[] divisibilityArray(String word, int m) {

//         some good explanation in discussion - 
//         Take word = "529" m = 4 for example,

//          5 % 4 = 1 => res[0] = 0

//          2 % 4 = 2 => currently, you have previous remainder, 
//          Therefore, you have to 10 * previous remainder which is '1' => 10 * 1 + 2 = 12. 
//          Therefore, 12 % 4 = 0 => res[1] = 1;
//          9 % 4 = 1 => However, your previous remainder is 0. 
//          Therefore, 10 * 0 = 0. It do not affect current remainder. => res[2] = 0

// The basic idea of a rolling remainder is that the remainder of the previous modulus
//  operation is used as an input for the next modulus operation. In this way, 
//  instead of computing the entire modulus in one go, the computation is split into 
//  smaller portions that can be processed sequentially


        int n = word.length();
        int[] ans = new int[n];
        long rem = 0;
        
        for(int i=0; i<n; i++){
            rem = (rem * 10 + word.charAt(i) - '0') % m;
            if(rem == 0){
                ans[i] = 1;
            }
        }
        return ans;
    }
}

