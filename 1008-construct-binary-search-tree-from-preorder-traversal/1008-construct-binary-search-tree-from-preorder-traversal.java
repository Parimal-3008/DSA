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
    int i=0;
    public TreeNode bstFromPreorder(int[] arr) {
        return call(arr,Integer.MAX_VALUE);
    }
    public TreeNode call(int[] arr, int u)
    {
       if(i==arr.length||arr[i]>u)
           return null;
        TreeNode root = new TreeNode(arr[i]);i++;
        root.left = call(arr,root.val);
        root.right = call(arr,u);
        return root;
    }
}