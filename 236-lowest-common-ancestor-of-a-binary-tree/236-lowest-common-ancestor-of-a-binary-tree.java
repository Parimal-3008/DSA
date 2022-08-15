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
  public TreeNode call(TreeNode root,TreeNode p,TreeNode q)
  {
    if(root == null)
      return null;
    TreeNode l = call(root.left,p,q);
    TreeNode r = call(root.right,p,q);
    if(l== null && r == null)
    {
      if(root.val == p.val || root.val == q.val)
        return root;
      return null;
    }
    if(l!=null)
    {
      if(r!=null)
        return root;
      if(root.val==p.val || root.val == q.val)
        return root;
      return l;
    }
    if(r!=null)
    {
      if(l!=null)
        return root;
      if(root.val==p.val || root.val == q.val)
        return root;
      return r;
    }
   
    return null;
    
  }
}