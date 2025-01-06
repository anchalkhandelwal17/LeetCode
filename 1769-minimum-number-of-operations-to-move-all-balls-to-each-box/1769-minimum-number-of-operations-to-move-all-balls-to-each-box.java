class Solution {
    public int[] minOperations(String boxes) {
        // TC : O(n^2)
        // SC : O(1)
        int n = boxes.length();
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            int sum = 0;

            for(int j=0; j<n; j++){

                if(i == j) continue;
                char c = boxes.charAt(j);

                if(c == '1'){
                    sum = sum + Math.abs(j - i);
                }
            }

            ans[i] = sum;
        }

        return ans;
    }
}

// 0 - if empty
// 1 - if filled

// first brute force can be used

// now how can we optimize it ?

// let's write brute force first

// let's first figure out whats is the thing that we are repeatedly doing