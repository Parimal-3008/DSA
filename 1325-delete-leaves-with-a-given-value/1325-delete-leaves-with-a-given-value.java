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
    public TreeNode removeLeafNodes(TreeNode root, int k) {
        TreeNode p=  call(root,k);
        if(p!=null&&p.left==null&&p.right==null&&p.val==k)
            return null;
       
        return root;
    }
    public TreeNode call(TreeNode root, int k)
    {
        if(root==null)
            return null;
        TreeNode p = call(root.left,k);
        TreeNode q = call(root.right,k);
         if(p!=null&&p.left==null&&p.right==null&&p.val==k)
            root.left=null;
        if(q!=null&&q.left==null&&q.right==null&&q.val==k)
            root.right=null;
        return root;
    }
}