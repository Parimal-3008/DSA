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
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> l = new ArrayList<>();
     
      int y = call(root,l,0,01);
     //  System.out.println(l);
      return y;
      
    }
  public int call(TreeNode root,List<Integer> li , int d,int p)
  {
    if(root == null)
      return 0;
    
   // System.out.println(d+".."+p);
    if(p>li.size())
      li.add(d-(int)Math.pow(2,p));
    int l=call(root.left,li,(d-(int)Math.pow(2,p))*2,p+1);
    int r= call(root.right,li,((d-(int)Math.pow(2,p))*2)+1,p+1);
   
    return Math.max(l,Math.max(r,d-(int)Math.pow(2,p)-li.get(p-1)+1));  
  }
}