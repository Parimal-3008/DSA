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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1)
            return head;
        ListNode curr  = head;
        ListNode head2 = null;
        ListNode prevhead = head;
        ListNode prevtail = null;
       int len = 1;
        while(curr!=null)
        {
            ListNode next = curr.next;
            if(len%k==0)
            {
                curr.next = null;   
                ListNode temp = prevhead;
                if(head2==null)
                    head2=reverse(prevhead);
                else
                    prevtail.next = reverse(prevhead);
                    prevtail= temp;
            }
            else if(len%k==1)
            {
                prevhead = curr;
            }
            len++;
            curr = next;
            
        }
        if((len-1 )%k == 0)
            return head2;
        if(prevtail!=null)
        prevtail.next = prevhead;
        return head2;
        
    }
    public ListNode reverse(ListNode start)
    {
        ListNode prev = null;
        while(start!=null)
        {
            ListNode next = start.next;
            start.next = prev;
            prev = start;
            start =next;
        }
        return prev;
    }
}