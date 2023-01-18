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
    public ListNode removeZeroSumSublists(ListNode head) {
      ListNode head2= new ListNode(100000,head);
      int op=10;
       for(ListNode i=head2;i!=null;i=i.next)
       {
         int curr = 0;
         if(op==9){
           i=head2;op=10;}
         while(i.next!=null && i.next.val==0)
           i.next=i.next.next;
         for(ListNode j=i.next;j!=null;j=j.next)
         {
           curr+=j.val;
           if(curr==0)
           {
             i.next=j.next;
             op=9;
             break;
           }
           
         }
       }
      head2=head2.next;
      while(head2!=null && head2.val==0)
        head2=head2.next;
      return head2;
      
    }
}