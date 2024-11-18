class Solution {
    public int[] decrypt(int[] code, int k) {
        // TC : O(n ^ 2)
        // SC : O(n*2 + n)
        int n = code.length;
        int[] ans = new int[n];
        int[] temp = new int[n * 2];
        for(int i=0; i<n; i++){
            temp[i] = code[i];
            temp[i + n] = code[i];
        }
        if(k == 0) return ans;

        if(k > 0){
            for(int i=0; i<n; i++){
                for(int j=i+1; j<=i+k; j++){
                    ans[i] = ans[i] + temp[j];
                }
            }
        }
        else{
            k = -1 * k;
            for(int i=0; i<n; i++){
                for(int j=i+n-1; j>=i+n-k; j--){
                    ans[i] = ans[i] + temp[j];
                }
            }
        }

        return ans;
    }
}