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
        
        if(head == null || k == 0 || head.next == null) return head;

        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        k = k % size;
        if(k == 0) return head;
        ListNode newTail = head;
        for(int i=0; i<size-k-1; i++){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        temp = newHead;
        while(temp != null && temp.next != null) {
            temp = temp.next;
        }
        if(temp != null) temp.next = head;
        return newHead;
    }
}