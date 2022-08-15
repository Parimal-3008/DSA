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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> l = new ArrayList<>();
     // l.add(root.val);
        call(root,01,l);
      return l;
    }
  public void call(TreeNode root,int d, List<Integer> l)
  {
    if(root == null)
      return ;
    if(l.size()<d)
      l.add(root.val);
    call(root.right,d+1,l);
    call(root.left,d+1,l);
  }
}