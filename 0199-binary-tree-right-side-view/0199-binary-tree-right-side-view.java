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
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer,Integer> mp = new HashMap<>();
       List<Integer> ans = new ArrayList<>();
        call(root,mp,ans,0);
        return ans;
    }
    public void call(TreeNode root, Map<Integer,Integer> mp, List<Integer> ans, int i)
    {
        if(root == null)
            return;
        if(!mp.containsKey(i))
        {
            mp.put(i,root.val);
            ans.add(root.val);
        }
            call(root.right,mp,ans,i+1);
            call(root.left,mp,ans,i+1);
        
    }
}