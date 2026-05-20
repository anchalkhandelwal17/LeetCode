class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] sMap = new int[256];
        int[] tMap = new int[256];

        for(int i=0; i<t.length(); i++){
            tMap[t.charAt(i) - '0']++;
        }

        int i = 0;
        int j = 0;
        int ans = Integer.MAX_VALUE;
        int ansIIdx = -1;
        int ansJIdx = -1;
       

        while(j < n){
            sMap[s.charAt(j) - '0']++;

            while(check(sMap, tMap)){
                if(ans > j-i+1){
                    ans = j-i+1;
                    ansIIdx = i;
                    ansJIdx = j;
                }
                sMap[s.charAt(i) - '0']--;
                i++;
            }
            j++;
        }
        return ansJIdx == -1 ? "" : s.substring(ansIIdx, ansJIdx+1);
    }

    public boolean check(int[] arr1, int[] arr2) {
        // arr1 -> s
        // arr2 -> t
        for (int i = 0; i < 256; i++) {
            if (arr2[i] != 0 && arr1[i] < arr2[i]) {
                return false;
            }
        }
        return true;
    }
}

// 