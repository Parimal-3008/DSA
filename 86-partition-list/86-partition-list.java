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
     
        ListNode head2=head;
        ListNode head3=null;
      List<ListNode> l= new ArrayList<>();
      List<ListNode> h= new ArrayList<>();
      
      while(head2!=null)
      {
        if(head2.val<x)
        {
         l.add(head2);
        }
        else
          h.add(head2);
        head2=head2.next;
      }
      if(!l.isEmpty())
      {}
      else
        return head;
      for(ListNode t:l)
      {
        if(head3==null)
         { head3=t;head2=head3;}
        else
        {
          head3.next=t;head3=head3.next;}
      }
     for(ListNode t:h)
     {
       head3.next=t;
       head3=head3.next;
     }
      head3.next=null;
      return head2;
    }
}