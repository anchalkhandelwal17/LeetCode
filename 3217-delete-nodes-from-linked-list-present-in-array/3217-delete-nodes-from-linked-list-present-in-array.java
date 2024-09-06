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
    public ListNode modifiedList(int[] nums, ListNode head) {
        // TC : O(n)
        // SC : O(n)
        if(head == null) return head;
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        temp.next = head;

        while(head != null){
            if(set.contains(head.val)){
                temp.next = head.next;
                // System.out.println(temp.val);
            }
            else{
                // System.out.println(temp.val);
                temp = temp.next;
            }
            head = head.next;
        }
        return dummy.next;
    }
}
// input is not sorted
