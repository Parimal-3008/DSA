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
    public int sumEvenGrandparent(TreeNode root) {
       return call(root);
        
    }
    public int call(TreeNode root)
    {
        if(root== null)
            return 0;
        int p=0;int q=0;int y=0;
        if(root.val%2==0)
        {
            y= check(root);
        }      
             p= call(root.left);
            q = call(root.right);
        
        return p+q+y;
    }
    public int check(TreeNode root)
    {
        TreeNode a1=root.left;
        TreeNode a2= root.right;
        int sum=0;
        if(a1!=null)
        {
           if(a1.left!=null)
               sum+=a1.left.val;
           if(a1.right!=null)
               sum+=a1.right.val;
        }
        if(a2!=null)
        {
           if(a2.left!=null)
               sum+=a2.left.val;
           if(a2.right!=null)
               sum+=a2.right.val;
        }
        return sum;
        
    }
}