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
    public int rob(TreeNode root) {
        Map<TreeNode,Integer[]> mp = new HashMap<>();
      dfs(mp,root);
     
        return call(root,mp,0);
    }
  public int call(TreeNode root,Map<TreeNode,Integer[]> mp, int st)
  {
    if(root == null)
      return 0;
    Integer[] p = mp.get(root);
    if(p[st]!=-1)
      return p[st];
    if(st == 1)
    {
      int a = call(root.left,mp,0);
      int b = call(root.right,mp,0);
       p[st]= a+b;
      mp.put(root,p);
      return p[st];
    }
    else
    {
      int a = call(root.left,mp,1);
      int b = call(root.right,mp,1);
      int c = call(root.left,mp,0);
      int d = call(root.right,mp,0);
      p[st] = Math.max(root.val+a+b,c+d);
      mp.put(root,p);
      return p[st];
    }
  }
  
  public void dfs( Map<TreeNode,Integer[]> mp ,TreeNode root)
  {
    if(root == null)
      return ;
    Integer arr[]={-1,-1};
    mp.put(root,arr);
    dfs(mp,root.left);
    dfs(mp,root.right);    
  }
}