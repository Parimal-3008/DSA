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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         int carry=0;
        ListNode p=new ListNode(0);ListNode res=p;
        while(l1!=null&&l2!=null)
        {
            int sum=l1.val+l2.val+carry;
            
            res.val=sum%10;
            if(sum>9)
                carry=1;
            else
                carry=0;
             l1=l1.next;
            l2=l2.next;
            if(l1==null&&l2==null)
               {
            if(carry==1)
                        res.next=new ListNode(1);
             break;
            }
            res.next=new ListNode(0);
            res=res.next;
           
            
        }
        if(l1!=null)
        {
            while(l1!=null)
            {
                res.val=(l1.val+carry)%10;
              carry=(l1.val+carry)/10;
                l1=l1.next;
               
                if(l1!=null){
                    res.next=new ListNode(0);res=res.next;}
                else
                {
                    if(carry==1)
                        res.next=new ListNode(1);
                }
                
            }
        }
        else if(l2!=null)
        {
            while(l2!=null)
            {
                res.val=(l2.val+carry)%10;
              carry=(l2.val+carry)/10;
                l2=l2.next;
               
                if(l2!=null){
                    res.next=new ListNode(0);res=res.next;}
                else
                {
                    if(carry==1)
                        res.next=new ListNode(1);
                }
                
            }
        }
        
        return p;
    }
}