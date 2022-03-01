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
    int max=-1;
    TreeNode yo = new TreeNode();        
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        call(root,0);
        return yo;
    }
    public int call(TreeNode root,int d)
    {
        if(root==null)
            return d-1;
        if(d>max)
        {
           max=d;
        }
        int p= call(root.left,d+1);
        int q= call(root.right,d+1);
        if(p==max && q==max)
            yo=root;
        return Math.max(p,q);
        
    }
}