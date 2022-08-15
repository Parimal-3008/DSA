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
      if(p.val>q.val)
      {
        TreeNode temp = p;
        p=q;
        q = temp;
      }
        return call(root,p,q);
    }
  public TreeNode call(TreeNode root,TreeNode p, TreeNode q)
  {
    if(root == null)
      return null;
    TreeNode l = null;
    TreeNode r = null;
    if(root.val==p.val || root.val == q.val)
         return root;   
    if(root.val>=p.val && root.val<=q.val)
      return root;        
    if(root.val>q.val)
        return call(root.left,p,q);
    if(root.val<p.val)
       return call(root.right,p,q);
     return null;
    
  }
  
}