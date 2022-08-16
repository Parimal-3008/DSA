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
    public TreeNode buildTree(int[] pre, int[] in) {
      Map<Integer,Integer> mp = new HashMap<>();
      for(int i=0;i<in.length;i++)
      {
        mp.put(in[i],i);
      }
        return call(pre,0,pre.length-1,in,0,in.length-1,mp);
    }
  public TreeNode call(int[] pre,int ps,int pe,int[] in, int is, int ie,Map<Integer,Integer> mp)
  {
    
    if(ps>=pre.length || is>=in.length || ps>pe || is>ie)
      return null;
    
    TreeNode root = new TreeNode(pre[ps]);
    int n = mp.get(pre[ps])-is; // no of elemnts in left subtree
      root.left = call(pre,ps+1,ps+n,in,is,mp.get(pre[ps])-1,mp);
     root.right = call(pre,ps+n+1,pe,in,mp.get(pre[ps])+1,ie,mp);
    return root;
  }
}