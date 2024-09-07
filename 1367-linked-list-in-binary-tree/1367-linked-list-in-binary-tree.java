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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        // TC : O(n^2)
        // SC : total space taken by recursion , apart from that nothing 
        if(root == null) return false;
        if(solve(head, root)) return true;
        boolean left = isSubPath(head, root.left);
        boolean right = isSubPath(head, root.right);
        return (left || right);
    }

    public boolean solve(ListNode head, TreeNode root){
        if(head == null) return true;

        if(root == null) return false;

        if(root.val != head.val) return false; 
        boolean left = solve(head.next, root.left);
        boolean right = solve(head.next, root.right);

        return (left || right);
    }
}

// can apply dfs