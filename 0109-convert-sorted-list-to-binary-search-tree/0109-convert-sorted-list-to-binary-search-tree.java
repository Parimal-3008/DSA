/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode tail) {
        List<Integer> list = new LinkedList<>();
        if(tail==null)
            return null;
      while(tail!=null)
            {list.add(tail.val);tail=tail.next;}
        System.out.println(list);
        return call(list,0,list.size()-1);
    }
    public TreeNode call(List<Integer> l, int i, int j )
    {
        if(i>j||i<0)
            return null;
        if(i==j)
            return new TreeNode(l.get(i));
        TreeNode temp= new TreeNode(l.get(i+(j-i+1)/2));
        System.out.println(i+" "+j);
        temp.left = call(l,i,i+((j-i+1)/2)-1);
        temp.right = call(l,i+((j-i+1)/2)+1,j);
        return temp;
    }
   
}