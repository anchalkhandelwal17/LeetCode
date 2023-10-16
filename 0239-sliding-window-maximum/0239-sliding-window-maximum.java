class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

       int n = nums.length;
       if(n == 0){
           return nums;
       } 
       int[] ans = new int[n - k + 1];
       Deque<Integer> dq = new LinkedList<>();
       int idx = 0;

       for(int i=0; i<n; i++){
           
           int currEle = nums[i];
           while(!dq.isEmpty() && nums[dq.peekLast()] < currEle){
               dq.removeLast();
           }
           if(!dq.isEmpty() && dq.peek() < i-k+1){
               dq.remove();
           }
           dq.add(i);

           if(i >= k-1){
               ans[idx++] = nums[dq.peek()];
           }
       }
       return ans;
    }
}