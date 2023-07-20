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
    public boolean hasPathSum(TreeNode root, int k) {
        if(root == null)
            return false;
        if(root.left== null && root.right == null)
            return root.val==k;
        // if(root.right == null)
        //     return call(root.left,k-root.val);
        // if(root.left == null)
        //      return call(root.right,k-root.val);
        return call(root,k);
    }
    public boolean call(TreeNode root, int k)
    {
        if(root.left == null && root.right == null)
            return k==root.val;
        if(root.left == null)
            return call(root.right,k-root.val);
        if(root.right == null)
            return call(root.left,k-root.val);
        // System.out.println(root.val+" "+k);
        return call(root.left,k-root.val) || call(root.right,k-root.val);
    }
}