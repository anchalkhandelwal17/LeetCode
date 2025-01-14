class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] temp1 = new int[51];
        int[] temp2 = new int[51];
        int[] ans = new int[n];

        for(int i=0; i<n; i++){
            int val1 = A[i];
            int val2 = B[i];

            temp1[val1]++;
            temp2[val2]++;

            int cnt = 0;
            for(int j=0; j<=50; j++){
                if(temp1[j] != 0 && temp2[j] != 0 && temp1[j] == temp2[j]) cnt++;
            }

            ans[i] = cnt;
        }

        return ans;
    }
}

