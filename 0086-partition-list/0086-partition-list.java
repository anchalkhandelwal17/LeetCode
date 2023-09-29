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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        Queue<ListNode> queue = new LinkedList<>();
        while(head.next != null){
            if(head.val < x){
                prev.next = head;
                prev = prev.next;
            }
            else{
                queue.offer(head);
            }
            head = head.next;
        }
        if(head.val < x){
            prev.next = head;
            prev = prev.next;
        }
        else{
            queue.offer(head);
        }
        while(!queue.isEmpty()){
            ListNode node = queue.poll();
            prev.next = node;
            prev = prev.next;
        }
        prev.next = null;
        return dummy.next;
    }
}