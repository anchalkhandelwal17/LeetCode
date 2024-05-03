class Solution {
    public int compareVersion(String version1, String version2) {
        // TC : O(m + n)
        // SC : O(1)
        int i = 0, j = 0;
        int m = version1.length(), n = version2.length();

        while (i < m || j < n) {

            int val1 = 0;
            int val2 = 0;

            while(i < m && version1.charAt(i) != '.'){
                val1 = val1 * 10 + version1.charAt(i)-'0';
                i++;
            }
            while(j < n && version2.charAt(j) != '.'){
                val2 = val2 * 10 + version2.charAt(j)-'0';
                j++;
            }

            if(val1 > val2){
                return 1;
            }
            else if(val1 < val2){
                return -1;
            }
            i++;
            j++;
        }
        return 0;
    }
}