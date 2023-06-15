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
    public long kthLargestLevelSum(TreeNode root, int k) {
       PriorityQueue<Long> pq = new PriorityQueue<>( Collections.reverseOrder());
        Map<Integer,Long> mp = new HashMap<>();
        call(root,mp,0);
        for(Map.Entry<Integer,Long> entry:mp.entrySet())
        {
            pq.add(entry.getValue());
        }
        long ans = 0;
        while(!pq.isEmpty() && k>0)
        {
            ans = pq.poll();
            k--;
        }
        if(k>0)
            return -1;
        return ans;
    }
    public void call(TreeNode root, Map<Integer,Long> mp, int curr)
    {
        if(root == null)
            return;
        if(mp.containsKey(curr))
            mp.put(curr,(long)mp.get(curr)+root.val);
        else
            mp.put(curr,(long)root.val);
        call(root.left,mp,curr+1);
        call(root.right,mp,curr+1);
    }
}