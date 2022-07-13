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
    public List<List<Integer>> levelOrder(TreeNode root) {
          Queue<TreeNode> q1=new LinkedList<>();
         Queue<TreeNode> q2=new LinkedList<>();
         List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(root==null)
        {
            return list;
        }
        if(root.left==null&&root.right==null)
        {
             ArrayList<Integer> l=new ArrayList<>();
            l.add(root.val);
            list.add(l);
            return list;
        }
       
        q1.add(root);int a=1;int max=Integer.MIN_VALUE;int lvl=1;
       
        while(!q1.isEmpty()||!q2.isEmpty())
        {
           
           
            int curr=0;
            if(a%2==01)
            {
                ArrayList<Integer> l=new ArrayList<>();
                while(!q1.isEmpty())
                {
                  TreeNode y=q1.poll();
                    if(y!=null)
                    l.add(y.val);
                    
                   if(y.left!=null) q2.add(y.left);
                   if(y.right!=null) q2.add(y.right);
                    
                }
                list.add(l);
                a++;
            }
            else
            {
                ArrayList<Integer> l=new ArrayList<>();
                while(!q2.isEmpty())
                {
                 TreeNode  y=q2.poll();
                    
                   
                    if(y!=null) l.add(y.val);
                   if(y.left!=null) q1.add(y.left);
                  if(y.right!=null)    q1.add(y.right);
                    
                }
                list.add(l);
                a++;
            }
            
        }
        return list;
    }
}