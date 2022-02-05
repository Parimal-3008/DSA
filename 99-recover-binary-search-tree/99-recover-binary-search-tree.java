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
    TreeNode start;
    TreeNode mid;
    TreeNode end;
    TreeNode prev = new TreeNode (Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        call(root);
        if(end == null)
        {
            int temp = start.val;
            start.val = mid.val;
            mid.val =temp;
        }
        else
        {
            int temp = end.val;
            end.val = start.val;
            start.val =temp;
        }
        
    }
    public void call(TreeNode root)
    {
        if(root == null)
            return;
        call(root.left);
       if(root.val<prev.val)
       {
           if(start==null)
           {
               start = prev;
               mid=root;
           }
           else
           {
               end =root;
           }
       }
        prev= root;
        call(root.right);
    
        
    }
}