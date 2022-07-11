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
        List<Integer> list = new ArrayList<>();
      call(root,list,0,new int[01]);
      return list;
    }
  public void call(TreeNode root,List<Integer> list , int curr,int[] depth)
  {
    if(root==null)
      return;
    if(depth[0]<=curr)
    { 
      list.add(root.val);
      depth[0]++;
       call(root.right,list,curr+1,depth);
       call(root.left,list,curr+1,depth);
    }
    else
    {
      call(root.right,list,curr+1,depth);
       call(root.left,list,curr+1,depth);
    }
    return;
  }
}