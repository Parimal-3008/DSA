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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        int p = call(root);
        max = Math.max(max,p);
        return max-1;
    }
    public int call(TreeNode root)
    {
        if(root == null)
            return 0;
        int a = call(root.left);
        int b = call(root.right);
        
        max = Math.max(max,a+b+1);
        return 1+Math.max(a,b);
    }
}