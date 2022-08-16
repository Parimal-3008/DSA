/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> list = new ArrayList<>();
       call(target,k,list,new HashSet<>());
      Map<TreeNode,TreeNode> mp = new HashMap<>();
      call2(root,mp);
      int i=01;
      while(mp.containsKey(target))
      {
        Set<TreeNode> set = new HashSet<>();
        set.add(target);
        target = mp.get(target);
          call(target,k-i,list,set);
        i++;
      }
      return list;
    }
  public void call2(TreeNode root,Map<TreeNode,TreeNode> mp)
  {
    if(root == null)
      return;
    if(root.right!=null)
      mp.put(root.right,root);
    if(root.left!=null)
      mp.put(root.left,root);
    call2(root.left,mp);
    call2(root.right,mp);
  }
  public void call(TreeNode root, int k, List<Integer> list,Set<TreeNode> set)
  {
    if(root == null||k<0)
      return;
    if(set.contains(root))
      return;
    if(k==0)
    {
      list.add(root.val);
      return;
    }
    call(root.left,k-1,list,set);
    call(root.right,k-1,list,set);
  }
}