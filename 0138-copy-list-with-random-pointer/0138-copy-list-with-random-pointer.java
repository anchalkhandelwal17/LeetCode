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
        // using extra space
        
        HashMap<Node, Node> map = new HashMap<>();
        Node dummy = head;
        while(dummy != null){
            map.put(dummy, new Node(dummy.val));
            dummy = dummy.next;
        }

        dummy = head;
        while(dummy != null){
            map.get(dummy).next = map.get(dummy.next);
            map.get(dummy).random = map.get(dummy.random);
            dummy = dummy.next;
        }
        return map.get(head);
    }
}