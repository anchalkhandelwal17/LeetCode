import java.util.*;
class Solution {
    public int maxScore(int[] arr) {
        // TC : O(nlogn)
        // SC O(1)

        Arrays.sort(arr);
        int n = arr.length;
        int cnt = 0;
        long sum = 0;
        int i = n-1;

        while(i >= 0){
            sum += arr[i];
            if(sum > 0){
                cnt++;
            }
            else break;
            i--;
        }
        return cnt;
    }
}