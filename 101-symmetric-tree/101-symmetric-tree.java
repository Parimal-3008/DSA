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
    public boolean isSymmetric(TreeNode root) {
        return call(root.left,root.right);
    }
  public boolean call(TreeNode left,TreeNode right)
  {
    if(left==null && right == null)
      return true;
    else if(left!=null && right == null)
      return false;
    else if(left==null && right != null)
      return false;
    if(left.val!=right.val)
      return false;
    return call(left.left,right.right) && call(left.right,right.left);
  }
}