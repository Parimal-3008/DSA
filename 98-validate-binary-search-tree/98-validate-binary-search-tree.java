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
    public boolean isValidBST(TreeNode root) {
        return call(root,(long)Integer.MIN_VALUE-1,(long)Integer.MAX_VALUE+1);
    }
    public boolean call(TreeNode root, long min,long max)
    {
        if(root == null)
            return true;
        if(min>=(long)root.val ||  max<=(long)root.val)
            return false;
        boolean l =call(root.left,min,root.val);
        boolean r = call(root.right,root.val,max);
        return l&&r;
        
    }
}