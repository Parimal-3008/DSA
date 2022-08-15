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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> set = new TreeMap<>();
        call(0,0,root,set);
      List<List<Integer>> l = new ArrayList<>();
      //System.out.println(set);
      for (Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> entry: set.entrySet()) 
      {
        TreeMap<Integer,PriorityQueue<Integer>> i1 = entry.getValue();
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer,PriorityQueue<Integer>> entry2 : i1.entrySet()) 
        {
          PriorityQueue<Integer> pq = entry2.getValue();
            while(!pq.isEmpty())
            list.add(pq.poll());
        }
        l.add(list);
      }
       return l;
      
    }
  public void call(int x, int y, TreeNode root,TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> mp)
  {
    if(root == null)
      return;
    call(x-1,y+1,root.left,mp);
    call(x+1,y+1,root.right,mp);
    if(mp.containsKey(x))
    {
        TreeMap<Integer,PriorityQueue<Integer>> mp1 = mp.get(x);
        if(mp1.containsKey(y))
        {
          PriorityQueue<Integer> pq = mp1.get(y);
          pq.add(root.val);
          mp1.put(y,pq);
        }
      else
      {
        PriorityQueue<Integer> set = new PriorityQueue<>();
        set.add(root.val);
        mp1.put(y,set);
      }
    }
    else
    {
         TreeMap<Integer,PriorityQueue<Integer>> mp1 = new TreeMap<>();
         PriorityQueue<Integer> set = new PriorityQueue<>();
         set.add(root.val);
         mp1.put(y,set);
      mp.put(x,mp1);
    }
    
  }
}