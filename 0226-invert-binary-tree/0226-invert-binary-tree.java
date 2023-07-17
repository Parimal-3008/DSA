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
    public TreeNode invertTree(TreeNode root) {
        TreeNode head = root;
        call(root);
        return head;
    }
    public void call(TreeNode root)
    {
        if(root== null)
            return;
        call(root.left);
        call(root.right);
        TreeNode left = root.left;
         TreeNode right =root.right;
        root.left= right;
        root.right = left;
        
    }
}