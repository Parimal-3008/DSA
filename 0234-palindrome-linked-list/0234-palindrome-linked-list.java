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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode head2 = head;
        int len = 0;
        while(fast!=null && fast.next!=null)
        {
            len+=2;
            slow = slow.next;
            fast= fast.next.next;
        }
        ListNode prev = null;
        while(slow!=null)
        {
                ListNode next = slow.next;
                slow.next = prev;
            prev = slow;
            slow = next;
            
        }
        while(prev!=null && head2!=null)
        {
            if(head2.val!=prev.val)
                return false;
            head2=head2.next;
            prev = prev.next;
        }
        return true;
       
    }
}