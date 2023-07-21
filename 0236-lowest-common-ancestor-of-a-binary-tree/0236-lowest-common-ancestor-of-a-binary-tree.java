/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return call(root,p,q);
    }
    public TreeNode call(TreeNode root, TreeNode p, TreeNode q)
    {
        if(root == null)
            return null;
        TreeNode a = call(root.left,p,q);
        TreeNode b = call(root.right,p,q);
        if((a==p && b==q) ||(a==q && b==p))
            return root;
        if((root == p && (a==q || b==q)) || (root == q && (a==p || b==p)))
            return root;
        if(root == p || root == q)
            return root;
        if(a!=null)
            return a;
        if(b!=null)
            return b;
        return null;
    }
}