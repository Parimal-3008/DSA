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
    public void reorderList(ListNode head) {
        List<ListNode> list = new LinkedList<>();
        ListNode t= head;
        while(t!=null)
        {
            list.add(t);
           
            t= t.next;
        }
        int l= 0;
        int r= list.size()-1;
        ListNode temp=new ListNode();
        while(l<r)
        {
            ListNode a= list.get(l);
            ListNode b= list.get(r);
           a.next=null;b.next=null;
            temp.next=a;
            a.next=b;
            temp=b;
            l++;r--;
        }
       if(list.size()%2==1)
       {
           ListNode a= list.get(list.size()/2);
           temp.next=a;
           a.next=null;
       }
       
    }
}