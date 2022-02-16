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
class Solution {
    public ListNode swapPairs(ListNode root) {
        if(root == null)
            return root;
        ListNode temp = root;
         if(root.next!=null)
        {
             temp = root.next;
            root.next = root.next.next;
            temp.next = root;
            
        }
       //System.out.println(root.next.val);
        call(root.next,root);
        return temp;
    }
    public void call(ListNode root,ListNode parent)
    {
        if(root==null)
            return;
        if(root.next!=null)
        {
            ListNode temp = root.next;
            root.next = root.next.next;
            temp.next = root;
            parent.next = temp;
            
        }
        call(root.next,root);
    }
}