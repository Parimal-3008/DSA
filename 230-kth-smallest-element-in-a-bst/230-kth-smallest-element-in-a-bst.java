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
    public int kthSmallest(TreeNode root, int k) {
        int count =0;
        if(root == null)
            return -1;
        TreeNode curr =root;
        while(curr!=null)
        {
            if(curr.left == null)
            {
                count++;
                if(count == k)
                    return curr.val;
                curr = curr.right;
            }
            else
            {
                TreeNode p = curr.left;
                while(p.right != null && p.right!=curr)
                   p = p.right;
                if(p.right == null)
                {
                     p.right =curr;
                    curr= curr.left;
                }
                else
                {
                    p.right= null;
                    count++;
                    if(count == k)
                         return curr.val;
                    curr= curr.right;
                }
            }
        }
        return -1;
    }
}