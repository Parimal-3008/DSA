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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode parent = null;ListNode child = null;
        ListNode l1=null; ListNode r1= null;
        int i=1;
        ListNode head2= head;
        ListNode prev = null;
        while(i<=left)
        {
            parent = prev;
            prev = head;
            l1= head;
            head = head.next;            
            i++;            
        }
         // prev = null;
        while(i<=right)
        {
            ListNode next = head.next;
            head.next = prev;
            prev = head;            
            head = next;
            i++;
        }
        if(parent!=null)
        parent.next = prev;
        l1.next = head;
        return left!=1?head2:prev;
        
    }
}