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
    public ListNode removeNodes(ListNode head) {
      
        ListNode newHead = reverse(head);
        ListNode temp = newHead;
        
        while(temp != null && temp.next != null){
            if(temp.val > temp.next.val){
                temp.next = temp.next.next;
            }
            else temp = temp.next;
        }
        
        return reverse(newHead);
    }
    
    public ListNode reverse(ListNode node){
        ListNode prev = null;
        ListNode curr = node;
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