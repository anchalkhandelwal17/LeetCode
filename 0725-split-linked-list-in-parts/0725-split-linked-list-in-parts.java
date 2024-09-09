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
    public ListNode[] splitListToParts(ListNode head, int k) {
        // TC : O(k + n)
        // SC : O(k)
        ListNode[] list = new ListNode[k];

        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }
        int rem = size % k;
        int val = size / k;
        temp = head;
        ListNode prev = temp;
        for(int i=0; i<k; i++){
            ListNode currTemp = temp;

            int currSize = val;
            if(rem > 0){
                rem--;
                currSize++;
            }

            int cnt = 0;
            while(cnt < currSize){
                cnt++;
                prev = temp;
                temp = temp.next;
            }

            if(prev != null){
                prev.next = null;
            }
            list[i] = currTemp;
        }
        return list;
    }
}