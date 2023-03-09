/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
      set.add(head);
      while(head!=null)
      {
        head= head.next;
        if(set.contains(head))
          return head;
        set.add(head);
      }
      return null;
    }
}