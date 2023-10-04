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
    public ListNode reverseKGroup(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        if(k == 0 || head == null || k > size){
            return head;
        }
        Stack<ListNode> st = new Stack<>();
        ListNode dummy = new ListNode(0);
        temp = dummy;
        while(size >= k){

            for(int i=0; i<k; i++){
                st.push(head);
                head = head.next;
            }
            while(!st.isEmpty()){
                temp.next = st.pop();
                temp = temp.next;
            }
            size-=k;

        }
        temp.next = head;
        return dummy.next;
    }
}