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
        int min=0;int max=0;
        if(p.val<q.val)
        {
            max=q.val;
            min = p.val;
        }
        else
        {
            min=q.val;
            max = p.val;
        }
        return call(root, min,max);
    }
    public TreeNode call(TreeNode root, int min, int max)
    {
        if(root == null)
            return null;
        if(root.val>=min&& root.val<=max)
            return root;
        if(root.val<max)
            return call(root.right,min,max);
        else
            return call(root.left,min,max);
            
    }
}