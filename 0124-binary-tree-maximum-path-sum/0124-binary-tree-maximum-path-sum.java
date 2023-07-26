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
    int max = -100000;
    public int maxPathSum(TreeNode root) {
        // max = root.val;
        int a = call(root);
        return max;
    }
    public int call(TreeNode root)
    {
        if(root == null)
            return 0;
        int a = call(root.left);
        int b = call(root.right);
        max = Math.max(max,Math.max(a+root.val,Math.max(a+b+root.val,b+root.val)));
        max = Math.max(max,root.val);
        return Math.max(root.val,Math.max(a+root.val,b+root.val));
    }
}