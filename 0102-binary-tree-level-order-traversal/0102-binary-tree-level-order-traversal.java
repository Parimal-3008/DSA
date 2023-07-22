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
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q =  new LinkedList<>();
        if(root!=null)
        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            List<Integer> temp= new ArrayList<>();
            for(int i=0;i<size;i++)
              {
                TreeNode y = q.poll();
                if(y.left!=null)
                q.add(y.left);
                if(y.right!=null)
                q.add(y.right);
                temp.add(y.val);
             }
            list.add(temp);
        }
        return list;
    }
}