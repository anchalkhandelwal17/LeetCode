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
    ListNode start;
    public boolean isPalindrome(ListNode head) {
        start = head;
        ListNode middle = findMiddle(head);
        boolean ans = helper(middle);
        return ans;
    }
    
    public boolean helper(ListNode end){
        if(end == null) return true;
        
        boolean flag = helper(end.next);
        
        if(flag){
            if(start.val == end.val){
                start = start.next;
                return true;
            }
        }
        return false;
    }
    
    public ListNode findMiddle(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}