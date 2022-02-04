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
    public TreeNode bstFromPreorder(int[] arr) {
        return call(arr,0,arr.length-1);
    }
    public TreeNode call(int[] arr, int s1,int e1)
    {
        if(s1>e1||s1<0||e1>=arr.length)
            return null;
        TreeNode root= new TreeNode(arr[s1]);
        int ind = e1;
        for(int i=s1+1;i<=e1;i++)
        {
            if(arr[s1]<arr[i]){
                ind = i-1;break;}
        }
        TreeNode l = call(arr,s1+1,ind);
        TreeNode r = call(arr,ind+1,e1);
        root.left = l;
        root.right =r;
        return root;
    }
}