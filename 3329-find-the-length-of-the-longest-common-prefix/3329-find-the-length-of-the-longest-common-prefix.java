class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        // TC : O(n * 8) + O(m * 8)
        // SC : O(8!)
        int cnt = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            int a = arr1[i];
            while(a != 0){
                set.add(a);
                a /= 10;
            }
        }
        for(int i=0; i<arr2.length; i++){
            int b = arr2[i];
            int currLen = 0;
            while(b != 0){
                if(set.contains(b)){
                    while(b != 0){
                        currLen++;
                        b /= 10;
                    }
                    break;
                }
                b /= 10;
            }
            cnt = Math.max(cnt, currLen);
        }
        return cnt;
    }

}