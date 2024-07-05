/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // TC : O(n)
        // SC : O(n/2)
        int[] ans = {-1, -1};
        if(head == null) return ans;
        ListNode temp = head.next;
        ListNode prev = head;
        List<Integer> list = new ArrayList<>();
        int nodeIdx = 1;
        while(temp != null && temp.next != null){
            if((temp.val < prev.val && temp.val < temp.next.val) 
             || (temp.val > prev.val && temp.val > temp.next.val)){
                list.add(nodeIdx);
             }
             nodeIdx++;
             prev = temp;
             temp = temp.next;
        }
        if(list.size() < 2) return ans;
        ans[0] = Integer.MAX_VALUE;
        for(int i=0; i<list.size()-1; i++){
            ans[0] = Math.min(ans[0], list.get(i+1) - list.get(i));
        }
        ans[1] = list.get(list.size()-1) - list.get(0);
        return ans;
    }
}