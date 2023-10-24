class Solution {
    public int compareVersion(String version1, String version2) {

        String[] v_1 = version1.split("\\.");
        String[] v_2 = version2.split("\\.");

        int i= 0;
        int j = 0;

        while(i < v_1.length && j < v_2.length){
            if(Integer.parseInt(v_1[i]) > Integer.parseInt(v_2[j])){
                return 1;
            }
            if(Integer.parseInt(v_1[i]) < Integer.parseInt(v_2[j])){
                return -1;
            }
            i++;
            j++;
        }
        while(i < v_1.length){
            if(Integer.parseInt(v_1[i]) > 0){
                return 1;
            }
            i++;
        }

        while(j < v_2.length){
            if(Integer.parseInt(v_2[j]) > 0){
                return -1;
            }
            j++;
        }
        return 0;
    }
}