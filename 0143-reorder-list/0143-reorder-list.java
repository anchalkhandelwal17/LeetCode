/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        // TC : O(n)
        // SC : O(1)
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;
        ListNode next = curr.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        ListNode curr1 = head;
        ListNode curr2 = prev;

        while (curr2 != null && curr2.next != null) {
            ListNode temp1 = curr1.next;
            ListNode temp2 = curr2.next;
            curr1.next = curr2;
            curr2.next = temp1;
            curr1 = temp1;
            curr2 = temp2;
        }
    }
}
