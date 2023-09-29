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

     // The idea is to separate the list into two lists i.e list 1 with values < x and list 2 with values >= x and merge them afterwards.

        ListNode smallerValuesHead = new ListNode(0);
        ListNode biggerValuesHead = new ListNode(0);

        ListNode smallerValuesList = smallerValuesHead;
        ListNode biggerValuesList = biggerValuesHead;

        while(head != null){
            if(head.val < x){
                // connecting all the nodes together with values < x
                smallerValuesList.next = head;
                smallerValuesList = smallerValuesList.next;
            }
            else{
                // connecting all the nodes together with values >= x
                biggerValuesList.next = head;
                biggerValuesList = biggerValuesList.next;
            }
            head = head.next;
        }
        // merging the smaller values list and bigger values list
        smallerValuesList.next = biggerValuesHead.next;

        biggerValuesList.next = null;

        return smallerValuesHead.next;
    }
}