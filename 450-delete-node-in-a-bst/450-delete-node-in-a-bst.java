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
    public TreeNode deleteNode(TreeNode root, int k) {
      TreeNode target = null;
      TreeNode head = root;
      TreeNode parent = null;
      if(root == null)
        return null;
      if(root.val == k)
      {
       if(root.left==null && root.right == null)
         return null;
        if(head.left== null)
          return head.right;
        if(head.right == null)
          return head.left;
        head = head.right;
        
        while(head.left!=null)
          head = head.left;
        head.left = root.left;
        return root.right;
      }
      while(root!=null)
      {
        
        if(root.val >k)
        { parent = root; root = root.left;}
        else if(root.val<k)
        { parent = root;  root = root.right;}
        else
        {
          target = root;break;
        }
      }
      if(target == null)
        return head;
      if(target.left == null && target.right ==null)
      {
        if(parent.right == target)
          parent.right = null;
        if(parent.left == target)
          parent.left = null;
        return head;
      }
     // System.out.println(parent.val+" "+target.val);
      if(parent.right == target)
      {
        if(target.right!=null)
        parent.right =  target.right;    
        else
          parent.right = target.left;
      }
      else
      {
        if(target.right!=null)
        parent.left = target.right;
        else
          parent.left = target.left;
          
       // TreeNode temp = target.right;
       //  while(temp.left!=null)
       //   temp = temp.left;
       //  temp.left= target.left;
       //  return root;
      }
      TreeNode temp = target.right;
      if(temp==null)
      {
      
        return head;
      }
        while(temp.left!=null)
         temp = temp.left;
        temp.left= target.left;
        return head;
        
    }
 

}