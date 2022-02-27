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
class FindElements {
    Map<Integer,Integer> mp = new HashMap<>();
    public FindElements(TreeNode root) {
        call(root,0);
    }
    public void call(TreeNode root,int t)
    {
        if(root==null)
            return;
        root.val=t;
        mp.put(t,1);
        call(root.left,2*t+1);
        call(root.right,2*t+2);
        
    }
    
    public boolean find(int target) {
       return mp.containsKey(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */