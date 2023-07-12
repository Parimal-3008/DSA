/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode node1, ListNode node2) {
        int len1 = 0;int len2 = 0;
        ListNode head1 = node1;
        ListNode head2 = node2;
        
        while(node1!=null)
        {
            node1=node1.next;
            len1++;
        }
          while(node2!=null)
        {
            node2=node2.next;
            len2++;
        }
        while(len1>len2)
        {
            len1--;
            head1=head1.next;
        }
         while(len1<len2)
        {
            len2--;
            head2=head2.next;
        }
        while(head1!=head2)
        {
            head1=head1.next;
            head2=head2.next;
            
            
        }
        return head1;
        
    }
}