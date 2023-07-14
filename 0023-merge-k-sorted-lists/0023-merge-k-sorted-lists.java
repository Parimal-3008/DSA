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
    class edgecom implements Comparator<ListNode>
    {
        @Override
        public int compare(ListNode l1, ListNode l2)
        {
            return Integer.compare(l1.val,l2.val);
        }
    }
    public ListNode mergeKLists(ListNode[] arr) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new edgecom());
        for(ListNode i:arr)
        {
            while(i!=null)
              {  pq.add(i);i=i.next;}
        }
        ListNode head = pq.poll();
        ListNode curr = head;;
        while(!pq.isEmpty())
        {
            curr.next = pq.poll();
            curr= curr.next;
        }
        if(curr!=null)
        curr.next = null;
        return head;
    }
}