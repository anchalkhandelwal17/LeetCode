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
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        ListNode start = dummy;
        dummy.next = head;
        int itr = 0;
        while(start != null){
            if(itr <= n){
                start = start.next;
            }
            else{
                start = start.next;
                dummy = dummy.next;
            }
            itr++;
        }
        if(dummy != null && dummy.next != null){
            dummy.next = dummy.next.next;
        }
        return temp.next;
    }
}