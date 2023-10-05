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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || k == 1){
            return head;
        }
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy, curr = dummy, next = dummy;

        while(len >= k){
            curr = prev.next;
            next = curr.next;
            for(int i=1; i<k; i++){
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            len -= k;
        }
        return dummy.next;
    }
}