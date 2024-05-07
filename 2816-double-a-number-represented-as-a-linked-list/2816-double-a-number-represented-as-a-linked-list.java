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
    public ListNode doubleIt(ListNode head) {
        // TC : O(n)
        // SC : O(1)

        ListNode originalHead = head;
        ListNode newHead = reverse(head);
        ListNode tail = newHead;

        int carry = 0;
        int val = 0;
        while(newHead != null || carry != 0){
            if(newHead != null){
                 val = newHead.val * 2 + carry;
            }
            else{
                val = carry;
            }
            if(newHead == null){
                ListNode node = new ListNode(val % 10);
                originalHead.next = node;
                originalHead = originalHead.next;
            }
            else{
                newHead.val = val % 10;
                newHead = newHead.next;
            }
            carry = val / 10;
        }
        return reverse(tail);
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = curr.next;

        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null){
                next = next.next;
            }
        }
        return prev;
    }
}
//val * 2 + carry