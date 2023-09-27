/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        // step 1 : creating the copy nodes
        Node itr = head;
        Node front = head;

        while(itr != null){
            front = itr.next;
            Node copy = new Node(itr.val);
            itr.next = copy;
            copy.next = front;
            if(itr.next != null){
                itr = itr.next.next;
            } 
        }

        // step 2 : connecting the random pointers
        itr = head;

        while(itr != null){
            if(itr.random != null){
                itr.next.random = itr.random.next;
            }
            if(itr.next != null){
                itr = itr.next.next;
            }
        }

        // step 3 : separating the copied list and original list

        Node copyHead = new Node(0);
        Node dummy = copyHead;
        itr = head;
        front = head;

        while(itr != null){
            if(itr.next != null){
                front = itr.next.next;
            }
            dummy.next = itr.next;
            itr.next = front;
            itr = front;
            dummy = dummy.next;
        }
        return copyHead.next;
    }
}