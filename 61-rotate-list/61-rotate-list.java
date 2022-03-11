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
    public ListNode rotateRight(ListNode head, int k) {
        int tot=0;
        if(head==null||k==0||head.next==null)
            return head;
        ListNode temp =head;
        while(temp!=null)
        {
            tot++;
            temp=temp.next;
        }
        if(k==tot)
            return head;
        if(k!=1)
        k=k%tot;
        if(k==0)
            return head;
        k= tot-k;
        
        temp=head;
        ListNode temp2=head.next;
        while(k>1)
        {
            temp=temp.next;temp2=temp.next;k--;
        }
        //System.out.println(temp.val+" "+temp2.val);
        temp.next=null;
        ListNode head2=temp2;
        while(temp2.next!=null)
        {
            temp2=temp2.next;
            
        }
        temp2.next=head;
        return head2;
    }
}