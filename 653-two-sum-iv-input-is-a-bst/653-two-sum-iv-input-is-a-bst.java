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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> l= new ArrayList<>();
        call(root,l);
        int a=0;
        int b = l.size()-1;
        System.out.println(l);
        while(a<b)
        {
            int sum = l.get(a)+l.get(b);
            if(sum == k)
                return true;
            if(sum>k)
                b--;
            else
                a++;

        }
        return false;
    }
    public void call(TreeNode root, List l)
    {
        if(root == null)
            return;
        call(root.left,l);
        l.add(root.val);
        call(root.right,l);
    }
}