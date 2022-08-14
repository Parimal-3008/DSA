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
    int sum;int n;
    public Node(int sum, int n)
    {
      this.sum = sum; this.n=n;
    }
  }
    public int averageOfSubtree(TreeNode root) {
        int[] arr= {0};
      Node p = call(root,arr);
      return arr[0];
    }
  public Node call(TreeNode root, int[] arr)
  {
    if(root == null)
      return new Node(0,0);
    Node l = call(root.left,arr);
    Node r = call(root.right,arr);
    if(((l.sum+r.sum+ root.val )/(l.n+r.n+1))==root.val)
      arr[0]++;
    return new Node(l.sum+r.sum+ root.val,l.n+r.n+1);
    
    
  }
}