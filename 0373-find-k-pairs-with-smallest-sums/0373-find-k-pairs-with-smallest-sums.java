class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // create a min heap which will sort elements on the basis of smallest sum of nums1 + nums2
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        List<List<Integer>> ans = new ArrayList<>();

        // if either of the given inputs are 0 which means we can not generate any pair
        if(nums1.length == 0 || nums2.length == 0 || k == 0){
            return ans;
        }

        // storing the first n pairs in heap prior to creating the k pairs
        // creating the pairs by adding all the elements in nums1 with first ele of nums2 one by one
        for(int i=0; i<nums1.length; i++){
            pq.add(new int[]{nums1[i] + nums2[0], 0});
        }

        // looping until k becomes zero or the heap becomes empty
        while(k > 0 && !pq.isEmpty()){
            int[] minPair = pq.poll();
            // this variable will store the sum of element at nums1 + element at nums2
            int sum = minPair[0];
            // this variable will store the curr position of nums2 that is used to create pair with nums1 element
            int pos = minPair[1];
            
            List<Integer> list = new ArrayList<>();
            list.add(sum - nums2[pos]);
            list.add(nums2[pos]);
            ans.add(list);

            // if k pairs are not found and if there are still elements left in nums2 i.e. pos+1 < nums2.length that can make possible min pair with the curr element of nums1 , we add sum of curr elem of nums1 + elem at nums2[pos+1]
            if(pos + 1 < nums2.length){
                pq.add(new int[]{sum - nums2[pos] + nums2[pos + 1], pos+1 });
            }
            // decrement k
            k--;
        }

        return ans;
    }
}