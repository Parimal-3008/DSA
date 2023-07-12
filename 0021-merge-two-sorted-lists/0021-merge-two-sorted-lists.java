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
    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
       ListNode head1 = node1;
       ListNode head2 = node2;
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        ListNode prev = null;
        while(node1!=null && node2!=null)
        {
            if(node1.val<node2.val)
            {
               if(prev != null)
                prev.next = node1;
                prev = node1;
                node1=node1.next;
            }
            else
            {
                if(prev != null)
                prev.next = node2;
                prev = node2;
                node2=node2.next;
            }
        }
        while(node1!=null)
        {
             if(prev != null)
                prev.next = node1;
                prev = node1;
                node1=node1.next;
        }
        while(node2!=null)
        {
             if(prev != null)
                prev.next = node2;
                prev = node2;
                node2=node2.next;
        }
        return head1.val<head2.val?head1:head2;
    }
}