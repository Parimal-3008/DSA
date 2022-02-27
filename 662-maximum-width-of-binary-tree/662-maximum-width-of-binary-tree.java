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
   
    class Edge
    {
        int min;
        int max;
        public Edge()
        {
            this.min=Integer.MAX_VALUE;
            this.max=Integer.MIN_VALUE;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
       Edge arr[] = new Edge[4000];
         int ind[]= new int[4000];
        Arrays.fill(ind,Integer.MAX_VALUE);
        for(int i=0;i<4000;i++)
            arr[i]=new Edge();
        dfs(root,1,0,arr,ind);
        int m= 1;
        for(int i=1;i<4000;i++)
           {
            if(arr[i].max!=Integer.MIN_VALUE&&arr[i].min!=Integer.MAX_VALUE)
            m=Math.max(m,arr[i].max-arr[i].min+1);
          }
       return m;
    }
    public void dfs(TreeNode root, int x,int y,Edge arr[],int[] ind)
    {
        if(root==null)
            return;
        if(ind[y]==Integer.MAX_VALUE)
            ind[y]=x;
        arr[y].min=Math.min(x-ind[y], arr[y].min);
        arr[y].max=Math.max(x-ind[y],arr[y].max);
        dfs(root.left,2*x,y+1,arr,ind);
        dfs(root.right,2*x+1,y+1,arr,ind);
        
    }
}