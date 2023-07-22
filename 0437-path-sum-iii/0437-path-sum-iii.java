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
    public int pathSum(TreeNode root, int k) {
        Map<Long,Integer> mp = new HashMap<>();
        mp.put(0l,1);
        return call(root,k,mp,0);
    }
    public int call(TreeNode root, int k, Map<Long,Integer> mp,long curr)
    {
        if(root == null)
            return 0;
        long c = curr+(long)root.val;
        int ans = 0;
        if(c==k)
            ans+=mp.get(0l);
        if(mp.containsKey(c-k))
            ans = mp.get(c-k);
        mp.put(c,mp.getOrDefault(c,0)+1);
        ans+=call(root.left,k,mp,c);
        ans+=call(root.right,k,mp,c);
        if(mp.get(c)==1)
            mp.remove(c);
        else
            mp.put(c,mp.get(c)-1);
        return ans;
    }
}