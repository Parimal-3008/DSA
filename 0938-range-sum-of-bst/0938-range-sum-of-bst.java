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
    public int rangeSumBST(TreeNode root, int low, int high) {
        return call(root,low,high);
    }
    public int call(TreeNode root, int l, int h)
    {
        if(root == null)
            return 0;
        int sum = 0;
        if(root.val>=l && root.val<=h)
          {
            sum+=root.val;
            sum+=call(root.right,l,h);
            sum+=call(root.left,l,h);
          }
        else if(root.val<=l)
            sum+=call(root.right,l,h);
        
        else if(root.val>=h)
            sum+=call(root.left,l,h);
        return sum;
        
    }
}