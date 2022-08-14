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
    public int maxPathSum(TreeNode root) {
        int arr[]={Integer.MIN_VALUE};
      int p = call(root,arr);
      arr[0]=Math.max(arr[0],p);
      return arr[0];
    }
  public int call(TreeNode root, int[] arr)
  {
      if(root == null)
        return 0;
    int l =  call(root.left,arr);
    int r =  call(root.right,arr);
    int y1= root.val +l;
     int y2=root.val +r;    
    int y3 =root.val + l +r ; 
     int y4 =root.val ;
    arr[0]=Math.max(arr[0], Math.max(y1,Math.max(y2,Math.max(y3,y4))));
    return Math.max(y1,Math.max(y2,y4));
  }
}
/*
if(root == null)
            return 0;
        int  l = call(root.left,arr);
        int r =call(root.right,arr);
        int y1= root.val+l;
        int y2=root.val + r;
        int y3 = root.val+l+r;
        int y4 = root.val;
        System.out.println(y1+" "+y2+" "+y3+" "+y4+" "+arr[0]);
        arr[0]= Math.max(arr[0],Math.max(y1,Math.max(y2,Math.max(y3,y4))));
        return Math.max(y1,Math.max(y2,y4));
*/