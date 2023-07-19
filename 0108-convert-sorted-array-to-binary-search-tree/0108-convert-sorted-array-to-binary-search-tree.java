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
    public TreeNode sortedArrayToBST(int[] arr) {
        return call(arr,0,arr.length-1);
    }
    public TreeNode call(int[] arr, int i, int n)
    {
        if(i>n)
            return null;
        int mid = (i+n)/2;
        TreeNode left= call(arr,i,mid-1);
        TreeNode right= call(arr,mid+1,n);
        return new TreeNode(arr[mid],left,right);
    }
}