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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // TC : O(n)
        // SC : O(1)
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        temp = dummy;

        for(int i=0; i<len-n; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;

    }
}