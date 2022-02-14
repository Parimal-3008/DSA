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
    public int maxDepth(TreeNode root) {
       
        return call(root);
    }
    public int call(TreeNode root)
    {
        if(root == null)
            return 0;
        int l = 1+call(root.left);
        int r= 1+call(root.right);
        return Math.max(l,r);
    }
}