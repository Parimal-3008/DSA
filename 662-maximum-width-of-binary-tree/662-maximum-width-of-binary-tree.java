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
        long min;
        long max;
        public Edge()
        {
            this.min=Long.MAX_VALUE;
            this.max=Long.MIN_VALUE;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
       
            
            
        Edge arr[] = new Edge[4000];
        for(int i=0;i<4000;i++)
            arr[i]=new Edge();
        dfs(root,1,0,arr);
        long m= 1;
        for(int i=1;i<4000;i++)
           {
            //System.out.println(arr[i].max+" "+arr[i].min);
            if(arr[i].max!=Long.MIN_VALUE&&arr[i].min!=Long.MAX_VALUE)
            m=Math.max(m,arr[i].max-arr[i].min+1);
        }
       return (int)m;
    }
    public void dfs(TreeNode root, long x,long y,Edge arr[])
    {
        if(root==null)
            return;
        arr[(int)y].min=Math.min(x, arr[(int)y].min);
        arr[(int)y].max=Math.max(x,arr[(int)y].max);
        dfs(root.left,2*x,y+1,arr);
        dfs(root.right,2*x+1,y+1,arr);
        
    }
}