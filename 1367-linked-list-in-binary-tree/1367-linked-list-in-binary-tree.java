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
        return call(head,root);
    }
    public boolean call(ListNode head,TreeNode root)
    {
        if(root == null)
            return false;
        if(matches(head,root))return true;
        return call(head,root.left)|| call(head,root.right);
     }
    public boolean matches(ListNode head, TreeNode root)
    {
        if(head==null)
            return true;
        if(root==null||root.val != head.val)
            return false;
         
            return matches(head.next,root.left)||matches(head.next,root.right);
        
    }
}