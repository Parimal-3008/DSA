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
    public int deepestLeavesSum(TreeNode root) {
        int arr[]= {0-1,0};
      call(root,0,arr);
      return arr[1];
    }
  public void call(TreeNode root,int d, int[] arr)
  {
    if(root == null)
      return ;
     if(d>arr[0])
     { arr[1]=root.val;arr[0]=d;}
    else if(d == arr[0])
      arr[1]+=root.val;
    call(root.left,d+1,arr);
    call(root.right,d+1,arr);
   
  }
}