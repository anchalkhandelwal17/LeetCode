class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];

        for(int i=0; i<nums1.length; i++){

            int j=0;
            for(; j<nums2.length; j++){
                boolean flag = false;
                if(nums1[i] == nums2[j]){
                    for(; j<nums2.length; j++){
                        if(nums2[j] > nums1[i]){
                            ans[i] = nums2[j];
                            flag = true;
                            break;
                        }
                    }
                    if(!flag){
                        ans[i] = -1;
                    }
                    break;
                }
            }
        }
        return ans;
    }
}