class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        Arrays.fill(ans, -1);
        for(int i=0; i<nums1.length; i++){

            int j=0;
            for(; j<nums2.length; j++){
                if(nums1[i] == nums2[j]){
                    for(; j<nums2.length; j++){
                        if(nums2[j] > nums1[i]){
                            ans[i] = nums2[j];
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return ans;
    }
}