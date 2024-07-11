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
    public ListNode rotateRight(ListNode head, int k) {
        // TC : O(n + n)
        // SC : O(1)
        if(head == null || k == 0) return head;
        ListNode temp = head;
        int n = 0;
        while(temp != null){
            temp = temp.next;
            n++;
        }
        k %= n;
        if(n == 1 || n == k || k == 0) return head;
        ListNode tail = head;
        ListNode mid = head;
        ListNode newHead = head;
        int i = 0;
        while(i < k && tail != null){
            tail = tail.next;
            i++;
        }
        while(tail.next != null){
            mid = mid.next;
            tail = tail.next;
        }
        newHead = mid.next;
        mid.next = null;
        tail.next = head;
        if(newHead != null) return newHead;
        return head;

    }
}