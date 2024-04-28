class Solution {
    public int minimumAddedInteger(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        for(int i=-1000; i<=1000; i++){
            if(check(nums1, nums2, i)){
                return i;
            }
        }
        return 100000;
    }
    public boolean check(int[] nums1, int[] nums2, int x){
        int i = 0;
        int j = 0;
        int cnt = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] + x == nums2[j]){
                i++;
                j++;
            }
            else{
                i++;
                cnt++;
            }
            if(cnt > 2) return false;
        }
        return true;
    }
}