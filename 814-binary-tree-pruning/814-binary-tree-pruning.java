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
    public TreeNode pruneTree(TreeNode root) {
        boolean p= call(root);
        if(p ==false)
            return null;
          return root;
    }
    public boolean call(TreeNode root)
    {
        if(root == null)
            return false;
        boolean a=  call(root.left);
        boolean b = call(root.right);
        boolean c = (root.val==1);
        if(a==false)
           root.left=null;
         if(b==false)
            root.right=null;
       
         return a||b||c;
    }
}