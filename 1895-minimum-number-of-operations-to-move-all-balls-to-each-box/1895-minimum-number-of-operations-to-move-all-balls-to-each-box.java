class Solution {
    public int[] minOperations(String boxes) {
        // TC : O(n)
        // SC : O(n)
        int n = boxes.length();
        int[] leftPref = new int[n];
        int[] rightPref = new int[n];
        int[] ans = new int[n];

        int pref = boxes.charAt(0) - '0';
        
        for(int i=1; i<n; i++){
            leftPref[i] = leftPref[i - 1] + pref;

            pref += boxes.charAt(i) - '0'; 
        }

        pref = boxes.charAt(n-1) - '0';

        for(int i=n-2; i>=0; i--){
            rightPref[i] = rightPref[i + 1] + pref;

             pref += boxes.charAt(i) - '0'; 
        }

        for(int i=0; i<n; i++){
            ans[i] = leftPref[i] + rightPref[i];
        }

        return ans;
    }
}