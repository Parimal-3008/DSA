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
    List<TreeNode> l=new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
       HashMap<String,Integer> mp=new HashMap<>();
       String str= dfs(root,mp);
        
        return l;
    }
    public String dfs(TreeNode root, HashMap<String,Integer> mp )
    {
        if(root==null)
        {
            
            return "#";
        }
        
      String y1=  dfs(root.left,mp);
         String y2= dfs(root.right,mp);
        String tr=String.valueOf(root.val)+","+y1+","+y2;
        if(mp.containsKey(tr))
        {
            if(mp.get(tr)==1)
                l.add(root);
           mp.put(tr,mp.get(tr)+1);
        }  
        else
            mp.put(tr,1);
        return tr;
    }
}