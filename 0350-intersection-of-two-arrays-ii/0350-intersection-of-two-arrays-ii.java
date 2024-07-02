class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // TC : O(m + n)
        // SC : O(m + n)
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        int m = nums1.length;
        int n = nums2.length;

        for (int i = 0; i < m; i++) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int key : map1.keySet()){
            if(map2.containsKey(key)){
                int itr = Math.min(map1.get(key), map2.get(key));
                for(int i=0; i<itr; i++){
                    list.add(key);
                }
            }
        }
        int[] ans = new int[list.size()];
        for(int i=0; i<ans.length; i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}