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
    public ListNode partition(ListNode head, int x) {
       ListNode head1= null;
        if(head == null || head.next==null)
            return head;
        ListNode head2= null;
        ListNode curr1= null;ListNode prev1= null;
        ListNode prev2= null;
        
        ListNode curr2= null;
        while(head!=null)
        {
            ListNode next = head.next;
            if(head.val<x)
            {
                if(head1==null)
                {
                    head1= head;
                    prev1 = head1;
                    head1.next = null;
                }
                else
                {
                   prev1.next= head;
                    prev1=head;
                    prev1.next= null;
                }
            }
            else
            {
                if(head2==null)
                {
                    head2= head;
                    prev2 = head2;
                    head2.next = null;
                }
                else
                {
                   prev2.next= head;
                    prev2=head;
                    prev2.next= null;
                }
            }
            head = next;;
        }
        if(prev1!=null)
        prev1.next= head2;
        else
            return head2;
        return head1;
        
    }
}