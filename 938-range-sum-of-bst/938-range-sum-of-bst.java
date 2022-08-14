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
    public int rangeSumBST(TreeNode root, int l, int h) {
        return call(root,l,h);
    }
  public int call(TreeNode root,int l, int h)
  {
    if(root == null)
      return 0;
    int l2 =0; int r2 =0;
    if(root.val>=l && root.val<=h)
    { 
      l2 = call(root.left,l,h);
      r2 = call(root.right,l,h);
      return l2+r2+root.val;
     }
    else if(root.val<l)
      return ( + call(root.right,l,h));
    else if(root.val>h)
     return ( call(root.left,l,h));
    return 0;
  }
}