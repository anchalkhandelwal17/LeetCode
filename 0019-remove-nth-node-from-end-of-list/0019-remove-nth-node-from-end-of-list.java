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
        
        int len = 0;
        ListNode temp = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(temp != null){
            len++;
            temp = temp.next;
        } 
        temp = dummy;
        for(int i=0; i<len-n; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
}