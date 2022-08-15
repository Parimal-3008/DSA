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
  class Node
  {
    TreeNode node;int d;
    public Node(TreeNode node, int d)
    {
      this.node= node;
      this.d = d;      
    }
  }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int arr[]={-1};
      return call(root,arr,0).node;
      }
  public Node call(TreeNode root,int[] arr,int d)
  {
    if(root==null)
      return null;
    arr[0]=Math.max(arr[0],d);
    Node l = call(root.left,arr,d+1);
    Node r = call(root.right,arr,d+1);
    if(l== null && r== null)
    {
      if(d==arr[0])
        return new Node(root,d);
      return null;
    }
    if(l!=null)
    {
      if(r!=null && l.d == arr[0] && r.d==arr[0])
        return new Node(root,l.d);
      if(l.d==arr[0])
        return l;
      if(r.d==arr[0])
        return r;
      return null;        
    }
    if(r!=null)
    {
      if(l!=null && l.d == arr[0] && r.d==arr[0])
        return new Node(root,l.d);
      if(r.d==arr[0])
        return r;
      if(l.d ==  arr[0])
        return l;
      return null;
    }
    return null;
  }
}