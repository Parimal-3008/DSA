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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
              return head;
        ListNode temp = head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null)
        {
            temp=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        //splitting of list in 2 halves
        temp.next=null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        //now again merging them as per ther order
        return merge(left,right);      
    }
    public ListNode merge(ListNode l1, ListNode l2)
    {
        ListNode temp2= new ListNode(0);
        ListNode temp= temp2;
        while(l1!=null &&l2!=null)
        {
            if(l1.val<l2.val)
            {
                temp.next=l1;
                l1=l1.next;
            }
            //if(l1.val<l2.val)
           else {
                temp.next=l2;
               l2=l2.next;
            }
             temp=temp.next;
        }
        if(l1!=null)
        {
            temp.next=l1;
        }
        if(l2!=null)
            temp.next=l2;
        return temp2.next;
        
    }
    
}