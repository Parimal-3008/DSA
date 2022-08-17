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
    public TreeNode insertIntoBST(TreeNode root, int val) {
      if(root==null)
        return new TreeNode(val);
         call(root,null,val);
        return root;
      
    }
  public void call(TreeNode root,TreeNode prev, int d)
  {
    if(root == null)
    {  if(prev.val>d)
        prev.left = new TreeNode(d);
     if(prev.val<d)
        prev.right = new TreeNode(d);
      return;}
    if(root.val>d)
      call(root.left,root,d);
    if(root.val<d)
      call(root.right,root,d);
    return;
  }
}