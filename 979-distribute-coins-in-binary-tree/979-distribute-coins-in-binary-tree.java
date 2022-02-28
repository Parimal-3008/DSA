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
    int res=0;
    public int distributeCoins(TreeNode root) {
        int p= call(root);
        return res;
    }
    public int call(TreeNode root)
    {
        if(root==null)
            return 0;
        int a= call(root.left);
        int b= call(root.right);
        res+=Math.abs(a)+Math.abs(b);
        return a+b+root.val-1;
    }
}